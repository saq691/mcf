package com.mcf.base.exception;

/**
 * Title. <br>
 * Description：基本的自定义运行时异常
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:35:48
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 8984571387720954464L;

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException() {
		super();
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

}
