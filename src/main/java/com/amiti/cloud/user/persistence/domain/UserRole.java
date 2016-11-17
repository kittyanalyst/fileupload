package com.amiti.cloud.user.persistence.domain;

import com.amiti.cloud.platform.jpa.AuditableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Ramakrishna Chalasani on 11/17/16.
 */
@Entity
@Table(name="USER_ROLE_MAP")
public class UserRole extends AuditableEntity {

    @Id
    @SequenceGenerator(name="SEQ_USER_ROLE_MAP_ID_GEN", sequenceName = "USER_ROLE_MAP_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USER_ROLE_MAP_ID_GEN")
    @Column(name="USER_ROLE_MAP_ID")
    private Long userRoleMapId;

    @Column(name="USER_ID", nullable = false)
    private Long userId;

    @Column(name="ROLE_CODE", nullable = false)
    private String roleCode;


    public Long getUserRoleMapId() {
        return userRoleMapId;
    }

    public void setUserRoleMapId(Long userRoleMapId) {
        this.userRoleMapId = userRoleMapId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (userRoleMapId != null ? !userRoleMapId.equals(userRole.userRoleMapId) : userRole.userRoleMapId != null)
            return false;
        if (userId != null ? !userId.equals(userRole.userId) : userRole.userId != null) return false;
        return roleCode != null ? roleCode.equals(userRole.roleCode) : userRole.roleCode == null;

    }

    @Override
    public int hashCode() {
        int result = userRoleMapId != null ? userRoleMapId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleMapId=" + userRoleMapId +
                ", userId=" + userId +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }


    public static final class Builder {
        protected String createdBy;
        protected Date createdDate;
        protected String lastUpdatedBy;
        protected Date lastUpdatedDate;
        private Long userRoleMapId;
        private Long userId;
        private String roleCode;

        private Builder() {
        }

        public static Builder anUserRole() {
            return new Builder();
        }

        public Builder withUserRoleMapId(Long userRoleMapId) {
            this.userRoleMapId = userRoleMapId;
            return this;
        }

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder withRoleCode(String roleCode) {
            this.roleCode = roleCode;
            return this;
        }

        public Builder withCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder withLastUpdatedBy(String lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder withLastUpdatedDate(Date lastUpdatedDate) {
            this.lastUpdatedDate = lastUpdatedDate;
            return this;
        }

        public UserRole build() {
            UserRole userRole = new UserRole();
            userRole.setUserRoleMapId(userRoleMapId);
            userRole.setUserId(userId);
            userRole.setCreatedBy(createdBy);
            userRole.setRoleCode(roleCode);
            userRole.setCreatedDate(createdDate);
            userRole.setLastUpdatedBy(lastUpdatedBy);
            userRole.setLastUpdatedDate(lastUpdatedDate);
            return userRole;
        }
    }
}
