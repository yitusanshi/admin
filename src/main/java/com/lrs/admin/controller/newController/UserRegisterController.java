package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONObject;

import com.lrs.admin.common.Constants;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.dao.domain.ParamException;
import com.lrs.admin.dao.mapper.MaunfacturerMapper;
import com.lrs.admin.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserRegisterController {
    @Resource
    private MaunfacturerMapper maunfacturerMapper;
    @Resource
    private RegisterService registerService;
    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public ParamException usrRegister(@RequestBody String str){
        if (StringUtils.isEmpty(str)){
            return new ParamException(Constants.ERROR_CODE, "请输入数据");
        }
        JSONObject json = null;
        try{
            json = JSONObject.parseObject(str);
        }catch (Exception e){
            return new ParamException(Constants.ERROR_CODE, "注册失败，请联系管理员");
        }
        try {
            registerService.judgeNormal(json);
        } catch (ParamException e) {
            return e;
        }
        Maunfacturer maunfacturer = registerService.getObject(json);

        return new ParamException(Constants.RIGHT_CODE, "注册成功");
    }


}
