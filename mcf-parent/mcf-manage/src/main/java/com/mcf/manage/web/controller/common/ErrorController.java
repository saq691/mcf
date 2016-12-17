package com.mcf.manage.web.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:42:01
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
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
