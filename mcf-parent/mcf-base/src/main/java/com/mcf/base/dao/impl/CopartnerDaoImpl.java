package com.mcf.base.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcf.base.common.dao.impl.BaseMapperDaoImpl;
import com.mcf.base.dao.ICopartnerDao;
import com.mcf.base.mapper.CopartnerMapper;
import com.mcf.base.pojo.Copartner;

@Repository("copartnerDao")
public class CopartnerDaoImpl extends BaseMapperDaoImpl<Copartner>
		implements ICopartnerDao {

	@Autowired
	private CopartnerMapper copartnerMapper;

	@PostConstruct
	public void init() {
		super.setMapperClass(CopartnerMapper.class);
	}

}
