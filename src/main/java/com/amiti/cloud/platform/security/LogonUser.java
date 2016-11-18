package com.amiti.cloud.platform.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by rchalas on 11/17/16.
 */
public class LogonUser implements UserDetails {

    private String logonId;

    public String getLogonId() { return logonId; }
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.logonId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public static final class Builder {
        private String logonId;

        private Builder() {
        }

        public static Builder aLogonUser() {
            return new Builder();
        }

        public Builder withLogonId(String logonId) {
            this.logonId = logonId;
            return this;
        }

        public LogonUser build() {
            LogonUser logonUser = new LogonUser();
            logonUser.logonId = this.logonId;
            return logonUser;
        }
    }
}
