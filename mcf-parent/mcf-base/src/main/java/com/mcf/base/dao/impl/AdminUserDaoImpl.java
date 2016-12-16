package com.mcf.base.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcf.base.common.dao.impl.BaseMapperDaoImpl;
import com.mcf.base.dao.IAdminUserDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.mapper.AdminUserMapper;
import com.mcf.base.pojo.AdminUser;

@Repository("adminUserDao")
public class AdminUserDaoImpl extends BaseMapperDaoImpl<AdminUser>
		implements IAdminUserDao {

	@Autowired
	private AdminUserMapper adminUserMapper;

	@PostConstruct
	public void init() {
		super.setMapperClass(AdminUserMapper.class);
	}

	@Override
	public AdminUser getByUsername(String username) throws BaseException {
		return adminUserMapper.getByUsername(username);
	}

}
