package com.amiti.cloud.platform.jpa.reference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Ramakrishna Chalasani on 11/17/16.
 */
@Entity
@Table(name="RF_USER_ROLES")
public class RfUserRole implements Serializable {

    @Id
    @Column(name="CODE", length = 50)
    @Enumerated(EnumType.STRING)
    private String code;

    @Column(name="DESCRIPTION")
    private String description;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RfUserRole that = (RfUserRole) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "RfUserRole{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    public static final class Builder {
        private String code;
        private String description;

        private Builder() {
        }

        public static Builder aRfUserRole() {
            return new Builder();
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public RfUserRole build() {
            RfUserRole rfUserRole = new RfUserRole();
            rfUserRole.setCode(code);
            rfUserRole.setDescription(description);
            return rfUserRole;
        }
    }
}
