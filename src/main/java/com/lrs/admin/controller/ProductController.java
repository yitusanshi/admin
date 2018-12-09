package com.lrs.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.entity.ResponseModel;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
/*	private Logger logger = LoggerFactory.getLogger(ProductController.class);
*/
	/**
	 * 返回胎圈钢丝的列表
	 * 
	 * @return
	 */
/*	@RequestMapping("/find_all_beadwires")
	public String find_all_beadwires(Model model) {
		return "product/beadwire/beadwire";
	}*/

	/**
	 * 获取炭黑列表信息
	 * 
	 * @param model
	 * @return
	 */
/*	@RequestMapping("/find_all_carbons")
	public String find_all_carbons(Model model) {
		return "product/carbon/carbon";
	}*/

	/**
	 * 获取合成橡胶（顺丁橡胶）信息
	 * 
	 * @param model
	 * @return
	 */
/*	@RequestMapping("/find_all_ciss")
	public String find_all_ciss(Model model) {
		return "product/cis/cis";
	}*/

	/**
	 * 获取天然橡胶信息
	 * 
	 * @param model
	 * @return
	 */
/*	@RequestMapping("/find_all_nrs")
	public String find_all_nrs(Model model) {
		return "product/nr/nr";
	}*/

	/**
	 * 获取尼龙帘布信息
	 * 
	 * @param model
	 * @return
	 */
/*	@RequestMapping("/find_all_nylons")
	public String find_all_nylons(Model model) {
		return "product/nylon/nylon";
	}*/

	/**
	 * 返回再生胶信息
	 * 
	 * @param model
	 * @return
	 */
	/*@RequestMapping("/find_all_rrs")
	public String find_all_rrs(Model model) {
		return "product/rr/rr";
	}*/

	/**
	 * 返回合成橡胶（丁苯橡胶）信息
	 * 
	 * @param model
	 * @return
	 */
/*	@RequestMapping("/find_all_sbrs")
	public String find_all_sbrs(Model model) {
		return "product/sbr/sbr";
	}*/

	/**
	 * 返回钢帘线信息
	 * 
	 * @param model
	 * @return
	 */
/*	@RequestMapping("/find_all_steels")
	public String find_all_steels(Model model) {
		return "product/steel/steel";
	}*/

	/**
	 * 返回轮胎生产信息
	 * 
	 * @param model
	 * @return
	 */
/*	@RequestMapping("/find_all_tyres")
	public String find_all_tyres(Model model) {
		return "product/tyre/tyre";
	}

	@ResponseBody
	@RequestMapping("/insert_sbrs")
	public HashMap<String, Object> insert_sbrs(HttpServletRequest request) throws JSONException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("编码格式错误");
			return ResponseModel.getModel("编码格式错误", "error", null);
		}
		String jsonArrStr = request.getParameter("insert_sbrs");
		System.out.println(jsonArrStr+"==============");
		JSONObject jsonObject = new JSONObject(jsonArrStr);//字符串转json对象  
		System.out.println("jsonObject"+jsonObject);
		return ResponseModel.getModel("注册成功", "success", null);
	}*/

}
