package com.amiti.cloud.user.persistence.domain;

import com.amiti.cloud.platform.jpa.AuditableEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Ramakrishna Chalasani 11/17/2016
 */
@Entity
@Table (name="USERS")
public class User extends AuditableEntity {

    @Id
    @SequenceGenerator(name="SEQ_USER_ID_GEN", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USER_ID_GEN")
    @Column (name="USER_ID")
    private Long userId;

    @Column(name="LOGON_ID", nullable = false, length = 15)
    private String logonId;

    @Column(name="FIRST_NAME", length = 50)
    private String firstName;

    @Column(name="LAST_NAME", length = 50)
    private String lastName;

    @Column(name="MIDDLE_NAME", length = 50)
    private String middleName;

    @Column(name="EMAIL", length = 100)
    private String email;

    @Column (name="PASSWORD")
    private String password;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogonId() {
        return logonId;
    }

    public void setLogonId(String logonId) {
        this.logonId = logonId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userId.equals(user.userId)) return false;
        if (!logonId.equals(user.logonId)) return false;
        return email != null ? email.equals(user.email) : user.email == null;

    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + logonId.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", logonId='" + logonId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public static final class Builder {
        private static Logger logger = LoggerFactory.getLogger(User.class);
        protected String createdBy;
        protected Date createdDate;
        protected String lastUpdatedBy;
        protected Date lastUpdatedDate;
        private Long userId;
        private String logonId;
        private String firstName;
        private String lastName;
        private String middleName;
        private String email;
        private String password;

        private Builder() {
        }

        public static Builder anUser() {
            return new Builder();
        }

        public Builder withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder withLogonId(String logonId) {
            this.logonId = logonId;
            return this;
        }

        public Builder withLastUpdatedBy(String lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withLastUpdatedDate(Date lastUpdatedDate) {
            this.lastUpdatedDate = lastUpdatedDate;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            User user = new User();
            user.setCreatedBy(createdBy);
            user.setUserId(userId);
            user.setCreatedDate(createdDate);
            user.setLogonId(logonId);
            user.setLastUpdatedBy(lastUpdatedBy);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLastUpdatedDate(lastUpdatedDate);
            user.setMiddleName(middleName);
            user.setEmail(email);
            user.setPassword(password);
            return user;
        }
    }
}
