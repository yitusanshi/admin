package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONObject;

import com.lrs.admin.common.Constants;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.dao.domain.ParamException;
import com.lrs.admin.dao.mapper.MaunfacturerMapper;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;

@RestController
public class UserRegisterController {
    private Logger logger  = LoggerFactory.getLogger(UserRegisterController.class);
    @Resource
    private MaunfacturerMapper maunfacturerMapper;
    @Resource
    private RegisterService registerService;
    @RequestMapping(value = "/regist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public HashMap<String,Object> usrRegister(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }

        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String firm_name = request.getParameter("firm_name");
        String firm_type = request.getParameter("firm_type");
        String address = request.getParameter("address");
        String founding_time = request.getParameter("founding_time");
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password1", password1);
        json.put("password2", password2);
        json.put("firm_name", firm_name);
        json.put("firm_type", Integer.parseInt(firm_type));
        json.put("address", address);
        json.put("founding_time", founding_time);

        HashMap<String,Object> map = registerService.judgeNormal(json);
        if (map != null){
            return map;
        }
        Maunfacturer maunfacturer = registerService.getObject(json);
        try{
            registerService.insertManu(maunfacturer);
        }catch (Exception e){
            logger.error("register error, username is {}", username);
            return ResponseModel.getModel("注册失败，请联系管理员", "error", null);
        }

        return ResponseModel.getModel("注册成功", "success", null);
    }


}
