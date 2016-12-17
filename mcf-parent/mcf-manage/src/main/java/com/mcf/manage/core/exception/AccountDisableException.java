package com.mcf.manage.core.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Title. <br>
 * Description: 自定义账户已禁用异常
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:40:47
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class AccountDisableException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3046074129089206171L;

	public AccountDisableException() {
		super();
	}

	public AccountDisableException(String ex) {
		super(ex);
	}
}
