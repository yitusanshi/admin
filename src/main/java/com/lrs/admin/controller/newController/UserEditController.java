package com.lrs.admin.controller.newController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.DataDealService;
import com.lrs.admin.service.NewUserService;

@RestController
@RequestMapping("/sys")
public class UserEditController {
    Logger logger = LoggerFactory.getLogger(UserManagerController.class);
    @Resource
    private NewUserService newUserService;
    @Resource
    private DataDealService dataDealService;
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/deluser_by_firmid")
    public HashMap<String, Object> delUser(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String firmid = request.getParameter("firmid");
        int id = Integer.parseInt(firmid);
        logger.info("del firmid is {}", id);
        try{
            newUserService.delManufacturer(id);
            dataDealService.delDataRecord(id);
        }catch (Exception e){
           return ResponseModel.getModel(e.getMessage(), "error", null);
        }
        return ResponseModel.getModel("删除成功", "success", null);
    }

}
