package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.dao.domain.ProCategory;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.DataDealService;
import com.lrs.admin.service.NewUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
    	private Logger logger = LoggerFactory.getLogger(ProductController.class);
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
    /**
     * 返回胎圈钢丝的列表
     *
     * @return
     */
	@RequestMapping("/find_all_beadwires")
	public String find_all_beadwires(Model model) {
        Map<String, Object> modelmap = model.asMap();
        //String username = (String) modelmap.get("username");
        String username = "用户2";
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
            }
        }
        System.out.println(alljson.toJSONString());
        model.addAttribute("categorylist", alljson);
		return "product/beadwire/beadwire";
	}

    /**
     * 获取炭黑列表信息
     *
     * @param model
     * @return
     */
	@RequestMapping("/find_all_carbons")
	public String find_all_carbons(Model model) {
		return "product/carbon/carbon";
	}

    /**
     * 获取合成橡胶（顺丁橡胶）信息
     *
     * @param model
     * @return
     */
	@RequestMapping("/find_all_ciss")
	public String find_all_ciss(Model model) {
		return "product/cis/cis";
	}

    /**
     * 获取天然橡胶信息
     *
     * @param model
     * @return
     */
	@RequestMapping("/find_all_nrs")
	public String find_all_nrs(Model model) {
		return "product/nr/nr";
	}

    /**
     * 获取尼龙帘布信息
     *
     * @param model
     * @return
     */
	@RequestMapping("/find_all_nylons")
	public String find_all_nylons(Model model) {
		return "product/nylon/nylon";
	}

    /**
     * 返回再生胶信息
     *
     * @param model
     * @return
     */
	@RequestMapping("/find_all_rrs")
	public String find_all_rrs(Model model) {
		return "product/rr/rr";
	}

    /**
     * 返回合成橡胶（丁苯橡胶）信息
     *
     * @param model
     * @return
     */
	@RequestMapping("/find_all_sbrs")
	public String find_all_sbrs(Model model) {
		return "product/sbr/sbr";
	}

    /**
     * 返回钢帘线信息
     *
     * @param model
     * @return
     */
	@RequestMapping("/find_all_steels")
	public String find_all_steels(Model model) {
        Map<String, Object> modelmap = model.asMap();
        //String username = (String) modelmap.get("username");
        String username = "用户2";
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
            }
        }
        System.out.println(alljson.toJSONString());
        model.addAttribute("categorylist", alljson);
		return "product/steel/steel";
	}

    /**
     * 返回轮胎生产信息
     *
     * @param model
     * @return
     */
	@RequestMapping("/find_all_tyres")
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
		JSONObject jsonObject = JSONObject.parseObject(jsonArrStr);//字符串转json对象
		System.out.println("jsonObject"+jsonObject);
		return ResponseModel.getModel("注册成功", "success", null);
	}
}