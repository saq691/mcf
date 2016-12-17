package com.mcf.manage.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mcf.base.common.utils.StringHelper;

/**
 * Title. <br>
 * Description: 系统初始化变量
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:45:01
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class SystemInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		// 初始化的时候给js和css添加版本号
		sc.setAttribute("version", StringHelper.getVersion());
		sc.setAttribute("copyright", StringHelper.getCopyright());
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}