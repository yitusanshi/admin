package com.lrs.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.NewUserService;

@Controller
@RequestMapping("/firm")
public class FirmController extends BaseController {
//
//	@Resource
//	private NewUserService newUserService;
//
//	/**
//	 * 返回所有的供应商列表(测试用例)
//	 * 
//	 * @param mode
//	 * @return
//	 */
//	@RequestMapping("/find_all_suppliers")
//	public String findAllSupplier(Model model) {
//		Maunfacturer maunfacturer = newUserService.selectByFirmId(6);
//		Maunfacturer maunfacturer1 = newUserService.selectByFirmId(7);
//		Maunfacturer maunfacturer2 = newUserService.selectByFirmId(8);
//		List list = new ArrayList();
//		list.add(maunfacturer);
//		list.add(maunfacturer1);
//		list.add(maunfacturer2);
//		model.addAttribute("maunfacturers", list);
//		return "firm/supplier/suppliers";
//	}
//
//	/**
//	 * 查询所有的回收商的信息
//	 * 
//	 * @param mode
//	 * @return
//	 */
//	@RequestMapping("/find_all_recyclers")
//	public String findAllRecycler(Model mode) {
//		return "firm/recycler/recyclers";
//	}
//
//	/**
//	 * 通过厂商ID查询厂商的信息
//	 * @param request
//	 * @return
//	 */
//	@ResponseBody
//	@PostMapping("/findMaunfacturerByFirmId")
//	public HashMap<String, Object> findMaunfacturerByFirmId(HttpServletRequest request) {
//		System.out.println("进来了查找厂商的信息。。。。。。。。。。。。");
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			return ResponseModel.getModel("编码格式错误", "error", null);
//		}
//		String firmId = request.getParameter("firmId");
//		int fid = Integer.valueOf(firmId);
//		Maunfacturer maunfacturer = newUserService.selectByFirmId(fid);
//		 JSONObject json = new JSONObject();
//		 json.put("maunfacturer", maunfacturer);
//		return ResponseModel.getModel("获取参数成功", "success", json.toJSONString());
//	}
//	
//	@RequestMapping("/delMaunfacturer")
//	public String delMaunfacturer(){
//		System.out.println("删除成功。。。。。。。。。。。");
//		return "";
//	}

}
