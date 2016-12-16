package com.mcf.base.pojo;

/**
 * Title. <br>
 * Description: 地址省市区字典POJO类
 * <p>
 * Copyright: Copyright (c) 2016年11月15日 下午9:57:54
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class Address extends BaseDomail {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5496961630017409850L;
	/**
	 * 主键Id
	 */
	private Integer id;
	/**
	 * 地址名称
	 */
	private String name;
	/**
	 * 父id
	 */
	private Integer parentId;
	/**
	 * 简称
	 */
	private String shortName;
	/**
	 * 级别
	 */
	private Byte levelType;
	/**
	 * 城市编码
	 */
	private Integer cityCode;
	/**
	 * 区号
	 */
	private Integer zipCode;
	/**
	 * 完整地址
	 */
	private String mergerName;
	/**
	 * 经度
	 */
	private Double lng;
	/**
	 * 纬度
	 */
	private Double lat;
	/**
	 * 拼音
	 */
	private String pinyin;
	/**
	 * 是否热门城市，0否，1是
	 */
	private Byte hotCity;
	/**
	 * 排序
	 */
	private Integer sortFlag;
	/**
	 * 是否显示，0是，1否
	 */
	private Byte isFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName == null ? null : shortName.trim();
	}

	public Byte getLevelType() {
		return levelType;
	}

	public void setLevelType(Byte levelType) {
		this.levelType = levelType;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getMergerName() {
		return mergerName;
	}

	public void setMergerName(String mergerName) {
		this.mergerName = mergerName == null ? null : mergerName.trim();
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin == null ? null : pinyin.trim();
	}

	public Byte getHotCity() {
		return hotCity;
	}

	public void setHotCity(Byte hotCity) {
		this.hotCity = hotCity;
	}

	public Integer getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(Integer sortFlag) {
		this.sortFlag = sortFlag;
	}

	public Byte getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(Byte isFlag) {
		this.isFlag = isFlag;
	}
}