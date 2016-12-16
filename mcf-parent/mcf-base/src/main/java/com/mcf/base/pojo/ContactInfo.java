package com.mcf.base.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Title. <br>
 * Description: 联系信息POJO类
 * <p>
 * Copyright: Copyright (c) 2016年11月15日 下午9:57:40
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class ContactInfo extends BaseDomail {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5041325998297256056L;
	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * 是否删除，0否，1是
	 */
	private Byte isDelete;
	/**
	 * 联系姓名
	 */
	private String name;
	/**
	 * 联系方式，邮箱或者电话
	 */
	private String contactWay;
	/**
	 * 信息内容
	 */
	private String content;
	/**
	 * 是否已联系，0否，1是
	 */
	private Byte isContact;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 联系客户时间
	 */
	private Date visitTime;

	public ContactInfo() {
		super();
	}

	public ContactInfo(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay == null ? null : contactWay.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Byte getIsContact() {
		return isContact;
	}

	public void setIsContact(Byte isContact) {
		this.isContact = isContact;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

}