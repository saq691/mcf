package com.mcf.service;

import java.util.List;

import com.mcf.base.common.service.IBaseService;
import com.mcf.base.pojo.Address;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月15日 上午12:01:47
 * <p>
 * Company: 成都媒超风信息技术有限公司
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
