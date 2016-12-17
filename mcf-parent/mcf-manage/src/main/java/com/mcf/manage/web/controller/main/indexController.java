package com.mcf.manage.web.controller.main;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mcf.manage.web.controller.common.BaseController;
import com.mcf.service.INewsContentService;

/**
 * Title. <br>
 * Description: 首页中心
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:43:37
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class indexController extends BaseController {
	@Resource
	public INewsContentService newsContentService;

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("selected", "index");
		mv.addObject("totalRecords", newsContentService.getCountNews());
		mv.addObject("news", newsContentService.getNewests());
		return mv;
	}

}
