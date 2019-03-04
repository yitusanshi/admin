package com.lrs.admin.controller.newController;

import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.DataDealService;
import com.lrs.admin.service.NewUserService;
import com.lrs.admin.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/sys")
public class UserManagerController {
    Logger logger = LoggerFactory.getLogger(UserManagerController.class);
    @Resource
    private NewUserService newUserService;
    @Resource
    private DataDealService dataDealService;
    @RequestMapping("/find_all_user")
    public String findAllUser(Model model) {
        List<Maunfacturer> list = newUserService.selectAll();
        //model.addAttribute("maunfacturers", list);
        for (Maunfacturer m : list){
            Date foundingTime = m.getFoundingTime();
            String foundingTimeStr = DateUtil.formatDate(foundingTime, "yyyy-MM-dd");
            m.setFoundingTimestr(foundingTimeStr);
            Date registerTime = m.getFoundingTime();
            String registerTimestr = DateUtil.formatDate(registerTime, "yyyy-MM-dd");
            m.setRegisterTimestr(registerTimestr);
        }
        model.addAttribute("maunfacturers", list);
        return "sys/sys_user";
    }

}
