package com.mcf.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcf.base.pojo.Address;
import com.mcf.service.IAddressService;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月18日 下午12:03:40
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class AddressController {
	@Autowired
	private IAddressService addressService;

	/**
	 * 根据城市名称自动补全信息
	 * 
	 * @param name
	 *            城市名称
	 * @return
	 */
	@RequestMapping(value = "/cityInfo", method = RequestMethod.POST)
	@ResponseBody
	public List<Address> cityInfo(String name) {
		List<Address> list = addressService.getAutoCompleData(name);
		return list;
	}

}
