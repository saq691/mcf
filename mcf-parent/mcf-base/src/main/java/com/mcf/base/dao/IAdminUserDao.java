package com.mcf.base.dao;

import com.mcf.base.common.dao.IBaseMapperDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.AdminUser;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:34:10
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface IAdminUserDao extends IBaseMapperDao<AdminUser> {
	/**
	 * 根据用户名获得对象
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	public AdminUser getByUsername(String username) throws BaseException;

}
