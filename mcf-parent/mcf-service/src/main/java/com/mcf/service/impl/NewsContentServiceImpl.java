package com.mcf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mcf.base.common.dao.IBaseMapperDao;
import com.mcf.base.common.enums.IsDeleteType;
import com.mcf.base.common.enums.StickType;
import com.mcf.base.common.page.Pager;
import com.mcf.base.common.service.impl.BaseServiceImpl;
import com.mcf.base.common.utils.JodaUtils;
import com.mcf.base.common.utils.RandomUtils;
import com.mcf.base.dao.INewsContentDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.NewsContent;
import com.mcf.service.INewsContentService;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月15日 上午12:43:51
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Service("newsContentService")
public class NewsContentServiceImpl extends BaseServiceImpl<NewsContent>
		implements INewsContentService {

	private static Logger logger = LoggerFactory.getLogger(NewsContentServiceImpl.class);

	@Resource
	private INewsContentDao newsContentDao;

	@Resource(name = "newsContentDao")
	@Override
	public void setBaseMapperDao(IBaseMapperDao<NewsContent> baseMapperDao) {
		super.setBaseMapperDao(baseMapperDao);
	}

	@Override
	public Map<String, Object> getNewsList(Map<String, Object> parameter, Pager pager)
			throws BaseException {
		Map<String, Object> listMap = null;
		try {
			listMap = this.getListData("getNewsList", parameter, pager);
		} catch (BaseException e) {
			logger.error("获取所有帮派动态信息列表--->{}");
			throw e;
		}
		return listMap;
	}

	@Override
	public Map<String, Object> getNewsListByShow(Pager pager) throws BaseException {
		Map<String, Object> listMap = null;
		try {
			listMap = this.getListData("getNewsListByShow", null, pager);
		} catch (BaseException e) {
			logger.error("获取所有帮派动态显示列表--->{}");
			throw e;
		}
		return listMap;
	}

	@Override
	public List<NewsContent> getNewests() {
		List<NewsContent> list = newsContentDao.getNewests();
		return list;
	}

	@Override
	public Integer getCountNews() {
		return newsContentDao.getCountNews();
	}

	@Override
	public boolean saveOrUpdate(NewsContent newsContent) {
		boolean status = false;
		Date nowTime = JodaUtils.getNowDate();

		String id = newsContent.getId();
		if (StringUtils.isNotBlank(id)) {
			// 修改新闻动态内容
			NewsContent obj = newsContentDao.get(newsContent);
			if (newsContent != null) {
				newsContent.setUpdateTime(nowTime);
				BeanUtils.copyProperties(newsContent, obj);
				status = newsContentDao.update(obj);
			}
		} else {
			// 新增新闻动态内容
			newsContent.setId(RandomUtils.getGenerateId());
			newsContent.setCreateTime(nowTime);
			newsContent.setUpdateTime(nowTime);

			// 将entity对象值复制给target对象
			NewsContent target = new NewsContent();
			BeanUtils.copyProperties(newsContent, target);

			// 执行保存
			status = newsContentDao.add(target);
		}
		return status;
	}

	@Override
	public boolean updateShow(String id) {
		boolean status = false;

		NewsContent updateNews = this.getById(id);
		if (updateNews != null) {
			updateNews.setIsShow(IsDeleteType.DELETE.getOrdinal());
			updateNews.setUpdateTime(JodaUtils.getNowDate());
			status = newsContentDao.update(updateNews);
		}
		return status;
	}

	@Override
	public boolean updateHide(String id) {
		boolean status = false;

		NewsContent updateNews = this.getById(id);
		if (updateNews != null) {
			updateNews.setIsShow(IsDeleteType.NOT_DELETE.getOrdinal());
			updateNews.setUpdateTime(JodaUtils.getNowDate());
			status = newsContentDao.update(updateNews);
		}
		return status;
	}

	@Override
	public boolean cancelStick(String id) {
		boolean status = false;

		NewsContent updateNews = this.getById(id);
		if (updateNews != null) {
			updateNews.setIsStick(StickType.NOT_STICK.getOrdinal());
			updateNews.setUpdateTime(JodaUtils.getNowDate());
			status = newsContentDao.update(updateNews);
		}
		return status;
	}

	@Override
	public boolean successStick(String id) {
		boolean status = false;

		NewsContent updateNews = this.getById(id);
		if (updateNews != null) {
			updateNews.setIsStick(StickType.STICKED.getOrdinal());
			updateNews.setUpdateTime(JodaUtils.getNowDate());
			status = newsContentDao.update(updateNews);
		}
		return status;
	}

}
