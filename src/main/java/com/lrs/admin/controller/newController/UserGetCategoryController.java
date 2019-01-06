package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
 * @Date: 2018/12/1 15:22
 */
@RestController
@Deprecated
public class UserGetCategoryController {
    private Logger logger = LoggerFactory.getLogger(UserGetCategoryController.class);
    @Resource
    private DataDealService dataDealService;
    private static Map<String, String> map = new HashMap<String, String>(){{
        put("1", "steel_cord");
        put("2", "sbr_rubber");
        put("3", "cis_rubber");
        put("4", "nylon_cord");
        put("5", "bead_wire");
        put("6", "carbon_black");
        put("7", "natural_rubber");
        put("8", "tyre_produce");
        put("9", "recla_rubber");
    }};
    //online
    @Resource
    private NewUserService newUserService;
   /* @RequestMapping(value = "getcategory", method = RequestMethod.POST)
    public String  getCategory(Model model){
        *//*try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式错误");
            return ResponseModel.getModel("编码格式错误", "error", null);
        }
        String username = request.getParameter("username");*//*
        Map<String, Object> modelmap = model.asMap();
        String username = (String) modelmap.get("username");
        if (StringUtils.isEmpty(username)){
            model.addAttribute("msg", "error");
            return "";
            //return ResponseModel.getModel("无法获取用户", "error", null);
        }
        Maunfacturer maunfacturer = newUserService.select(username);
        if (maunfacturer == null){
            model.addAttribute("msg", "error");
            return "";
            //return ResponseModel.getModel("无该用户名称，请联系管理员", "error", null);
        }
        logger.info("{} is getting category, time is {}", username, System.currentTimeMillis());
        String productid = maunfacturer.getProductid();
        JSONObject alljson = new JSONObject();
        alljson.put("maunfacturer", maunfacturer);
        if (map.containsKey(productid)){
            String dbColumn = map.get(productid);
            List<ProCategory> list = dataDealService.getUserCategory(dbColumn);
            for (ProCategory proCategory : list){
                String classifyid= proCategory.getClassifyId();
                if (alljson.containsKey(classifyid)){
                    List<ProCategory> categoryList = (List<ProCategory>) alljson.get(classifyid);
                    categoryList.add(proCategory);
                    alljson.put(classifyid, categoryList);
                }else {
                    List<ProCategory> categoryList = new ArrayList<ProCategory>();
                    categoryList.add(proCategory);
                    alljson.put(classifyid, categoryList);
                }
               *//* String categoryid = proCategory.getCategoryId();
                String categoryName = proCategory.getCategoryName();
                if (alljson.containsKey(classifyid)){
                    JSONObject json = alljson.getJSONObject(classifyid);
                    json.put(categoryid, categoryName);
                }else {
                    JSONObject json = new JSONObject();
                    json.put(categoryid, categoryName);
                    alljson.put(classifyid, json);
                }*//*
            }
        }
        model.addAttribute("categorylist", alljson);
        return "";
        //return ResponseModel.getModel("获取分类成功", "success", alljson.toJSONString());
    }*/
}
