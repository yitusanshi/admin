package com.lrs.admin.dao.domain;

import lombok.Data;

import java.util.Date;
@Data
public class ProCategory {
    private Integer categoryId;

    private Integer classifyId;

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

}