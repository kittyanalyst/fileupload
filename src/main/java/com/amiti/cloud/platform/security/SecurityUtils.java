package com.amiti.cloud.platform.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Ramakrishna Chalasani on 11/17/16.
 */
public class SecurityUtils {
    public static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    public final static String X_LOGON_ID = "X-Logon-Id";

    private SecurityUtils() {}

    public static LogonUser getLoggedInUser() {

        logger.debug("Getting the user id of authenticated user.");

        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (securityContext == null) {
            logger.debug("Spring security context does not exist.  Returning null.");
            return null;
        }

        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            logger.debug("Current user is anonymous.  Returning null.");
            return null;
        }

        if (!(authentication.getPrincipal() instanceof LogonUser)) {
            logger.debug("Current user is anonymous.  Returning null.");
            return null;
        }

        return (LogonUser)authentication.getPrincipal();
    }

}
