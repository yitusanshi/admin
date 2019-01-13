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
import java.util.*;

/**
 * @Author:wanglei1
 * @Date: 2018/12/1  15:12
 */
@RestController
public class DataStoreController {
    private static Logger logger = LoggerFactory.getLogger(DataStoreController.class);
    @Resource
    private NewUserService newUserService;
    @Resource
    private DataDealService dataDealService;
 /*   @RequestMapping(value = "/store", method = RequestMethod.POST)
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
               //  dataDealService.insertDataRecord(dataRecord);
            }
        }
        return null;
    }*/


    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public HashMap<String,Object> dataStoretest(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String username = request.getParameter("username");
        String dataYear = request.getParameter("datayear");
        if (StringUtils.isEmpty(username)){
            return ResponseModel.getModel("无法获取用户", "error", null);
        }
        Maunfacturer maunfacturer = newUserService.select(username);
        if (maunfacturer == null){
            return ResponseModel.getModel("无该用户名称，请联系管理员", "error", null);
        }
        Map<String, String[]> requestMap = request.getParameterMap();
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, String[]> entry : requestMap.entrySet()){
           String key = entry.getKey();
           if (key.contains("records[")){
               System.out.println(key);
               String value = request.getParameter(key);
               String s = key.substring(8,9);
               jsonObject.put(s, value);
           }
        }

        int firmid = maunfacturer.getFirmId();
        long timeStamp = System.currentTimeMillis();
        String tagTime =  DateFormatUtils.format(timeStamp, "yyyy-MM-dd HH:mm:ss");
        Set<String> set = jsonObject.keySet();
        Map<String, HashMap<String, Object>> map = new HashMap<>();
        for (String classifyid : set) {
            JSONObject json = jsonObject.getJSONObject(classifyid);
            for (String key : json.keySet()) {
                String[] keyarr = key.split("_");
                Object value = json.get(key);
                String name = keyarr[0];
                System.out.println(key+"=================");
                String categoryid = keyarr[1];
                if (map.containsKey(categoryid)) {
                    HashMap<String, Object> innermap = map.get(categoryid);
                    innermap.put(name, value);
                } else {
                    HashMap<String, Object> innermap = new HashMap<>();
                    innermap.put(name, value);
                    innermap.put("classifyid", classifyid);
                    map.put(categoryid, innermap);
                }
            }
        }
        List<DataRecord> list = new ArrayList<>();
        for (String categoryid : map.keySet()){
            HashMap<String, Object> innermap = map.get(categoryid);
            if (innermap == null || innermap.isEmpty()){
                continue;
            }
            for (String key : innermap.keySet()){
                System.out.println(key + "===" + innermap.get(key));
            }
            System.out.println("77777777777777===="+(String) innermap.get("classifyid"));
            
            String value = (String) innermap.get("value");
            Float volume = Float.parseFloat(value);
            String datasouce = (String) innermap.get("datasouce");
            String desc = (String) innermap.get("desc");
            String classifyid = (String) innermap.get("classifyid");
            DataRecord dataRecord = new DataRecord();
            dataRecord.setFirmId(firmid);
            dataRecord.setTagTime(tagTime);
            dataRecord.setCategoryId(categoryid);
            dataRecord.setClassifyId(classifyid);
            dataRecord.setProductVolume(volume);
            dataRecord.setDataSource(datasouce);
            dataRecord.setRemark(desc);
            dataRecord.setDataYear(dataYear);
            list.add(dataRecord);
        }
        dataDealService.insertDataRecord(list);


                /*Float volume = json.getFloatValue("volume");
                DataRecord dataRecord = new DataRecord();
                dataRecord.setFirmId(firmid);
                dataRecord.setTagTime(tagTime);
                dataRecord.setCategoryId(categoryid);
                dataRecord.setClassifyId(classifyid);
                dataRecord.setProductVolume(volume);
                dataDealService.insertDataRecord(dataRecord);*/
          return ResponseModel.getModel("录入成功", "success", null);
    }
}
