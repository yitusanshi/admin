package com.lrs.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BaseService {
    private static Logger logger = LoggerFactory.getLogger(BaseService.class);
    public Date parseStringToDate(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return simpleDateFormat.parse(time);
        } catch (ParseException e) {
            logger.error("parse date error, date is {}", time);
        }
        return new Date();
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
 }
