package com.mcf.base.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcf.base.common.dao.impl.BaseMapperDaoImpl;
import com.mcf.base.common.utils.StringHelper;
import com.mcf.base.dao.INewsContentDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.mapper.NewsContentMapper;
import com.mcf.base.pojo.NewsContent;

@Repository("newsContentDao")
public class NewsContentDaoImpl extends BaseMapperDaoImpl<NewsContent>
		implements INewsContentDao {

	@Autowired
	private NewsContentMapper newsContentMapper;

	@PostConstruct
	public void init() {
		super.setMapperClass(NewsContentMapper.class);
	}

	@Override
	public List<NewsContent> getNewests() throws BaseException {
		List<NewsContent> list = null;
		try {
			list = newsContentMapper.getNewests();
		} catch (BaseException e) {
			list = null;
			throw e;
		}
		return StringHelper.getList(list);
	}

	@Override
	public Integer getCountNews() throws BaseException {
		Integer totalRecords = 0;
		try {
			totalRecords = newsContentMapper.getCountNews();
		} catch (BaseException e) {
			totalRecords = 0;
			throw e;
		}
		return totalRecords;
	}

}
