package com.lrs.admin.controller.newController;

import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.service.NewUserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@RestController
public class NewIndexController {
    @Resource
    private NewUserService newUserService;
    /**
     * 入口
     *
     * @return
     */
    @RequestMapping(value = { "/", "/toLogin" }, method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value={"/index"},method=RequestMethod.POST)
    public String index(Model model, String firmId){
        /**
         * 根据厂商Id获取厂商的详细信息
         * 并将厂商的信息传至index页面
         *
         *
         */
        System.out.println(firmId);
        int fid = Integer.valueOf(firmId);
        Maunfacturer maunfacturer = newUserService.selectByFirmId(fid);
        model.addAttribute("maunfacturer",maunfacturer);
        return "index";
    }
}
