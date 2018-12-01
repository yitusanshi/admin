package com.lrs.admin.controller.newController;

import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.NewUserService;
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
        if (!pword.equals(password)){
            return ResponseModel.getModel("用户名或密码错误", "error", null);
        }
       return  ResponseModel.getModel("登录成功", "success", maunfacturer);
      
    }
}
