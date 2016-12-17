package com.mcf.base.mapper;

import java.util.List;

import com.mcf.base.common.dao.IBaseSqlMapper;
import com.mcf.base.pojo.Address;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:36:14
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface AddressMapper extends IBaseSqlMapper<Address> {

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