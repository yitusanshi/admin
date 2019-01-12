package com.lrs.admin.dao.domain;

import java.util.Date;

public class EnergyConsume {
    private Integer id;

    private String categoryId;

    private Float ratio;

    private String unit;

    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}