package com.mcf.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.mcf.base.common.enums.IsDeleteType;
import com.mcf.base.common.page.Pager;
import com.mcf.base.pojo.NewsContent;
import com.mcf.service.INewsContentService;

/**
 * Title. <br>
 * Description: 帮派动态中心
 * <p>
 * Copyright: Copyright (c) 2016年11月18日 上午11:41:58
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class NewsController {
	@Autowired
	private INewsContentService newsContentService;

	/**
	 * 帮派动态列表页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/news.html")
	public ModelAndView list(Pager pager) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("isShow", IsDeleteType.DELETE.getOrdinal());

		Map<String, Object> datas = newsContentService.getNewsListByShow(pager);

		ModelAndView mv = new ModelAndView();
		mv.addObject("selected", "news");
		mv.addObject("datas", datas);

		mv.setViewName("news");
		return mv;
	}

	/**
	 * 根据id获取新闻动态详情
	 * 
	 * @param newsType
	 * @return
	 */
	@GetMapping("/{id}.html")
	public ModelAndView detail(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView();
		NewsContent newsContent = newsContentService.getById(id);

		if (newsContent != null) {
			mv.addObject("newsContent", newsContent);
			mv.setViewName("news-detail");
		}
		return mv;
	}

}
