package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.dao.domain.ProCategory;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.DataDealService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:wanglei1
 * @Date: 2018/12/1 19:40
 */
@RestController
public class UserGetDataController {
    private Logger logger = LoggerFactory.getLogger(UserGetCategoryController.class);
    @Resource
    private NewUserService newUserService;
    @Resource
    private DataDealService dataDealService;

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    public HashMap<String, Object> getData(HttpServletRequest request){
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
        String productid = maunfacturer.getProductid();
        String productName = UserRegisterController.map.get(productid);
        if (maunfacturer == null){
            return ResponseModel.getModel("无该用户名称，请联系管理员", "error", null);
        }
        logger.info("{} is getting category, time is {}", username, System.currentTimeMillis());
        Integer firmId = maunfacturer.getFirmId();
        List<DataRecord> list = dataDealService.selectGroupByFirmId(firmId);
        JSONObject json = new JSONObject();
        for (DataRecord dataRecord : list){
            String tagTime = dataRecord.getTagTime();
            json.put(tagTime, productName);
        }
        return ResponseModel.getModel("返回数据成功", "success", json.toJSONString());
    }
    @RequestMapping(value = "getdatarecord", method = RequestMethod.POST)
    public String  getnewData(Model model){
        Map<String, Object> modelmap = model.asMap();
        String username = (String) modelmap.get("username");
        if (StringUtils.isEmpty(username)){
            model.addAttribute("msg", "error");
            return "";
        }
        Maunfacturer maunfacturer = newUserService.select(username);
        if (maunfacturer == null){
            model.addAttribute("msg", "error");
            return "";
        }
        List<JSONObject> list = new ArrayList<>();
        if (maunfacturer.getGrade() == 0){
            List<Maunfacturer> maunfacturers = newUserService.selectAll();
            List<DataRecord> listrecord = dataDealService.selectUniqueTag();
            for (DataRecord dataRecord : listrecord){
                JSONObject json = new JSONObject();
                for (Maunfacturer maunf : maunfacturers){
                    if (dataRecord.getFirmId().equals(maunf.getFirmId())){
                        json.put("maunfacturer", maunf);
                        json.put("tagTime", dataRecord.getTagTime());
                        json.put("ispass", 0);
                        List<DataRecordCategory> dataRecordCategoryList = dataDealService.selectDetail(dataRecord.getFirmId(), dataRecord.getTagTime());
                        json.put("data", dataRecordCategoryList);
                        list.add(json);
                    }

                }
            }
        }
        model.addAttribute("list", list);
        return "";
    }


    @RequestMapping(value = "/getdetailData", method = RequestMethod.POST)
    public HashMap<String, Object> getDetailData(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String username = request.getParameter("username");
        String tagtime = request.getParameter("tagtime");
        if (StringUtils.isEmpty(username)){
            return ResponseModel.getModel("无法获取用户", "error", null);
        }
        Maunfacturer maunfacturer = newUserService.select(username);
        int firmid = maunfacturer.getFirmId();
        List<DataRecord> list = dataDealService.selectDetailData(firmid, tagtime);
        JSONObject allJson = new JSONObject();
        for (DataRecord dataRecord : list){
            String classifyid = dataRecord.getClassifyId();
            String categoryId = dataRecord.getCategoryId();
            Double volumn = dataRecord.getProductVolume();
            ProCategory proCategory = dataDealService.getProCategoryDetail(categoryId);
            String categoryName = proCategory.getCategoryName();
            String unit = proCategory.getUnit();
            if (allJson.containsKey(classifyid)){
                JSONObject json = allJson.getJSONObject(classifyid);
                JSONObject jsonObj = new JSONObject();
                jsonObj.put(categoryId, volumn);
                jsonObj.put(categoryName, unit);
                json.put(classifyid, jsonObj);
            }else {
                JSONObject json = new JSONObject();
                JSONObject jsonObj = new JSONObject();
                jsonObj.put(categoryId, volumn);
                jsonObj.put(categoryName, unit);
                json.put(classifyid, json);
                allJson.put(classifyid, json);
            }
        }
        return ResponseModel.getModel("获取数据成功", "success", allJson.toJSONString());
    }
    @RequestMapping(value = "/getRecordData" , method = RequestMethod.POST)
    public HashMap<String, Object> getRecordData(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String tagTime = request.getParameter("tagTime");
        int firmId = Integer.valueOf(request.getParameter("firmId"));
        String dataYear = request.getParameter("dataYear");
        List<DataRecordCategory> list = dataDealService.getRecordData(tagTime, firmId, dataYear);
        return ResponseModel.getModel("获取数据成功", "success", list);
    }
}
