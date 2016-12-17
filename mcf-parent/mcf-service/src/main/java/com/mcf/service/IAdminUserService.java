package com.mcf.service;

import java.util.Map;

import com.mcf.base.common.page.Pager;
import com.mcf.base.common.service.IBaseService;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.AdminUser;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:46:12
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface IAdminUserService extends IBaseService<AdminUser> {
	/**
	 * 根据用户名获得对象
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	public AdminUser getByUsername(String username);

	/**
	 * 根据用户id启用账号
	 * 
	 * @param id
	 *            对象id
	 * @return
	 */
	public boolean updateEnabled(String id);

	/**
	 * 根据用户id禁用账号
	 * 
	 * @param id
	 *            对象id
	 * @return
	 */
	public boolean updateDisabled(String id);

	/**
	 * 新增账号
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean addAdminUser(String username, String password);

	/**
	 * 根据所有系统用户列表
	 * 
	 * @param parameter
	 * @param pager
	 * @return
	 * @throws BaseException
	 */
	public Map<String, Object> getUserList(Map<String, Object> parameter, Pager pager)
			throws BaseException;
}
