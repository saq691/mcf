package com.mcf.base.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * 基础Mapper接口
 *
 * @author sunaiqiang
 * @version 2.0 2016-04-05
 */
public interface IBaseSqlMapper<T> extends ISqlMapper {

	void add(T entity) throws DataAccessException;

	void batchAdd(List<T> list) throws DataAccessException;

	void update(T entity) throws DataAccessException;

	void delete(T entity) throws DataAccessException;

	boolean batchDelete(String[] ids) throws DataAccessException;

	T get(T entity) throws DataAccessException;

	T getById(String id) throws DataAccessException;

	List<T> getByIds(List<String> ids) throws DataAccessException;

	List<T> getByUserId(String userId) throws DataAccessException;

	List<T> getList(T entity) throws DataAccessException;

	T getOne(String sqlId, T entity);
}
