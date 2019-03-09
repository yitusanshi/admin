package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.service.DataDealService;
import com.lrs.admin.service.NewUserService;
import com.lrs.admin.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class ResourceDataController {
    private static Logger logger = LoggerFactory.getLogger(ResourceDataController.class);
    @Resource
    private NewUserService newUserService;
    @Resource
    private DataDealService dataDealService;
    @RequestMapping("/find_all_data")
    public String findAllResourceData(Model model, HttpServletRequest request){
        String username = request.getParameter("username");
        if (StringUtils.isEmpty(username)) {
            model.addAttribute("msg", "error");
            return "resource/basicdata/basicdata";
        }

        Maunfacturer maunfacturer = newUserService.select(username);
        if (maunfacturer == null) {
            model.addAttribute("msg", "error");
            return "resource/basicdata/basicdata";
        }
        logger.info("{} is getting , time is {}", username, System.currentTimeMillis());
        if (maunfacturer.getGrade() != 0){
            model.addAttribute("msg", "用户权限不足");
            return "resource/basicdata/basicdata";
        }
        List<Maunfacturer> maunlist = newUserService.selectAll();
        List<JSONObject> list = new ArrayList<>();
        for (Maunfacturer m : maunlist){

            int firmid = m.getFirmId();
            m.setPassword("");
            List<DataRecord> listrecord = dataDealService.selectGroupByFirmId(firmid);
            for (DataRecord dataRecord : listrecord){
                JSONObject json = new JSONObject();
                List<DataRecordCategory> dataRecordCategoryList = dataDealService.selectDetail(dataRecord.getFirmId(), dataRecord.getTagTime());
                if(dataRecordCategoryList == null || dataRecordCategoryList.size() == 0){
                    break;
                }
                DataRecordCategory dataRecordCategory = dataRecordCategoryList.get(0);
                json.put("manu", m);
                json.put("records", dataRecordCategoryList);
                json.put("tagTime", dataRecordCategory.getTagTime());
                json.put("dataYear", dataRecordCategory.getDataYear());
                list.add(json);

            }
        }
        model.addAttribute("resourceData", list);
        System.out.println("list===="+list);
        return "resource/basicdata/basicdata";
    }

    @RequestMapping("/find_all_bg")
    public String findBackGroundData(Model model, HttpServletRequest request){
        return "/resource/bgdata/bgdata";
    }
    @RequestMapping("/find_all_rm")
    public String findOriginalData(Model model, HttpServletRequest request){
        return "/resource/rmdata/rmdata";
    }
}
