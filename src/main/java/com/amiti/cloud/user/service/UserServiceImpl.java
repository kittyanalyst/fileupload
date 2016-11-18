package com.amiti.cloud.user.service;


import com.amiti.cloud.platform.security.LogonUser;
import com.amiti.cloud.user.persistence.domain.User;
import com.amiti.cloud.user.persistence.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by ramchalasani on 11/18/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService,
        AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    @Autowired
    UserRespository userRespository;


    @Override
    @Transactional(readOnly = true)
    public Optional<LogonUser> getUser(String logonId) {
        return userRespository.findOneByLogonId(logonId).map(
            user -> LogonUser.Builder.aLogonUser()
                    .withLogonId(user.getLogonId())
                    .build()
            );

    }

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
          return loadUserByUsername((String) token.getPrincipal());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUser(username).orElseThrow(() -> new UsernameNotFoundException(" No User Found for LogonId :" + username));
    }


}
