package com.lrs.admin.controller.newController;

import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.NewUserService;
import com.lrs.admin.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;


@RestController
public class UserLoginController {
    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);
    @Resource
    private NewUserService  newUserService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = password.trim();
        if (StringUtils.isEmpty(username)){
            return ResponseModel.getModel("请输入用户名", "error", null);
        }
        if (StringUtils.isEmpty(password)){
            return ResponseModel.getModel("请输入密码", "error", null);
        }
        Maunfacturer maunfacturer = newUserService.select(username);
        if (maunfacturer == null){
            return ResponseModel.getModel("用户名错误", "error", null);
        }
        String pword = maunfacturer.getPassword();
        if (! pword.equals(password)){
            return ResponseModel.getModel("用户名或密码错误", "error", null);
        }
       return  ResponseModel.getModel("登录成功", "success", maunfacturer);
      
    }
    @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    public HashMap<String, Object> editUserPassword(HttpServletRequest request){
        System.out.println("景来额。。。。。。。。。。。。。。。");
    	try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String firmid = request.getParameter("firmid");
        String oldpassword = request.getParameter("oldpassword");
        oldpassword = oldpassword.trim();
        System.out.println(oldpassword);
        String newpassword1 = request.getParameter("newpassword1");
        newpassword1 = newpassword1.trim();
        String newpassword2 = request.getParameter("newpassword2");
        newpassword2 = newpassword2.trim();
        int fid = Integer.valueOf(firmid);
        Maunfacturer maunfacturer = newUserService.selectByFirmId(fid);
        String password = maunfacturer.getPassword();
        if (password.equals(oldpassword)){
            if (newpassword1.equals(newpassword2)){
            	System.out.println(fid+"==========="+newpassword1);
                newUserService.updatePassword(fid, newpassword1);
                return ResponseModel.getModel("修改成功", "success", null);
            }else {
                return ResponseModel.getModel("新密码两次输入不一致", "error", null);
            }
        }else {
            return ResponseModel.getModel("原始密码输入错误", "error", null);
        }
    }
    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public HashMap<String, Object> getUserInfo(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String firmid = request.getParameter("firmid");
        int id = Integer.parseInt(firmid);
        Maunfacturer maunfacturer = newUserService.selectByFirmId(id);
        Date foundingTime = maunfacturer.getFoundingTime();
        String foundingTimeStr = DateUtil.formatDate(foundingTime, "yyyy-MM-dd HH:mm:ss");
        Date registerTime = maunfacturer.getFoundingTime();
        String registerTimestr = DateUtil.formatDate(registerTime, "yyyy-MM-dd HH:mm:ss");
        maunfacturer.setFoundingTimestr(foundingTimeStr);
        maunfacturer.setRegisterTimestr(registerTimestr);
        return ResponseModel.getModel("获取成功", "success", maunfacturer);
    }

}
