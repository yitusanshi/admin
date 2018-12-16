package com.lrs.admin.controller.newController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lrs.admin.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.dao.domain.Maunfacturer;
import com.lrs.admin.service.NewUserService;

@Controller
@RequestMapping("/firm")
public class FirmController extends BaseController {

	@Resource
	private NewUserService newUserService;

	/**
	 * 返回所有的供应商列表(测试用例)
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/find_all_suppliers")
	public String findAllSupplier(Model model) {
		/*Maunfacturer maunfacturer = newUserService.selectByFirmId(6);
		Maunfacturer maunfacturer1 = newUserService.selectByFirmId(7);
		Maunfacturer maunfacturer2 = newUserService.selectByFirmId(8);
		List list = new ArrayList();
		list.add(maunfacturer);
		list.add(maunfacturer1);
		list.add(maunfacturer2);
		list.add(maunfacturer);
		list.add(maunfacturer1);
		list.add(maunfacturer2);
		list.add(maunfacturer);
		list.add(maunfacturer1);
		list.add(maunfacturer2);
		list.add(maunfacturer);
		list.add(maunfacturer1);
		list.add(maunfacturer2);
		list.add(maunfacturer);
		list.add(maunfacturer1);
		list.add(maunfacturer2);
		list.add(maunfacturer);
		list.add(maunfacturer1);
		list.add(maunfacturer2);
		list.add(maunfacturer);
		list.add(maunfacturer1);
		list.add(maunfacturer2);
		model.addAttribute("maunfacturers", list);*/
		List<Maunfacturer> list = newUserService.selectByGrade(1);
		model.addAttribute("maunfacturers", list);
		for (Maunfacturer m : list){
			Date foundingTime = m.getFoundingTime();
			String foundingTimeStr = DateUtil.formatDate(foundingTime, "yyyy-MM-dd HH:mm:ss");
			m.setFoundingTimestr(foundingTimeStr);
		}
		return "firm/supplier/suppliers";
	}

	/**
	 * 查询所有的回收商的信息
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/find_all_recyclers")
	public String findAllRecycler(Model model) {
		List<Maunfacturer> list = newUserService.selectByGrade(2);
		model.addAttribute("maunfacturers", list);
		return "firm/recycler/recyclers";
	}

}
