package com.mcf.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcf.base.common.annotation.SameURLData;
import com.mcf.base.model.Msg;
import com.mcf.base.model.ResponseData;
import com.mcf.base.pojo.ContactInfo;
import com.mcf.service.IContactInfoService;

/**
 * Title. <br>
 * Description: 联系信息中心
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:48:23
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class ContactInfoController {
	@Autowired
	private IContactInfoService contactInfoService;

	/**
	 * 发送联系信息
	 * 
	 * @param copartner
	 * @return
	 */
	@RequestMapping(value = "/sendInfo", method = RequestMethod.POST)
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
