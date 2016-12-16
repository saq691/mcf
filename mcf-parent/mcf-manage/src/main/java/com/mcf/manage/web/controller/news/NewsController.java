package com.mcf.manage.web.controller.news;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mcf.base.common.annotation.SameURLData;
import com.mcf.base.common.page.Pager;
import com.mcf.base.model.ResponseData;
import com.mcf.base.pojo.NewsContent;
import com.mcf.manage.web.controller.common.BaseController;
import com.mcf.service.INewsContentService;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月17日 下午7:15:35
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {
	@Resource
	private INewsContentService newsContentService;

	/**
	 * 动态列表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView list(String keywords, Pager pager) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("keywords", keywords);

		Map<String, Object> result = newsContentService.getNewsList(parameter, pager);

		ModelAndView mv = new ModelAndView();
		mv.addObject("selected", "news");
		mv.addObject("result", result);

		mv.setViewName("news_list");
		return mv;
	}

	/**
	 * 新增或者修改页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView addNews() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("selected", "news");
		mv.setViewName("news_add");
		return mv;
	}

	/**
	 * 新增或者修改新闻资讯内容
	 * 
	 * @param newsContent
	 * @return
	 */
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	@SameURLData
	public ModelAndView saveUpdate(
			@ModelAttribute("NewsContent") NewsContent newsContent) {
		ModelAndView mv = new ModelAndView();
		boolean status = newsContentService.saveOrUpdate(newsContent);

		if (status) {
			mv.setViewName("redirect:/news/list.html");
		} else {
			mv.addObject("selected", "news");
			mv.addObject("newsContent", newsContent);
			mv.setViewName("news_add");
		}
		return mv;
	}

	/**
	 * 根据id获取新闻动态详情
	 * 
	 * @param newsType
	 * @return
	 */
	@RequestMapping(value = "/{id}.html", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView();
		NewsContent newsContent = newsContentService.getById(id);

		if (newsContent != null) {
			mv.addObject("selected", "news");
			mv.addObject("newsContent", newsContent);
			mv.setViewName("news_add");
		} else {
			mv.setViewName("redirect:/404.html");
		}
		return mv;
	}

	/**
	 * 显示
	 * 
	 * @param newsContent
	 * @return
	 */
	@RequestMapping(value = "/showStatus", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData showStatus(String id) {
		boolean status = newsContentService.updateShow(id);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "设置显示成功！");
		} else {
			responseData = new ResponseData(status, "设置显示失败！");
		}
		return responseData;
	}

	/**
	 * 隐藏
	 * 
	 * @param newsContent
	 * @return
	 */
	@RequestMapping(value = "/hideStatus", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData hideStatus(String id) {
		boolean status = newsContentService.updateHide(id);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "设置隐藏成功！");
		} else {
			responseData = new ResponseData(status, "设置隐藏失败！");
		}
		return responseData;
	}

	/**
	 * 置顶
	 * 
	 * @param newsContent
	 * @return
	 */
	@RequestMapping(value = "/successStick", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData successStick(String id) {
		boolean status = newsContentService.successStick(id);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "置顶成功！");
		} else {
			responseData = new ResponseData(status, "置顶失败！");
		}
		return responseData;
	}

	/**
	 * 取消置顶
	 * 
	 * @param newsContent
	 * @return
	 */
	@RequestMapping(value = "/cancelStick", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData cancelStick(String id) {
		boolean status = newsContentService.cancelStick(id);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "取消置顶成功！");
		} else {
			responseData = new ResponseData(status, "取消置顶失败！");
		}
		return responseData;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(String[] ids) {
		boolean status = newsContentService.batchDelete(ids);
		ResponseData responseData = null;
		if (status) {
			responseData = new ResponseData(status, "删除成功！");
		} else {
			responseData = new ResponseData(status, "删除成功！");
		}
		return responseData;
	}

}
