package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONObject;

import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.NewUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRegisterController {
    private Logger logger = LoggerFactory.getLogger(UserRegisterController.class);
    protected static Map<String, String> map = new HashMap() {
        {
            put("1", "钢帘线_供应商");
            put("2", "合成橡胶_丁苯橡胶_供应商");
            put("3", "合成橡胶_顺丁橡胶_供应商");
            put("4", "尼龙帘布_供应商");
            put("5", "胎圈钢丝_供应商");
            put("6", "炭黑_供应商");
            put("7", "天然橡胶_供应商");
            put("8", "轮胎生产_生产商");
            put("9", "再生胶_回收商");
            put("10", "轮胎生产_生产商_子午线");
            put("11", "轮胎生产_生产商_斜交线");
        }
    };

    @Resource
    private NewUserService newUserService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public HashMap<String, Object> usrRegister(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }

        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        password1 = password1.trim();
        String password2 = request.getParameter("password2");
        password2 = password2.trim();
        String firm_name = request.getParameter("firm_name");
        String firm_type = request.getParameter("firm_type");
        String address = request.getParameter("address");
        String founding_time = request.getParameter("founding_time");
        String productid = request.getParameter("productid");
        String phone = request.getParameter("phone");


        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password1", password1);
        json.put("password2", password2);
        json.put("firm_name", firm_name);
        json.put("address", address);
        json.put("phone", phone);
        json.put("founding_time", founding_time);
        //int pid = Integer.parseInt(productid);
        json.put("productid", productid);
        if (map.containsKey(productid)) {
            json.put("product", map.get(productid));
        }
        if (productid.equals("8") || productid.equals("9")) {
            json.put("grade", 2);
        } else {
            json.put("grade", 1);
        }
        HashMap<String, Object> map = newUserService.judgeNormal(json);
        if (map != null) {
            return map;
        }
        Maunfacturer maunfacturer = newUserService.getObject(json);
        try {
            newUserService.insertManu(maunfacturer);
        } catch (Exception e) {
            logger.error("register error, username is {}, reason is {}", username, e);
            return ResponseModel.getModel("注册失败，请联系管理员", "error", null);
        }

        return ResponseModel.getModel("注册成功", "success", null);
    }


}
