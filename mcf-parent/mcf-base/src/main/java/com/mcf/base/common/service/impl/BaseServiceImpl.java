package com.mcf.base.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mcf.base.common.constants.Constants;
import com.mcf.base.common.dao.IBaseMapperDao;
import com.mcf.base.common.page.ListDataModel;
import com.mcf.base.common.page.ListDataWithPaginator;
import com.mcf.base.common.page.Pager;
import com.mcf.base.common.page.Pagination;
import com.mcf.base.common.service.IBaseService;
import com.mcf.base.exception.BaseException;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:28:13
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class BaseServiceImpl<T> implements IBaseService<T> {

	private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	private IBaseMapperDao<T> baseMapperDao;

	@Resource
	public void setBaseMapperDao(IBaseMapperDao<T> baseMapperDao) {
		this.baseMapperDao = baseMapperDao;
	}

	@Override
	public boolean add(T entity) {
		try {
			return baseMapperDao.add(entity);
		} catch (BaseException e) {
			logger.error("add操作异常-->{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean batchAdd(List<T> list) {
		try {
			return baseMapperDao.batchAdd(list);
		} catch (BaseException e) {
			logger.error("batchAdd操作异常-->{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean update(T entity) {
		try {
			return baseMapperDao.update(entity);
		} catch (BaseException e) {
			logger.error("update操作异常-->{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean delete(T entity) {
		try {
			return baseMapperDao.delete(entity);
		} catch (BaseException e) {
			logger.error("delete操作异常-->{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean batchDelete(String[] ids) {
		try {
			return baseMapperDao.batchDelete(ids);
		} catch (BaseException e) {
			logger.error("batchDelete操作异常-->{}", e.getMessage());
			throw e;
		}
	}

	@Override
	public T get(T entity) {
		try {
			return baseMapperDao.get(entity);
		} catch (BaseException e) {
			logger.error("get操作异常-->{}", e.getMessage());
			return null;
		}
	}

	@Override
	public List<T> getList(T entity) {
		try {
			return baseMapperDao.getList(entity);
		} catch (BaseException e) {
			logger.error("get操作异常-->{}", e.getMessage());
			return null;
		}
	}

	@Override
	public T getById(String id) {
		T obj = null;
		try {
			if (StringUtils.isNotBlank(id)) {
				obj = baseMapperDao.getById(id);
			}
		} catch (BaseException e) {
			logger.error("get操作异常-->{}", e.getMessage());
			obj = null;
		}
		return obj;
	}

	@Override
	public List<T> getByUserId(String userId) {
		try {
			return baseMapperDao.getByUserId(userId);
		} catch (BaseException e) {
			logger.error("getByUserId操作异常-->{}", e.getMessage());
			return null;
		}
	}

	@Override
	public List<T> getAll() {
		try {
			return baseMapperDao.getAll();
		} catch (BaseException e) {
			logger.error("getAll操作异常-->{}", e.getMessage());
			return null;
		}
	}

	@Override
	public Map<String, Object> getPageList(String sqlId, Object sqlParameter,
			Pager pager) {
		int currentPage = Constants.PAGE;
		int pageSize = Constants.PAGESIZE;
		if (pager != null) {
			currentPage = pager.getCurrentPage();
			pageSize = pager.getPageSize();
		}
		List<T> list = baseMapperDao.getPageList(sqlId, sqlParameter, currentPage,
				pageSize);

		Map<String, Object> data = new HashMap<String, Object>();
		ListDataModel<T> dataModel = new ListDataModel<T>();

		if (list != null) {
			PageList<T> pageList = (PageList<T>) list;
			Paginator paginator = pageList.getPaginator();
			Pagination pagination = new Pagination(paginator.getPage(),
					paginator.getTotalPages(), paginator.getTotalCount());
			dataModel.setPagination(pagination);
			if (pager.getCurrentPage() > paginator.getTotalPages()) {
				list = new ArrayList<T>();
			}
			dataModel.setList(list);
		}

		data.put("data", dataModel);
		return data;
	}

	@Override
	public Map<String, Object> getPageListWithPaginator(String sqlId, Object sqlParameter,
			Pager pager) {
		int currentPage = Constants.PAGE;
		int pageSize = Constants.PAGESIZE;
		if (pager != null) {
			currentPage = pager.getCurrentPage();
			pageSize = pager.getPageSize();
		}
		List<T> list = baseMapperDao.getPageList(sqlId, sqlParameter, currentPage,
				pageSize);

		Map<String, Object> data = new HashMap<String, Object>();
		ListDataWithPaginator<T> dataModel = new ListDataWithPaginator<T>();

		if (list != null) {
			PageList<T> pageList = (PageList<T>) list;
			Paginator paginator = pageList.getPaginator();
			dataModel.setPaginator(paginator);
			if (pager.getCurrentPage() > paginator.getTotalPages()) {
				list = new ArrayList<T>();
			}
			dataModel.setList(list);
		}
		data.put("data", dataModel);
		return data;
	}

	@Override
	public Map<String, Object> getListData(String sqlId, Object sqlParameter,
			Pager pager) {
		int currentPage = Constants.PAGE;
		int pageSize = Constants.PAGESIZE;
		if (pager != null) {
			currentPage = pager.getCurrentPage();
			pageSize = pager.getPageSize();
		}
		List<T> list = baseMapperDao.getPageList(sqlId, sqlParameter, currentPage,
				pageSize);

		Map<String, Object> data = new HashMap<String, Object>();
		if (list != null) {
			PageList<T> pageList = (PageList<T>) list;
			Paginator paginator = pageList.getPaginator();
			if (pager.getCurrentPage() > paginator.getTotalPages()) {
				list = new ArrayList<T>();
			}
			data.put("items", list);
			data.put("paginator", paginator);
		}
		return data;
	}

	@Override
	public List<T> getByIds(List<String> ids) {
		try {
			return baseMapperDao.getByIds(ids);
		} catch (BaseException e) {
			logger.error("getByIds操作异常-->{}", e.getMessage());
			return null;
		}
	}

	@Override
	public T getOne(String sqlId, T entity) {
		try {
			return baseMapperDao.getOne(sqlId, entity);
		} catch (BaseException e) {
			logger.error("getOne操作异常-->{}", e.getMessage());
			return null;
		}
	}

}
