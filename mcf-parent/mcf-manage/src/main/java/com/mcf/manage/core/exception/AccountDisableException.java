package com.mcf.manage.core.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Title. <br>
 * Description: 自定义账户已禁用异常
 * <p>
 * Copyright: Copyright (c) 2016年11月16日 下午10:03:44
 * <p>
 * Company: 成都媒超风信息技术有限公司
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
