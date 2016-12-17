package com.mcf.base.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Title. <br>
 * Description: 申请合伙人POJO类
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:39:33
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class Copartner extends BaseDomail {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6343531193066629227L;
	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 是否删除，0否，1是
	 */
	private Byte isDelete;
	/**
	 * 城市名称
	 */
	private String cityName;
	/**
	 * 城市id
	 */
	private Integer cityId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 联系方式
	 */
	private String contactWay;
	/**
	 * 主营业务
	 */
	private String mainBusiness;
	/**
	 * 公司人数，0标示1-49，1标示50-99，2标示100-499，3标示500-999，4标示1000以上
	 */
	private Byte companyScale;
	/**
	 * 
	 */
	private String scompanyScale;
	/**
	 * 合作类型，0企业，1个体
	 */
	private Byte cooperateType;
	/**
	 * 
	 */
	private String scooperateType;
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

	public Copartner() {
		super();
	}

	public Copartner(String id) {
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness == null ? null : mainBusiness.trim();
	}

	public Byte getCompanyScale() {
		return companyScale;
	}

	public void setCompanyScale(Byte companyScale) {
		this.companyScale = companyScale;
	}

	public Byte getCooperateType() {
		return cooperateType;
	}

	public void setCooperateType(Byte cooperateType) {
		this.cooperateType = cooperateType;
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

	public String getScompanyScale() {
		return scompanyScale;
	}

	public void setScompanyScale(String scompanyScale) {
		this.scompanyScale = scompanyScale;
	}

	public String getScooperateType() {
		return scooperateType;
	}

	public void setScooperateType(String scooperateType) {
		this.scooperateType = scooperateType;
	}

}