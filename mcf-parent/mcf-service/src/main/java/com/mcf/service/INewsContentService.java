package com.mcf.service;

import java.util.List;
import java.util.Map;

import com.mcf.base.common.page.Pager;
import com.mcf.base.common.service.IBaseService;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.NewsContent;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:46:41
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface INewsContentService extends IBaseService<NewsContent> {
	/**
	 * 新增或者修改新闻资讯内容
	 * 
	 * @param newsContent
	 *            新闻资讯对象
	 * @return
	 */
	public boolean saveOrUpdate(NewsContent newsContent);

	/**
	 * 获取所有帮派动态信息列表
	 * 
	 * @param parameter
	 * @param pager
	 * @return
	 * @throws BaseException
	 */
	public Map<String, Object> getNewsList(Map<String, Object> parameter, Pager pager)
			throws BaseException;

	/**
	 * 获取所有帮派动态显示列表
	 * 
	 * @param parameter
	 * @param pager
	 * @return
	 * @throws BaseException
	 */
	public Map<String, Object> getNewsListByShow(Pager pager) throws BaseException;

	/**
	 * 获取最新帮派动态信息列表
	 * 
	 * @return
	 * @throws BaseException
	 */
	public List<NewsContent> getNewests();

	/**
	 * 获取帮派动态总记录
	 * 
	 * @return
	 * @throws BaseException
	 */
	public Integer getCountNews();

	/**
	 * 设置显示
	 * 
	 * @param id
	 *            对象id
	 * @return
	 */
	public boolean updateShow(String id);

	/**
	 * 设置隐藏
	 * 
	 * @param id
	 *            对象id
	 * @return
	 */
	public boolean updateHide(String id);

	/**
	 * 取消置顶
	 * 
	 * @param id
	 *            对象id
	 * @return
	 */
	public boolean cancelStick(String id);

	/**
	 * 置顶
	 * 
	 * @param id
	 *            对象id
	 * @return
	 */
	public boolean successStick(String id);

}
