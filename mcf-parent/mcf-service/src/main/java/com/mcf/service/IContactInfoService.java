package com.mcf.service;

import java.util.Map;

import com.mcf.base.common.page.Pager;
import com.mcf.base.common.service.IBaseService;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.ContactInfo;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:46:21
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface IContactInfoService extends IBaseService<ContactInfo> {
	/**
	 * 根据对象id修改是否已经联系客户
	 * 
	 * @param id
	 * @param isContact
	 * @return
	 */
	public boolean updateIsContact(String id, Byte isContact);

	/**
	 * 获取所有联系信息列表
	 * 
	 * @param parameter
	 * @param pager
	 * @return
	 * @throws BaseException
	 */
	public Map<String, Object> getContactInfoList(Map<String, Object> parameter,
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
	 * 发送联系信息
	 * 
	 * @param contactInfo
	 *            联系信息对象
	 * @return
	 */
	public boolean addContactInfo(ContactInfo contactInfo);

}
