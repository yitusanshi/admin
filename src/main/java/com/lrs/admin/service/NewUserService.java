package com.lrs.admin.service;


import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.dao.mapper.MaunfacturerMapper;
import com.lrs.admin.entity.ResponseModel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class NewUserService {

    private Logger logger = LoggerFactory.getLogger(NewUserService.class);
    @Resource
    private BaseService baseService;
    @Resource
    private MaunfacturerMapper maunfacturerMapper;
    public static String PHONE_PATTERN = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\\\d{8}$";
    public static String EMAIL_PATTERN = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
    public HashMap<String,Object> judgeNormal(JSONObject json)  {
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
        if (StringUtils.isEmpty(username)){
            return ResponseModel.getModel("用户名为空", "error", null);
        }
        username = username.trim();
        if (maunfacturerMapper.selectUser(username) != null){
            return ResponseModel.getModel("该用户名已经被注册", "error", null);
        }
        if (StringUtils.isEmpty(password1) || StringUtils.isEmpty(password2)){
            return ResponseModel.getModel("密码不能为空", "error", null);
        }
        if(!password1.equals(password2)){
            return ResponseModel.getModel("两次密码设置不同", "error", null);
        }
        if (StringUtils.isEmpty(firmname)){
            return ResponseModel.getModel("公司名称不能为空", "error", null);
        }
        if (StringUtils.isEmpty(product)){
            return ResponseModel.getModel("请选择产品", "error", null);
        }
        if (StringUtils.isEmpty(address)){
            return ResponseModel.getModel("公司地址不能为空", "error", null);
        }
        if (!StringUtils.isEmpty(phone)){
            boolean b = Pattern.matches(PHONE_PATTERN, phone);
            if (!b){
                return ResponseModel.getModel("手机号格式错误", "error", null);
            }
        }
        if (!StringUtils.isEmpty(email)){
            boolean b = Pattern.matches(EMAIL_PATTERN, email);
            if (!b){
                return ResponseModel.getModel("邮箱格式错误", "error", null);
            }
        }
        if (StringUtils.isEmpty(foundingTime)){
            return ResponseModel.getModel("请选择公司成立日期", "error", null);
        }
        return null;
    }
    public Maunfacturer getObject(JSONObject json){
        String username = json.getString("username");
        String password1 = json.getString("password1");
        String password2 = json.getString("password2");
        String firmname = json.getString("firm_name");
        String product = json.getString("product");
        String productid = json.getString("productid");
        String address = json.getString("address");
        String phone = json.getString("phone");
        String department = json.getString("department");
        String email = json.getString("email");
        String foundingTime = json.getString("founding_time");
        String desc = json.getString("desc");
        Integer grade = json.getInteger("grade");

        Maunfacturer maunfacturer = new Maunfacturer();
        maunfacturer.setUsername(username);
        maunfacturer.setPassword(password1);
        maunfacturer.setFirmName(firmname);
        maunfacturer.setProduct(product);
        maunfacturer.setProductid(productid);
        maunfacturer.setAddress(address);
        maunfacturer.setPhone(phone);
        maunfacturer.setDepartment(department);
        maunfacturer.setEmail(email);
        maunfacturer.setFoundingTime(baseService.parseStringToDate(foundingTime));
        maunfacturer.setDesc(desc);
        maunfacturer.setGrade(grade);
        return maunfacturer;
    }
    public void insertManu(Maunfacturer maunfacturer){
        maunfacturerMapper.insert(maunfacturer);
    }

    public Maunfacturer select(String username){
        Maunfacturer maunfacturer = maunfacturerMapper.selectUser(username);
        return maunfacturer;
    }
    public Maunfacturer selectByFirmId(int firmid){
        Maunfacturer maunfacturer = maunfacturerMapper.selectByFirmId(firmid);
        return  maunfacturer;
    }
    public List<Maunfacturer> selectByGrade(int grade){
        List<Maunfacturer> list = maunfacturerMapper.selectByGrade(grade);
        return list;
    }
    public void updatePassword(int firmid, String password){
        maunfacturerMapper.updatePassword(firmid, password);
    }
    public List<Maunfacturer> selectAll(){
        List<Maunfacturer> list = maunfacturerMapper.selectAll();
        return list;
    }
    public List<Maunfacturer> selectAllByProductid(String productid){
        List<Maunfacturer> list = maunfacturerMapper.selectAllselectAllByProductid(productid );
        return list;
    }
}
