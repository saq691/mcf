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
import com.mcf.base.common.enums.CooperateType;
import com.mcf.base.model.Msg;
import com.mcf.base.model.ResponseData;
import com.mcf.base.pojo.Copartner;
import com.mcf.service.ICopartnerService;

/**
 * Title. <br>
 * Description: 申请合伙人中心
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:48:51
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class CopartnerController {
	@Autowired
	private ICopartnerService copartnerService;

	/**
	 * 申请合伙人方法
	 * 
	 * @param copartner
	 * @return
	 */
	@RequestMapping(value = "/toApply", method = RequestMethod.POST)
	@ResponseBody
	@SameURLData
	public ResponseData toApply(Copartner copartner) {
		List<Msg> msgs = new ArrayList<Msg>();
		if (!StringUtils.isNotBlank(copartner.getScooperateType())) {
			msgs.add(new Msg("cooperateType", "请选择合作类型"));
		}
		if (!StringUtils.isNotBlank(copartner.getCityName())) {
			msgs.add(new Msg("cityName", "请输入城市名称"));
		}
		if (!StringUtils.isNotBlank(copartner.getName())) {
			msgs.add(new Msg("name", "请输入姓名"));
		}
		if (!StringUtils.isNotBlank(copartner.getContactWay())) {
			msgs.add(new Msg("contactWay", "请输入联系方式"));
		}
		if (CooperateType.COMPANY.getValue().equals(copartner.getScooperateType())) {
			if (!StringUtils.isNotBlank(copartner.getScompanyScale())) {
				msgs.add(new Msg("companyScale", "请选择公司规模"));
			}
			if (!StringUtils.isNotBlank(copartner.getMainBusiness())) {
				msgs.add(new Msg("mainBusiness", "请输入主营业务"));
			}
		}
		boolean status = false;
		ResponseData responseData = null;
		if (msgs.size() == 0) {
			status = copartnerService.addCopartner(copartner);
			responseData = new ResponseData(status, "申请成功！", msgs);
		} else {
			responseData = new ResponseData(status, "申请失败！", msgs);
		}
		return responseData;
	}

}
