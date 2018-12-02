package com.lrs.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.entity.Const;
import com.lrs.admin.entity.Menu;
import com.lrs.admin.entity.User;
import com.lrs.admin.service.IUserService;

@Controller
public class IndexController extends BaseController {

	/*@Value("${admin.name}")
	private String adminName;

	@Autowired
	private IUserService userService;

	*//**
	 * 入口
	 * 
	 * @return
	 *//*
	@RequestMapping(value = { "/", "/toLogin" }, method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	*//**
	 * 首页
	 * 
	 * @param model
	 * @return
	 *//*
*//*	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/index" }, method = RequestMethod.POST)
	public String index(Model model, String firmId) {

		System.out.println("已经登录进来了、、、、、、、、、、、" + firmId);

		*//**//**
		 * 根据厂商Id获取厂商的详细信息
		 * 
		 *//**//*

		model.addAttribute("userStatus", "在线");

		try {
			List<Menu> allMenu = (List<Menu>) this.getSession().getAttribute(Const.SESSION_ALL_MENU);
			if (allMenu != null) {
				model.addAttribute("menus", allMenu);
			}
			model.addAttribute("adminName", adminName);
			model.addAttribute("userName", "123");
			model.addAttribute("userPath", "123");
			model.addAttribute("userStatus", "在线");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}*//*

	*//*	*//**//**
			 * 用户登录
			 * 
			 * @return
			 *//**//*
			 * @RequestMapping(value={"/login"},method=RequestMethod.POST)
			 * 
			 * @ResponseBody public Object login(){
			 * System.out.println("登录进来了"+this.getParameterMap()+"======"+this.
			 * getSession()); return userService.login(this.getParameterMap(),
			 * this.getSession()); }
			 *//*

	*//**
	 * 用户注销
	 * 
	 * @return
	 *//*
	@RequestMapping("/logout")
	public String logout() {
		return userService.logout(this.getSession());
	}*/

}
