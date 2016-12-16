package com.mcf.manage.core.auth.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月16日 下午9:27:50
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class LoginToken implements AuthenticationToken {
	private static final long serialVersionUID = -866839438239842439L;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	public LoginToken() {
	}

	public LoginToken(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public Object getCredentials() {
		return this.password;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}