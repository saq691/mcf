package com.mcf.base.model;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:37:49
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class Msg extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4910991228083128728L;

	/**
	 * 消息名称
	 */
	private String name;

	/**
	 * 消息信息
	 */
	private String msg;

	public Msg() {
		super();
	}

	public Msg(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
