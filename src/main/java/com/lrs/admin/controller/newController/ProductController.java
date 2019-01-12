package com.lrs.admin.controller.newController;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.dao.domain.DataRecord;
import com.lrs.admin.dao.domain.DataRecordCategory;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.dao.domain.ProCategory;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.service.DataDealService;
import com.lrs.admin.service.IsPassService;
import com.lrs.admin.service.NewUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Resource
	private DataDealService dataDealService;
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
	// online
	@Resource
	private NewUserService newUserService;
	@Resource
	private IsPassService isPassService;
	private static Map<String, String> pagemap = new HashMap<String, String>() {
		{
			put("steel", "1");
			put("sbr", "2");
			put("cis", "3");
			put("nylon", "4");
			put("beadwire", "5");
			put("carbon", "6");
			put("nr", "7");
			put("tyre", "8");
			put("rr", "9");
		}
	};

	@RequestMapping("/{url}")
	public String find_all(@PathVariable("url") String url, Model model, HttpServletRequest request) {
		// find_all_tyres
		String[] strArr = url.split("_");
		String path = strArr[2];

		String username = request.getParameter("username");
		if (StringUtils.isEmpty(username)) {
			model.addAttribute("msg", "error");
			return "product/" + path + "/" + path;
			// return ResponseModel.getModel("无法获取用户", "error", null);
		}
		Maunfacturer maunfacturer = newUserService.select(username);
		if (maunfacturer == null) {
			model.addAttribute("msg", "error");
			return "product/" + path + "/" + path;
			// return ResponseModel.getModel("无该用户名称，请联系管理员", "error", null);
		}
		logger.info("{} is getting category, time is {}", username, System.currentTimeMillis());
		String productid = maunfacturer.getProductid();
		List<JSONObject> mlist = new ArrayList<>();
		List<Maunfacturer> maunfacturerList = null;
		//获取填写多少次记录
		if (maunfacturer.getGrade() == 0) {
			if (pagemap.containsKey(path)) {
				productid = pagemap.get(path);
			}
			maunfacturerList = newUserService.selectAllByProductid(productid);
			for (Maunfacturer m : maunfacturerList) {
				List<DataRecord> list = dataDealService.selectGroupByFirmId(m.getFirmId());
				if (list == null || list.size() == 0) {
					JSONObject json = new JSONObject();
					json.put("maunfacturer", m);
					json.put("tagTime", "无添加记录");
					json.put("ispass", -1);
					json.put("data", new ArrayList<DataRecordCategory>());
					mlist.add(json);
				}
				for (DataRecord d : list) {
					JSONObject json = new JSONObject();
					json.put("maunfacturer", m);
					json.put("tagTime", d.getTagTime());
					json.put("ispass", isPassService.selectFactory(d.getCategoryId(), d, list));
					List<DataRecordCategory> dataRecordCategoryList = dataDealService.selectDetail(d.getFirmId(), d.getTagTime());
					json.put("data", dataRecordCategoryList);
					mlist.add(json);
				}
			}

		}
		if (maunfacturer.getGrade() == 1 || maunfacturer.getGrade() == 2) {
			int firmid = maunfacturer.getFirmId();
			List<DataRecord> listrecord = dataDealService.selectGroupByFirmId(firmid);
			for (DataRecord dataRecord : listrecord) {
				JSONObject json = new JSONObject();
				json.put("maunfacturer", maunfacturer);
				json.put("tagTime", dataRecord.getTagTime());
				json.put("ispass", 0);
				List<DataRecordCategory> dataRecordCategoryList = dataDealService.selectDetail(dataRecord.getFirmId(), dataRecord.getTagTime());
				json.put("data", dataRecordCategoryList);
				mlist.add(json);
			}
		}

		JSONObject alljson = new JSONObject();
		if (productid.equals("8")) {
			if (pagemap.containsKey(path)) {
				productid = pagemap.get(path);
			}
			productid = pagemap.get(path);
		}
		if (map.containsKey(productid)) {
			String dbColumn = map.get(productid);
			List<ProCategory> list = dataDealService.getUserCategory(dbColumn);
			for (ProCategory proCategory : list) {
				String classifyid = proCategory.getClassifyId();
				if (alljson.containsKey(classifyid)) {
					List<ProCategory> categoryList = (List<ProCategory>) alljson.get(classifyid);
					categoryList.add(proCategory);
					alljson.put(classifyid, categoryList);
				} else {
					List<ProCategory> categoryList = new ArrayList<ProCategory>();
					categoryList.add(proCategory);
					alljson.put(classifyid, categoryList);
				}
			}
		}
		System.out.println(alljson.toJSONString());
		model.addAttribute("categorylist", alljson);
		model.addAttribute("maunfacturerList", mlist);
		model.addAttribute("mlist", maunfacturerList);
		System.out.println("返回结果=====" + alljson.toJSONString());
		System.out.println(mlist.toString());
		return "product/" + path + "/" + path;
	}

}
