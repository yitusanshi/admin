package com.lrs.admin.dao.domain;

import lombok.Data;

import java.util.Date;

public class TransportRecord {
    private Integer id;

    private Integer firmId;

    private Integer tagTime;

    private String categoryId;

    private Float transportVolume;

    private Float transportDistance;

    private Integer isLoad;

    private String applicant;

    private Date applicantTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirmId() {
        return firmId;
    }

    public void setFirmId(Integer firmId) {
        this.firmId = firmId;
    }

    public Integer getTagTime() {
        return tagTime;
    }

    public void setTagTime(Integer tagTime) {
        this.tagTime = tagTime;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Float getTransportVolume() {
        return transportVolume;
    }

    public void setTransportVolume(Float transportVolume) {
        this.transportVolume = transportVolume;
    }

    public Float getTransportDistance() {
        return transportDistance;
    }

    public void setTransportDistance(Float transportDistance) {
        this.transportDistance = transportDistance;
    }

    public Integer getIsLoad() {
        return isLoad;
    }

    public void setIsLoad(Integer isLoad) {
        this.isLoad = isLoad;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplicantTime() {
        return applicantTime;
    }

    public void setApplicantTime(Date applicantTime) {
        this.applicantTime = applicantTime;
    }
}