package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.DataDealService;
import com.lrs.admin.service.NewUserService;
import org.apache.commons.lang.time.DateFormatUtils;
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
import java.util.Set;

/**
 * @Author:wanglei1
 * @Date: 2018/12/1 15:12
 */
@RestController
public class DataStoreController {
    private static Logger logger = LoggerFactory.getLogger(DataStoreController.class);
    @Resource
    private NewUserService newUserService;
    @Resource
    private DataDealService dataDealService;
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public HashMap<String,Object> dataStore(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String data = request.getParameter("data");
        String username = request.getParameter("username");
        if (StringUtils.isEmpty(username)){
            return ResponseModel.getModel("无法获取用户", "error", null);
        }
        Maunfacturer maunfacturer = newUserService.select(username);
        if (maunfacturer == null){
            return ResponseModel.getModel("无该用户名称，请联系管理员", "error", null);
        }
        int firmid = maunfacturer.getFirmId();
        long timeStamp = System.currentTimeMillis();
        String tagTime =  DateFormatUtils.format(timeStamp, "yyyy-MM-dd HH:mm:ss");
        JSONObject jsonObject = JSONObject.parseObject(data);
        Set<String> set = jsonObject.keySet();
        for (String classifyid : set){
            JSONObject json = jsonObject.getJSONObject(classifyid);
            for (String categoryid : json.keySet()){
                Float volume = json.getFloatValue("volume");
                DataRecord dataRecord = new DataRecord();
                dataRecord.setFirmId(firmid);
                dataRecord.setTagTime(tagTime);
                dataRecord.setCategoryId(categoryid);
                dataRecord.setClassifyId(classifyid);
                dataRecord.setProductVolume(volume);
                dataDealService.insertDataRecord(dataRecord);
            }
        }
        return null;
    }
}