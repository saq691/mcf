package com.mcf.base.common.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.mcf.base.common.annotation.SameURLData;

/**
 * Title. <br>
 * Description: 判断请求url和数据是否和上一次相同， 一个用户相同url同时提交，
 * 相同数据验证主要通过session中保存到的url和请求参数；如果和上次相同，则是重复提交表单。
 * <p>
 * Copyright: Copyright (c) 2016年11月25日 下午7:49:57
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class SameURLDataInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			SameURLData annotation = method.getAnnotation(SameURLData.class);
			if (annotation != null) {
				if (repeatDataValidator(request)) {
					return false;
				} else {
					return true;
				}
			}
			return true;
		} else {
			return super.preHandle(request, response, handler);
		}
	}

	/**
	 * 验证同一个url数据是否相同提交 ,相同返回true
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	public boolean repeatDataValidator(HttpServletRequest request) {
		String params = JSON.toJSONString(request.getParameterMap());
		String url = request.getRequestURI();
		Map<String, String> map = new HashMap<String, String>();
		map.put(url, params);
		String nowUrlParams = map.toString();//

		// 获取HttpSession对象
		HttpSession session = request.getSession();
		Object preUrlParams = session.getAttribute("repeatData");
		if (preUrlParams == null) {
			// 如果上一个数据为null,表示还没有访问页面
			session.setAttribute("repeatData", nowUrlParams);
			return false;
		} else {
			// 否则，已经访问过页面
			if (preUrlParams.toString().equals(nowUrlParams)) {
				// 如果上次url+数据和本次url+数据相同，则表示城府添加数据
				return true;
			} else {
				// 如果上次 url+数据 和本次url加数据不同，则不是重复提交
				session.setAttribute("repeatData", nowUrlParams);
				return false;
			}
		}
	}

}
