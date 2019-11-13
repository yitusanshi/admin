package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.dao.domain.MenuList;
import com.lrs.admin.service.IUserService;
import com.lrs.admin.service.MenuListService;
import com.lrs.admin.service.NewUserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewIndexController extends BaseController {
    @Resource
    private NewUserService newUserService;

    @Autowired
    private IUserService userService;

    @Autowired
    private MenuListService menuListService;

    private static Map<String, String> map = new HashMap<String, String>() {
        {
            put("1", "steel_cord");
            put("2", "sbr_rubber");
            put("3", "cis_rubber");
            put("4", "nylon_cord");
            put("5", "bead_wire");
            put("6", "carbon_black");
            put("7", "natural_rubber");
            put("8", "tyre_produce");
            put("9", "recla_rubber");
        }
    };

    /**
     * 入口
     *
     * @return
     */
    @RequestMapping(value = {"/", "/toLogin"}, method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.POST)
    public String index(Model model, String firmId) {
        /**
         * 根据厂商Id获取厂商的详细信息
         * 并将厂商的信息传至index页面
         *
         *
         */
        System.out.println(firmId);
        int fid = Integer.valueOf(firmId);
        Maunfacturer maunfacturer = newUserService.selectByFirmId(fid);
        String productid = maunfacturer.getProductid();
        int grade = maunfacturer.getGrade();
        List<MenuList> list = null;
        String role = "";
        //超级管理员
        if (grade == 0) {
            role = "product";
            list = menuListService.getMeunList(role);
        } else {
            if (map.containsKey(productid)) {
                role = map.get(productid);
                System.out.println(role);
                list = menuListService.getMeunList(role);
            }
        }
        List<JSONObject> jsonlist = new ArrayList<>();
        for (MenuList menu : list) {
            String parName = menu.getParMenuName();
            boolean b = true;
            for (JSONObject json : jsonlist) {
                if (parName.equals(json.getString("parname"))) {
                    JSONArray jsonArray = json.getJSONArray("childmenu");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("childname", menu.getChildMenuName());
                    jsonObject.put("childurl", menu.getChildMenuUrl());
                    /*jsonObject.put(menu.getChildMenuName(), menu.getChildMenuUrl());*/
                    jsonArray.add(jsonObject);
                    b = false;
                }
            }
            if (b) {
                JSONObject parJson = new JSONObject();
                parJson.put("parname", menu.getParMenuName());
                parJson.put("parurl", menu.getParMenuUrl());
                JSONArray jsonArray = new JSONArray();
                JSONObject sonJson = new JSONObject();
                sonJson.put("childname", menu.getChildMenuName());
                sonJson.put("childurl", menu.getChildMenuUrl());
                /*sonJson.put(menu.getChildMenuName(), menu.getChildMenuUrl());*/
                jsonArray.add(sonJson);
                parJson.put("childmenu", jsonArray);
                jsonlist.add(parJson);
            }
        }
        System.out.println(jsonlist.toString());
        model.addAttribute("menulist", jsonlist);
        model.addAttribute("maunfacturer", maunfacturer);
        if (firmId.equals("1")) {
            return "index1";
        }
        return "index";
    }

    /**
     * 用户注销
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        return userService.logout(this.getSession());
    }
}
