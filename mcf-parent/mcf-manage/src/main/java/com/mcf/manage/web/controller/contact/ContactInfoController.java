package com.mcf.manage.web.controller.contact;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcf.base.common.annotation.SameURLData;
import com.mcf.base.common.page.Pager;
import com.mcf.base.model.ResponseData;
import com.mcf.manage.web.controller.common.BaseController;
import com.mcf.service.IContactInfoService;

/**
 * Title. <br>
 * Description: 联系信息中心
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:42:34
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
@RequestMapping("/contactInfo")
public class ContactInfoController extends BaseController {
	@Resource
	private IContactInfoService contactInfoService;

	/**
	 * 联系信息列表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView list(String keywords, Pager pager) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("keywords", keywords);

		Map<String, Object> result = contactInfoService.getContactInfoList(parameter,
				pager);

		ModelAndView mv = new ModelAndView();
		mv.addObject("selected", "contactInfo");
		mv.addObject("result", result);

		mv.setViewName("contact_list");
		return mv;
	}

	/**
	 * 设置是否已联系
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/isContact", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData isContact(String id, Byte isContact) {
		boolean status = contactInfoService.updateIsContact(id, isContact);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "设置成功！");
		} else {
			responseData = new ResponseData(status, "设置失败！");
		}
		return responseData;
	}

	/**
	 * 添加备注
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addRemark", method = RequestMethod.POST)
	@ResponseBody
	@SameURLData
	public ResponseData addRemark(String id, String remark) {
		boolean status = contactInfoService.updateRemark(id, remark);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "添加备注成功！");
		} else {
			responseData = new ResponseData(status, "添加备注失败！");
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
		boolean status = contactInfoService.batchDelete(ids);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "删除成功！");
		} else {
			responseData = new ResponseData(status, "删除失败！");
		}
		return responseData;
	}

}
