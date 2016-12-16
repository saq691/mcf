package com.mcf.manage.web.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	/**
	 * 跑火星去了，找不到页面
	 * 
	 * @return
	 */
	@RequestMapping("/404.html")
	public String notFind() {
		return "404";
	}

	/**
	 * 系统服务器响应超时、错误
	 * 
	 * @return
	 */
	@RequestMapping("/500.html")
	public String error() {
		return "500";
	}

}
