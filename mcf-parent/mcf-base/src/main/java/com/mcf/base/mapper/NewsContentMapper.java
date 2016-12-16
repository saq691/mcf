package com.mcf.base.mapper;

import java.util.List;

import com.mcf.base.common.dao.IBaseSqlMapper;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.NewsContent;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月14日 下午5:18:13
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public interface NewsContentMapper extends IBaseSqlMapper<NewsContent> {
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