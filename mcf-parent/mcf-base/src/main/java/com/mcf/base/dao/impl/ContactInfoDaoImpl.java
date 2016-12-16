package com.mcf.base.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcf.base.common.dao.impl.BaseMapperDaoImpl;
import com.mcf.base.dao.IContactInfoDao;
import com.mcf.base.mapper.ContactInfoMapper;
import com.mcf.base.pojo.ContactInfo;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月15日 上午12:31:20
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Repository("contactInfoDao")
public class ContactInfoDaoImpl extends BaseMapperDaoImpl<ContactInfo>
		implements IContactInfoDao {

	@Autowired
	private ContactInfoMapper contactInfoMapper;

	@PostConstruct
	public void init() {
		super.setMapperClass(ContactInfoMapper.class);
	}

}
