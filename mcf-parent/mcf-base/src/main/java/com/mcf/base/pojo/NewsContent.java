package com.mcf.base.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Title. <br>
 * Description: 新闻资讯内容POJO类
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:39:49
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class NewsContent extends BaseDomail {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8530193338961759106L;
	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 是否显示，0否，1是
	 */
	private Byte isShow;
	/**
	 * 内容标题
	 */
	private String title;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 摘要
	 */
	private String digest;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 浏览数量
	 */
	private Integer browseNum;
	/**
	 * 是否置顶，0否，1是
	 */
	private Byte isStick;
	/**
	 * 创建者
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public NewsContent() {

	}

	public NewsContent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Byte getIsShow() {
		return isShow;
	}

	public void setIsShow(Byte isShow) {
		this.isShow = isShow;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest == null ? null : digest.trim();
	}

	public Integer getBrowseNum() {
		return browseNum;
	}

	public void setBrowseNum(Integer browseNum) {
		this.browseNum = browseNum;
	}

	public Byte getIsStick() {
		return isStick;
	}

	public void setIsStick(Byte isStick) {
		this.isStick = isStick;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator == null ? null : creator.trim();
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
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}