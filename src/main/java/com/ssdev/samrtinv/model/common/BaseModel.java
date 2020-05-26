package com.ssdev.samrtinv.model.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

@MappedSuperclass
public class BaseModel {
    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "created_on", nullable = false)
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "updated_by")
    private Long updatedBy;

    private Status status = Status.ACTIVE;

    @Version
    private Long version;

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

