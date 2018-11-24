package com.lrs.admin.service;


import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.common.Constants;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.dao.domain.ParamException;
import com.lrs.admin.dao.mapper.MaunfacturerMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.regex.Pattern;

@Service
public class RegisterService {

    private Logger logger = LoggerFactory.getLogger(RegisterService.class);
    @Resource
    private BaseService baseService;
    @Resource
    private MaunfacturerMapper maunfacturerMapper;
    public static String PHONE_PATTERN = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\\\d{8}$";
    public static String EMAIL_PATTERN = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
    public void judgeNormal(JSONObject json) throws ParamException {
        String username = json.getString("username");
        String password1 = json.getString("password1");
        String password2 = json.getString("password2");
        String firmname = json.getString("firm_name");
        String product = json.getString("product");
        String address = json.getString("address");
        String phone = json.getString("phone");
        String department = json.getString("department");
        String email = json.getString("email");
        String foundingTime = json.getString("founding_time");
        String desc = json.getString("desc");
        Maunfacturer maunfacturer = new Maunfacturer();
        if (StringUtils.isEmpty(username)){
            throw new ParamException(Constants.ERROR_CODE, "用户名为空");
        }
        username = username.trim();
        if (maunfacturerMapper.selectUser(username) != null){
            throw new ParamException(Constants.ERROR_CODE, "该用户名已经被注册");
        }
        if (StringUtils.isEmpty(password1) || StringUtils.isEmpty(password2)){
            throw new ParamException(Constants.ERROR_CODE, "密码不能为空");
        }
        if(!password1.equals(password2)){
            throw new ParamException(Constants.ERROR_CODE, "两次密码设置不同");
        }
        if (StringUtils.isEmpty(firmname)){
            throw new ParamException(Constants.ERROR_CODE, "公司名称不能为空");
        }
        if (StringUtils.isEmpty(product)){
            throw new ParamException(Constants.ERROR_CODE, "请选择产品");
        }
        if (StringUtils.isEmpty(address)){
            throw new ParamException(Constants.ERROR_CODE, "公司地址不能为空");
        }
        if (!StringUtils.isEmpty(phone)){
            boolean b = Pattern.matches(PHONE_PATTERN, phone);
            if (!b){
                throw new ParamException(Constants.ERROR_CODE, "手机号格式错误");
            }
        }
        if (!StringUtils.isEmpty(email)){
            boolean b = Pattern.matches(EMAIL_PATTERN, email);
            if (!b){
                throw new ParamException(Constants.ERROR_CODE, "邮箱格式错误");
            }
        }
        if (StringUtils.isEmpty(foundingTime)){
            throw new ParamException(Constants.ERROR_CODE, "请选择公司成立日期");
        }
    }
    public Maunfacturer getObject(JSONObject json){
        String username = json.getString("username");
        String password1 = json.getString("password1");
        String password2 = json.getString("password2");
        String firmname = json.getString("firm_name");
        String product = json.getString("product");
        String address = json.getString("address");
        String phone = json.getString("phone");
        String department = json.getString("department");
        String email = json.getString("email");
        String foundingTime = json.getString("founding_time");
        String desc = json.getString("desc");
        Maunfacturer maunfacturer = new Maunfacturer();
        maunfacturer.setUsername(username);
        maunfacturer.setPassword(password1);
        maunfacturer.setFirmName(firmname);
        maunfacturer.setProduct(product);
        maunfacturer.setAddress(address);
        maunfacturer.setPhone(phone);
        maunfacturer.setDepartment(department);
        maunfacturer.setEmail(email);
        maunfacturer.setFoundingTime(baseService.parseStringToDate(foundingTime));
        maunfacturer.setDesc(desc);
        return maunfacturer;
    }
}
