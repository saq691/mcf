package com.mcf.base.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * Title. <br>
 * Description: 基础Mapper接口
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:21:35
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
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
