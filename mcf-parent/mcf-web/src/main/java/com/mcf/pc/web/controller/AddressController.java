package com.mcf.pc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcf.base.pojo.Address;
import com.mcf.service.IAddressService;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:48:23
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
	@PostMapping(value = "/cityInfo")
	@ResponseBody
	public List<Address> cityInfo(String name) {
		List<Address> list = addressService.getAutoCompleData(name);
		return list;
	}

}
