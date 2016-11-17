package com.amiti.cloud.platform.jpa;

import com.amiti.cloud.platform.security.LogonUser;
import com.amiti.cloud.platform.security.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;

/**
 * Created by Ramakrishna Chalasani on 11/17/16.
 */
public class LogonAuditAware  implements AuditorAware<String> {

    private static final Logger logger = LoggerFactory.getLogger(LogonAuditAware.class);

    @Override
    public String getCurrentAuditor() {
        LogonUser loggedInUser = SecurityUtils.getLoggedInUser();

        return loggedInUser != null ? loggedInUser.getLogonId() : null;
    }
}
