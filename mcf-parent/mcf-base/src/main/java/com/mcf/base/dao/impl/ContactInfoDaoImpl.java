package com.mcf.base.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcf.base.common.dao.impl.BaseMapperDaoImpl;
import com.mcf.base.dao.IContactInfoDao;
import com.mcf.base.mapper.ContactInfoMapper;
import com.mcf.base.pojo.ContactInfo;

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
