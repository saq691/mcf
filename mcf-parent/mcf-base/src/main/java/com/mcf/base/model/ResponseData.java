package com.mcf.base.model;

import java.util.List;

public class ResponseData extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7722020337673847048L;

	/**
	 * 状态
	 */
	private Boolean status;

	/**
	 * 成功或是失败消息
	 */
	private String msg;

	/**
	 * 消息集合
	 */
	private List<Msg> msgs;

	public ResponseData() {
		super();
	}

	public ResponseData(Boolean status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public ResponseData(Boolean status, String msg, List<Msg> msgs) {
		super();
		this.status = status;
		this.msg = msg;
		this.msgs = msgs;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Msg> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<Msg> msgs) {
		this.msgs = msgs;
	}

}
