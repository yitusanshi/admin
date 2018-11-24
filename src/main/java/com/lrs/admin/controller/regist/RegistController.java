package com.lrs.admin.controller.regist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lrs.admin.controller.base.BaseController;

@Controller
public class RegistController extends BaseController{
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public Object regist(){
		System.out.println("开始进行注册了。。。。。。。");
		System.out.println(this.getParameterMap()+"====================");
		return "index";
	}

}
