package com.lrs.admin.dao.domain;

import lombok.Data;

import java.util.Date;
@Data
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

}