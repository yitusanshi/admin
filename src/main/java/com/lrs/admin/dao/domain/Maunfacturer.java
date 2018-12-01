package com.lrs.admin.dao.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Maunfacturer {
    private Integer firmId;

    private String username;

    private String password;

    private String firmName;

    private String product;

    private String productid;

    private String address;

    private String phone;

    private String department;

    private String email;

    private Date foundingTime;

    private Date registerTime;

    private Date updateTime;

    private String desc;

    private Integer grade;

}