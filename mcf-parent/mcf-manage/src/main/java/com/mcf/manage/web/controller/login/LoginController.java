package com.mcf.manage.web.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcf.base.pojo.AdminUser;
import com.mcf.manage.core.auth.token.LoginToken;
import com.mcf.manage.core.exception.AccountDisableException;
import com.mcf.manage.core.model.LoginModel;
import com.mcf.manage.web.controller.common.BaseController;

/**
 * 
 * Title. <br>
 * Description: 登录中心
 * <p>
 * Copyright: Copyright (c) 2016年11月16日 下午9:48:09
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Controller
public class LoginController extends BaseController {
	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param loginModel
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/toLogin", method = RequestMethod.POST)
	public String loginForm(@Valid @ModelAttribute("loginModel") LoginModel loginModel,
			BindingResult br, HttpServletRequest request, Model model) {
		String toLoginMessage = "";
		if (!br.hasErrors()) {
			Subject subject = SecurityUtils.getSubject();
			try {
				LoginToken loginToken = new LoginToken(loginModel.getUsername(),
						loginModel.getPassword());
				subject.login(loginToken);// 进行登录
				if (subject != null && subject.isAuthenticated()) {// 登录成功
					AdminUser adminUser = (AdminUser) subject.getPrincipal();
					Session session = subject.getSession();
					session.setAttribute("user", adminUser);
					return "redirect:/index.html";
				}
			} catch (UnknownAccountException e) {
				toLoginMessage = "帐号不存在";
			} catch (IncorrectCredentialsException e) {
				toLoginMessage = "密码不正确";
			} catch (AccountDisableException e) {
				toLoginMessage = "账号已禁用，请联系管理员";
			} catch (Exception e) {
				toLoginMessage = "用户名或密码错误";
			}
		}
		model.addAttribute("toLoginMessage", toLoginMessage);
		return "login";
	}

}
