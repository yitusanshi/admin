package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.entity.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * @Author:wanglei1
 * @Date: 2018/12/1 15:12
 */
@RestController
public class DataStoreController {
    private static Logger logger = LoggerFactory.getLogger(DataStoreController.class);
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public HashMap<String,Object> dataStore(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String data = request.getParameter("data");
        JSONObject json = JSONObject.parseObject(data);
        return null;
    }
}
