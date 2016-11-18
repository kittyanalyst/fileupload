package com.amiti.cloud.user.service;

import com.amiti.cloud.platform.security.LogonUser;

import java.util.Optional;

/**
 * Created by ramchalasani on 11/18/16.
 */
public interface UserService {

    Optional<LogonUser> getUser(String logonId);

}
