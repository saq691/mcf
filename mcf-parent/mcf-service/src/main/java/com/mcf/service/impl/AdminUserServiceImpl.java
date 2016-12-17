package com.mcf.service.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mcf.base.common.dao.IBaseMapperDao;
import com.mcf.base.common.enums.EnabledType;
import com.mcf.base.common.page.Pager;
import com.mcf.base.common.service.impl.BaseServiceImpl;
import com.mcf.base.common.utils.JodaUtils;
import com.mcf.base.common.utils.RandomUtils;
import com.mcf.base.common.utils.SSEncryptionUtils;
import com.mcf.base.dao.IAdminUserDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.AdminUser;
import com.mcf.service.IAdminUserService;

@Service("adminUserService")
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser>
		implements IAdminUserService {
	private Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);

	@Resource
	private IAdminUserDao adminUserDao;

	@Resource(name = "adminUserDao")
	@Override
	public void setBaseMapperDao(IBaseMapperDao<AdminUser> baseMapperDao) {
		super.setBaseMapperDao(baseMapperDao);
	}

	@Override
	public AdminUser getByUsername(String username) {
		AdminUser adminUser = adminUserDao.getByUsername(username);
		return adminUser;
	}

	@Override
	public boolean addAdminUser(String username, String password) {
		// 获取当前时间
		Date nowTime = JodaUtils.getNowDate();

		AdminUser adminUser = new AdminUser();
		adminUser.setId(RandomUtils.getGenerateId());
		adminUser.setUsername(username);
		adminUser.setPassword(SSEncryptionUtils.saltMD5Encoder(password));
		adminUser.setCreateTime(nowTime);
		adminUser.setUpdateTime(nowTime);
		boolean flag = adminUserDao.add(adminUser);
		return flag;
	}

	@Override
	public Map<String, Object> getUserList(Map<String, Object> parameter, Pager pager)
			throws BaseException {
		Map<String, Object> listMap = null;
		try {
			listMap = this.getListData("getUserList", parameter, pager);
		} catch (BaseException e) {
			logger.error("获取系统用户列表失败--->{}");
			throw e;
		}
		return listMap;
	}

	@Override
	public boolean updateEnabled(String id) {
		boolean flag = false;

		if (StringUtils.isNotBlank(id)) {
			AdminUser adminUser = adminUserDao.getById(id);
			if (adminUser != null) {
				adminUser.setEnabled(EnabledType.ENABLED.getOrdinal());
				adminUser.setUpdateTime(JodaUtils.getNowDate());
				flag = adminUserDao.update(adminUser);
			}
		}
		return flag;
	}

	@Override
	public boolean updateDisabled(String id) {
		boolean flag = false;

		if (StringUtils.isNotBlank(id)) {
			AdminUser adminUser = adminUserDao.getById(id);
			if (adminUser != null) {
				adminUser.setEnabled(EnabledType.DISABLED.getOrdinal());
				adminUser.setUpdateTime(JodaUtils.getNowDate());
				flag = adminUserDao.update(adminUser);
			}
		}
		return flag;
	}

}
