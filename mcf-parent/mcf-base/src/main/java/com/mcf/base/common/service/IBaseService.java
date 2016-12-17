package com.mcf.base.common.service;

import java.util.List;
import java.util.Map;

import com.mcf.base.common.page.Pager;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:28:03
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface IBaseService<T> {
	/**
	 * 添加实体对象
	 *
	 * @param entity
	 *            实体对象
	 * @return true/false 标记
	 */
	boolean add(T entity);

	/**
	 * 批量添加实体对象
	 *
	 * @param list
	 *            实体对象数组
	 * @return true/false 标记
	 */
	boolean batchAdd(List<T> list);

	/**
	 * 更新实体对象
	 *
	 * @param entity
	 *            实体对象
	 * @return true/false 标记
	 */
	boolean update(T entity);

	/**
	 * 删除实体对象
	 *
	 * @param entity
	 *            实体对象
	 * @return true/false 标记
	 */
	boolean delete(T entity);

	/**
	 * 根据ids批量删除实体对象
	 *
	 * @param ids
	 *            id数组
	 * @return true/false 标记
	 */
	boolean batchDelete(String[] ids);

	/**
	 * 查询实体对象
	 *
	 * @param entity
	 *            实体对象
	 * @return T 实体对象
	 */
	T get(T entity);

	/**
	 * 根据实体对象参数,返回List
	 *
	 * @param entity
	 * @return
	 */
	List<T> getList(T entity);

	/**
	 * 根据id查询唯一实体对象
	 *
	 * @param id
	 *            传入id参数
	 * @return T 实体对象
	 */
	T getById(String id);

	/**
	 * 根据id列表查询对象
	 *
	 * @param ids
	 *            id列表
	 * @return 实体列表
	 */
	List<T> getByIds(List<String> ids);

	/**
	 * 根据用户ID查询对象
	 *
	 * @param userId
	 *            用户ID
	 * @return 实体列表
	 */
	List<T> getByUserId(String userId);

	/**
	 * 查询所有实体对象
	 *
	 * @return 实体列表
	 */
	List<T> getAll();

	/**
	 * 根据Mapper接口，返回一个实体
	 *
	 * @param sqlId
	 * @param entity
	 * @return
	 */
	T getOne(String sqlId, T entity);

	/**
	 * 根据Mapper接口查询方法，分页查询
	 *
	 * @param sqlId
	 * @param sqlParameter
	 * @param pager
	 *            分页信息（页码 分页大小）
	 * @return 实体列表
	 */
	Map<String, Object> getPageList(String sqlId, Object sqlParameter, Pager pager);

	/**
	 * 根据Mapper接口查询方法，分页查询根据
	 *
	 * @param sqlId
	 * @param sqlParameter
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> getPageListWithPaginator(String sqlId, Object sqlParameter,
			Pager pager);

	/**
	 * 列表的Map对象
	 *
	 * @param sqlId
	 * @param sqlParameter
	 * @param pager
	 * @return
	 */
	Map<String, Object> getListData(String sqlId, Object sqlParameter, Pager pager);
}
