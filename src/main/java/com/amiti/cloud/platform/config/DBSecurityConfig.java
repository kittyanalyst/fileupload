package com.amiti.cloud.platform.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by ramchalasani on 11/4/16.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ConditionalOnProperty(value = "authentication_method", havingValue = "DB", matchIfMissing = true)
public class DBSecurityConfig  extends WebSecurityConfigurerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(DBSecurityConfig.class);

    @Autowired
    private UserDetailsService userDetailsService;

}
