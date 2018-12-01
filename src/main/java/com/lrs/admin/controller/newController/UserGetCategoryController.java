package com.lrs.admin.controller.newController;

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

/**
 * @Author:wanglei1
 * @Date: 2018/12/1 15:22
 */
@RestController
public class UserGetCategoryController {
    private Logger logger = LoggerFactory.getLogger(UserGetCategoryController.class);
    @Resource
    private NewUserService newUserService;
    @RequestMapping(value = "getcategory", method = RequestMethod.POST)
    public HashMap<String, Object> getCategory(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String username = request.getParameter("username");
        if (StringUtils.isEmpty(username)){
            return ResponseModel.getModel("无法获取用户", "error", null);
        }
        Maunfacturer maunfacturer = newUserService.select(username);
        if (maunfacturer == null){
            return ResponseModel.getModel("无该用户名称，请联系管理员", "error", null);
        }
        logger.info("{} is getting category, time is {}", username, System.currentTimeMillis());
        return null;
    }
}
