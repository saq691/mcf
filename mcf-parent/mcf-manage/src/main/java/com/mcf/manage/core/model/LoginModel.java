package com.mcf.manage.core.model;

import org.hibernate.validator.constraints.NotBlank;

import com.mcf.base.model.BaseModel;

/**
 * Title. <br>
 * Description: 用户登录model类
 * <p>
 * Copyright: Copyright (c) 2016年11月16日 下午9:55:16
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class LoginModel extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4525014736743740463L;
	/**
	 * 用户名
	 */
	@NotBlank(message = "{login.username.error}")
	private String username;

	/**
	 * 密码
	 */
	@NotBlank(message = "{login.password.error}")
	private String password;

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