package com.mcf.base.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mcf.base.exception.BaseException;

/**
 * 基础dao接口
 *
 * @param <T>
 * @author sunaiqiang
 * @version 2.0 2016-04-05
 */
@SuppressWarnings("rawtypes")
public interface IBaseMapperDao<T> {

	void setMapperClass(Class<? extends IBaseSqlMapper> mapperClass);

	boolean add(T entity) throws BaseException;

	boolean batchAdd(List<T> list) throws BaseException;

	boolean update(T entity) throws BaseException;

	boolean delete(T entity) throws BaseException;

	boolean batchDelete(String[] ids) throws BaseException;

	T get(T entity) throws BaseException;

	List<T> getList(T entity) throws BaseException;

	T getById(String id) throws DataAccessException;

	List<T> getByIds(List<String> ids) throws BaseException;

	List<T> getByUserId(String userId) throws BaseException;

	List<T> getAll() throws BaseException;

	List<T> getPageList(String sqlId, Object sqlParameter, int page, int pageSize);

	List<T> getPageList(String sqlId, Object sqlParameter, int page, int pageSize,
			String orderSegment);

	List<T> getPageList(String sqlId, String countSqlId, Object sqlParameter, int page,
			int pageSize);

	T getOne(String sqlId, T entity);
}