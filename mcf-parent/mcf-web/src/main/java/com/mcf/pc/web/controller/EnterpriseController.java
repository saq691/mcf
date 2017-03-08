package com.mcf.pc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mcf.base.common.page.Pager;

/**
 * Title. <br>
 * Description: 派手商户端Controller
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:49:09
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class EnterpriseController {
	
	/**
	 * 派手商户端页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/enterprise.html")
	public ModelAndView list(Pager pager) {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("enterprise");
		return mv;
	}

}
