package com.lrs.admin.dao.domain;

import lombok.Data;

import java.util.Date;
@Data
public class ProClassify {
    private Integer classifyId;

    private String classifyName;

    private String classifyDesc;

    private Date insertTime;
}