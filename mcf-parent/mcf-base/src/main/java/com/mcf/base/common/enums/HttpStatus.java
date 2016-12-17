package com.mcf.base.common.enums;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:24:41
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public enum HttpStatus {
	OK_CODE(200, "OK", "成功返回状态"), 
	BDA_CODE(400, "bad request", "请求格式错误"), 
	UNAUTH_CODE(401, "unauthorized", "未授权"), 
	FORBIDDEN_CODE(403, "forbidden", "鉴权成功，但是该用户没有权限"), 
	NOT_FOUNT_CODE(404, "not found", "请求的资源不存在"), 
	NOT_ALLOWED_CODE(405, "method not allowed", "该http方法不被允许"), 
	MEDIA_TYPE_CODE(415, "unsupported media type", "请求类型错误"), 
	CHECK_CODE(422, "unprocessable entity", "校验错误时用"), 
	TO_MANY_CODE(429, "too many request", "请求过多"), 
	SERIOUS_CODE(500, "unknown abnormal", "系统发生未知异常"), 
	TOKEN_CODE(501, "token authentication failed", "token验证失败");
	private final int code;
	private final String msg;
	private final String describe;

	private HttpStatus(int code, String msg, String describe) {
		this.code = code;
		this.msg = msg;
		this.describe = describe;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String getDescribe() {
		return describe;
	}

	@Override
	public String toString() {
		return msg;
	}

}
