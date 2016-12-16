package com.mcf.base.common.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.mcf.base.common.constants.Constants;
import com.mcf.base.common.dao.IBaseMapperDao;
import com.mcf.base.common.dao.IBaseSqlMapper;
import com.mcf.base.exception.BaseException;

/**
 * 基础dao接口实现类
 *
 * @param <T>
 * @author sunaiqiang
 * @version 2.0 2016-04-05
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BaseMapperDaoImpl<T> extends SqlSessionDaoSupport
		implements IBaseMapperDao<T> {

	public static final Logger logger = LoggerFactory.getLogger(BaseMapperDaoImpl.class);

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	private Class<? extends IBaseSqlMapper> mapperClass;

	public void setMapperClass(Class<? extends IBaseSqlMapper> mapperClass) {
		this.mapperClass = mapperClass;
	}

	private IBaseSqlMapper<T> getMapper() {
		return super.getSqlSession().getMapper(mapperClass);
	}

	@Override
	public boolean add(T entity) throws BaseException {
		boolean flag = false;
		try {
			this.getMapper().add(entity);
			flag = true;
		} catch (RuntimeException e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean batchAdd(List<T> list) throws BaseException {
		boolean flag = false;
		try {
			this.getMapper().batchAdd(list);
			flag = true;
		} catch (RuntimeException e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean update(T entity) throws BaseException {
		boolean flag = false;
		try {
			this.getMapper().update(entity);
			flag = true;
		} catch (RuntimeException e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean delete(T entity) throws BaseException {
		boolean flag = false;
		try {
			this.getMapper().delete(entity);
			flag = true;
		} catch (RuntimeException e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean batchDelete(String[] ids) throws BaseException {
		boolean flag = false;
		try {
			if (ids != null && ids.length > 0) {
				this.getMapper().batchDelete(ids);
				flag = true;
			}
		} catch (RuntimeException e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public T get(T entity) throws BaseException {
		return this.getMapper().get(entity);
	}

	@Override
	public List<T> getList(T entity) throws BaseException {
		return this.getMapper().getList(entity);
	}

	@Override
	public T getById(String id) throws DataAccessException {
		return this.getMapper().getById(id);
	}

	@Override
	public List<T> getByIds(List<String> ids) throws BaseException {
		return this.getMapper().getByIds(ids);
	}

	@Override
	public List<T> getByUserId(String userId) throws BaseException {
		return this.getMapper().getByUserId(userId);
	}

	@Override
	public List<T> getAll() throws BaseException {
		return this.getMapper().getList(null);
	}

	@Override
	public T getOne(String sqlId, T entity) {
		return super.getSqlSession().selectOne(mapperClass.getName() + "." + sqlId,
				entity);
	}

	@Override
	public List<T> getPageList(String sqlId, Object sqlParameter, int page,
			int pageSize) {
		try {
			if (page <= 0) {// 开始页
				page = Constants.PAGE;
			}
			if (pageSize <= 0) {// 每页显示大小
				pageSize = Constants.PAGESIZE;
			}
			PageBounds pageBounds = new PageBounds(page, pageSize);
			return super.getSqlSession().selectList(mapperClass.getName() + "." + sqlId,
					sqlParameter, pageBounds);
		} catch (RuntimeException e) {
			logger.error("分页查询失败！异常：", e);
			return null;
		}
	}

	@Override
	public List<T> getPageList(String sqlId, Object sqlParameter, int page, int pageSize,
			String orderSegment) {
		if (StringUtils.isBlank(orderSegment)) {
			return this.getPageList(sqlId, sqlParameter, page, pageSize);
		}
		try {
			if (page <= 0) {// 开始页
				page = Constants.PAGE;
			}
			if (pageSize <= 0) {// 每页显示大小
				pageSize = Constants.PAGESIZE;
			}
			PageBounds pageBounds = new PageBounds(page, pageSize,
					Order.formString(orderSegment));
			return super.getSqlSession().selectList(mapperClass.getName() + "." + sqlId,
					sqlParameter, pageBounds);
		} catch (RuntimeException e) {
			logger.error("分页查询失败！异常：", e);
			return null;
		}
	}

	public List<T> getPageList(String sqlId, String countSqlId, Object sqlParameter,
			int page, int pageSize) {
		try {
			if (page <= 0) {// 开始页
				page = Constants.PAGE;
			}
			if (pageSize <= 0) {// 每页显示大小
				pageSize = Constants.PAGESIZE;
			}
			PageBounds pageBounds = new PageBounds(page, pageSize, false);
			List<T> list = super.getSqlSession().selectList(
					mapperClass.getName() + "." + sqlId, sqlParameter, pageBounds);
			Integer totalCount = super.getSqlSession()
					.selectOne(mapperClass.getName() + "." + countSqlId, sqlParameter);
			Paginator paginator = new Paginator(page, pageSize, totalCount);
			PageList<T> pageList = new PageList<T>(list, paginator);
			return pageList;
		} catch (RuntimeException e) {
			logger.error("分页查询失败！异常：", e);
			return null;
		}
	}

}
