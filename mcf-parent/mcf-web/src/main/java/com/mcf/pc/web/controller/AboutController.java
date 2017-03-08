package com.mcf.pc.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcf.base.common.annotation.SameURLData;
import com.mcf.base.common.page.Pager;
import com.mcf.base.model.Msg;
import com.mcf.base.model.ResponseData;
import com.mcf.base.pojo.ContactInfo;
import com.mcf.service.IContactInfoService;

/**
 * Title. <br>
 * Description: 联系我们Controller
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:49:09
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class AboutController {
	@Autowired
	private IContactInfoService contactInfoService;

	/**
	 * 联系我们页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/about.html")
	public ModelAndView list(Pager pager) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("about");
		return mv;
	}

	/**
	 * 发送联系信息
	 * 
	 * @param copartner
	 * @return
	 */
	@PostMapping(value = "/sendInfo")
	@ResponseBody
	@SameURLData
	public ResponseData sendInfo(ContactInfo contactInfo) {
		List<Msg> msgs = new ArrayList<Msg>();
		if (!StringUtils.isNotBlank(contactInfo.getName())) {
			msgs.add(new Msg("name", "请输入姓名"));
		}
		if (!StringUtils.isNotBlank(contactInfo.getContactWay())) {
			msgs.add(new Msg("contactWay", "请输入电子邮箱或者联系方式"));
		}
		if (!StringUtils.isNotBlank(contactInfo.getContent())) {
			msgs.add(new Msg("content", "请输入信息内容"));
		}
		boolean status = false;
		ResponseData responseData = null;
		if (msgs.size() == 0) {
			status = contactInfoService.addContactInfo(contactInfo);
			responseData = new ResponseData(status, "发送成功！", msgs);
		} else {
			responseData = new ResponseData(status, "发送失败！", msgs);
		}
		return responseData;
	}

}
