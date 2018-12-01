package com.lrs.admin.dao.domain;

import lombok.Data;

import java.util.Date;
@Data
public class DataRecord {
    private Integer id;

    private Integer firmId;

    private String tagTime;

    private String categoryId;

    private String classifyId;

    private Float productVolume;

    private String dataSource;

    private String remark;

    private Date applicantTime;

}