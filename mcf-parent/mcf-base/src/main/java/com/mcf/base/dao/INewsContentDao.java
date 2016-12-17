package com.mcf.base.dao;

import java.util.List;

import com.mcf.base.common.dao.IBaseMapperDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.NewsContent;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:33:33
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface INewsContentDao extends IBaseMapperDao<NewsContent> {
	/**
	 * 获取最新帮派动态信息列表
	 * 
	 * @return
	 * @throws BaseException
	 */
	public List<NewsContent> getNewests() throws BaseException;

	/**
	 * 获取帮派动态总记录
	 * 
	 * @return
	 * @throws BaseException
	 */
	public Integer getCountNews() throws BaseException;
}
