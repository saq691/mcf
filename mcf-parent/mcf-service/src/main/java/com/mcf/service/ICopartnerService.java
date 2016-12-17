package com.mcf.service;

import java.util.Map;

import com.mcf.base.common.page.Pager;
import com.mcf.base.common.service.IBaseService;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.Copartner;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:46:31
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface ICopartnerService extends IBaseService<Copartner> {
	/**
	 * 根据对象id修改是否已经联系客户
	 * 
	 * @param id
	 * @param isContact
	 * @return
	 */
	public boolean updateIsContact(String id, Byte isContact);

	/**
	 * 获取所有合伙人信息列表
	 * 
	 * @param parameter
	 * @param pager
	 * @return
	 * @throws BaseException
	 */
	public Map<String, Object> getCopartnerList(Map<String, Object> parameter,
			Pager pager) throws BaseException;

	/**
	 * 根据对象id添加备注
	 * 
	 * @param id
	 * @param remark
	 * @return
	 */
	public boolean updateRemark(String id, String remark);

	/**
	 * 申请合伙人
	 * 
	 * @param copartner
	 *            合伙人对象
	 * @return
	 */
	public boolean addCopartner(Copartner copartner);
}
