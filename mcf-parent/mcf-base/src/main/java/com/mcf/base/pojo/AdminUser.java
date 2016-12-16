package com.mcf.base.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mcf.base.common.enums.EnabledType;

/**
 * Title. <br>
 * Description: 用户管理POJO类
 * <p>
 * Copyright: Copyright (c) 2016年11月15日 下午9:57:48
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class AdminUser extends BaseDomail {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4154621185046074927L;
	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 是否删除，0否，1是
	 */
	private Byte isDelete;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 是否启用，0否，1是
	 */
	private Byte enabled;
	/**
	 * 是否启用转换显示
	 */
	private String convertEnabled;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public AdminUser() {
		super();
	}

	public AdminUser(String id) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public String getConvertEnabled() {
		if (EnabledType.ENABLED.getOrdinal().equals(enabled)) {
			convertEnabled = EnabledType.ENABLED.getValue();
		} else {
			convertEnabled = EnabledType.DISABLED.getValue();
		}
		return convertEnabled;
	}

	public void setConvertEnabled(String convertEnabled) {
		this.convertEnabled = convertEnabled;
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

}