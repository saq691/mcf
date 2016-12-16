package com.mcf.base.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcf.base.common.dao.impl.BaseMapperDaoImpl;
import com.mcf.base.dao.ICopartnerDao;
import com.mcf.base.mapper.CopartnerMapper;
import com.mcf.base.pojo.Copartner;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月15日 上午12:36:07
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
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
