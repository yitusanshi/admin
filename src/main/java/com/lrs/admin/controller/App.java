package com.lrs.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.controller.newController.UserGetCategoryController;
import com.lrs.admin.controller.newController.UserGetDataController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;

/**
 * @Author:wanglei1
 * @Date: 2018/12/8 10:31
 */
@Service
public class App implements InitializingBean {
    @Resource
    private UserGetCategoryController userGetCategoryController;
    @Resource
    private UserGetDataController userGetDataController;
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(111111);
        //String s = userGetDataController.getnewData(null,  "用户2");
       //JSONObject jsonObject = userGetCategoryController.getCategory(null, "用户2");
        System.out.println(222222);
    }

    public static void main(String[] args) {
        System.out.println(0);
    }
}
