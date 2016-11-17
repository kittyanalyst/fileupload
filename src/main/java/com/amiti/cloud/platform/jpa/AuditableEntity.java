package com.amiti.cloud.platform.jpa;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ramakrishna Chalasani on 11/17/16.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity implements Serializable  {

    @Column(name="CREATED_BY", length=15, nullable = false, updatable = true)
    @CreatedBy
    protected String createdBy;

    @Column(name="CREATED_DATE", nullable = false, updatable = true)
    @CreatedDate
    protected Date createdDate;

    @Column(name="LAST_UPDATED_BY", length = 15, nullable = false, updatable = true)
    @LastModifiedBy
    protected String lastUpdatedBy;

    @Column(name="LAST_UDPATED_DATE", nullable = false, updatable = true)
    protected Date lastUpdatedDate;


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
