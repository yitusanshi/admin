package com.lrs.admin.dao.domain;

import lombok.Data;

import java.util.Date;

public class ProCategory {
    private Integer id;

    private String categoryId;

    private String classifyId;

    private String categoryName;

    private String unit;

    private String desc;

    private Integer steelCord;

    private Integer sbrRubber;

    private Integer cisRubber;

    private Integer nylonCord;

    private Integer beadWire;

    private Integer carbonBlack;

    private Integer naturalRubber;

    private Integer tyreProduce;

    private Integer reclaRubber;

    private Date insertTime;

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

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getSteelCord() {
        return steelCord;
    }

    public void setSteelCord(Integer steelCord) {
        this.steelCord = steelCord;
    }

    public Integer getSbrRubber() {
        return sbrRubber;
    }

    public void setSbrRubber(Integer sbrRubber) {
        this.sbrRubber = sbrRubber;
    }

    public Integer getCisRubber() {
        return cisRubber;
    }

    public void setCisRubber(Integer cisRubber) {
        this.cisRubber = cisRubber;
    }

    public Integer getNylonCord() {
        return nylonCord;
    }

    public void setNylonCord(Integer nylonCord) {
        this.nylonCord = nylonCord;
    }

    public Integer getBeadWire() {
        return beadWire;
    }

    public void setBeadWire(Integer beadWire) {
        this.beadWire = beadWire;
    }

    public Integer getCarbonBlack() {
        return carbonBlack;
    }

    public void setCarbonBlack(Integer carbonBlack) {
        this.carbonBlack = carbonBlack;
    }

    public Integer getNaturalRubber() {
        return naturalRubber;
    }

    public void setNaturalRubber(Integer naturalRubber) {
        this.naturalRubber = naturalRubber;
    }

    public Integer getTyreProduce() {
        return tyreProduce;
    }

    public void setTyreProduce(Integer tyreProduce) {
        this.tyreProduce = tyreProduce;
    }

    public Integer getReclaRubber() {
        return reclaRubber;
    }

    public void setReclaRubber(Integer reclaRubber) {
        this.reclaRubber = reclaRubber;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}