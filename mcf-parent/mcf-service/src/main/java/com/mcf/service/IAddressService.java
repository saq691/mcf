package com.mcf.service;

import java.util.List;

import com.mcf.base.common.service.IBaseService;
import com.mcf.base.pojo.Address;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:46:03
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface IAddressService extends IBaseService<Address> {
	/**
	 * 根据中文或拼音获取自动补全城市列表
	 * 
	 * @param name
	 *            中文或者英文名称
	 * @return
	 */
	public List<Address> getAutoCompleData(String name);

	/**
	 * 根据名称查找城市信息
	 * 
	 * @param name
	 * @return
	 */
	public Address findCityByName(String name);
}
