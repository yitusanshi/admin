package com.lrs.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lrs.admin.controller.base.BaseController;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {
	
	@RequestMapping(value="/list")
	public String list(){
		return "page/member/list";
	}
	
	

}
