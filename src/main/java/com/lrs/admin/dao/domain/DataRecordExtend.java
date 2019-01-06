package com.lrs.admin.dao.domain;

import java.util.Date;

public class DataRecordExtend {
    private Integer id;

    private Integer firmId;

    private String tagTime;

    private String categoryId;

    private String classifyId;

    private Float productVolume;

    private String dataSource;

    private String remark;

    private Date applicantTime;

    private int isPass = 0;

    private Float reference;

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

    public String getTagTime() {
        return tagTime;
    }

    public void setTagTime(String tagTime) {
        this.tagTime = tagTime;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public Float getProductVolume() {
        return productVolume;
    }

    public void setProductVolume(Float productVolume) {
        this.productVolume = productVolume;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getApplicantTime() {
        return applicantTime;
    }

    public void setApplicantTime(Date applicantTime) {
        this.applicantTime = applicantTime;
    }

    public int getIsPass() {
        return isPass;
    }

    public void setIsPass(int isPass) {
        this.isPass = isPass;
    }

    public Float getReference() {
        return reference;
    }

    public void setReference(Float reference) {
        this.reference = reference;
    }
}
