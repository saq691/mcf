package com.mcf.manage.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcf.base.common.annotation.SameURLData;
import com.mcf.base.common.page.Pager;
import com.mcf.base.model.ResponseData;
import com.mcf.base.pojo.AdminUser;
import com.mcf.manage.web.controller.common.BaseController;
import com.mcf.service.IAdminUserService;

/**
 * Title. <br>
 * Description: 系统用户中心
 * <p>
 * Copyright: Copyright (c) 2016年11月18日 下午10:41:16
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController extends BaseController {
	@Resource
	private IAdminUserService adminUserService;

	/**
	 * 系统用户列表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView list(String keywords, @ModelAttribute("pager") Pager pager) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("keywords", keywords);

		Map<String, Object> result = adminUserService.getUserList(parameter, pager);

		ModelAndView mv = new ModelAndView();
		mv.addObject("selected", "sysuser");
		mv.addObject("result", result);

		mv.setViewName("sysuser_list");
		return mv;
	}

	/**
	 * 新增账号
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addSysuser", method = RequestMethod.POST)
	@ResponseBody
	@SameURLData
	public ResponseData addSysuser(AdminUser adminUser) {
		ResponseData responseData = null;
		AdminUser sysuser = adminUserService.getByUsername(adminUser.getUsername());
		if (sysuser != null) {
			responseData = new ResponseData(false, "对不起，该账号已经存在！");
			return responseData;
		}
		boolean status = adminUserService.addAdminUser(adminUser.getUsername(),
				adminUser.getPassword());
		if (status) {
			responseData = new ResponseData(status, "新增账号成功！");
		} else {
			responseData = new ResponseData(status, "新增账号失败！");
		}
		return responseData;
	}

	/**
	 * 禁用账号
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/disabled", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData disabled(String id) {
		boolean status = adminUserService.updateDisabled(id);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "禁用账号成功！");
		} else {
			responseData = new ResponseData(status, "禁用账号失败！");
		}
		return responseData;
	}

	/**
	 * 启用账号
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/enabled", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData enabled(String id) {
		boolean status = adminUserService.updateEnabled(id);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "启用账号成功！");
		} else {
			responseData = new ResponseData(status, "启用账号失败！");
		}
		return responseData;
	}

	/**
	 * 删除操作
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(String[] ids) {
		boolean status = adminUserService.batchDelete(ids);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "删除成功！");
		} else {
			responseData = new ResponseData(status, "删除失败！");
		}
		return responseData;
	}

}
