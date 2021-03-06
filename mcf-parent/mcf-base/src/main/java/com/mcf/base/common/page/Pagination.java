package com.mcf.base.common.page;

import com.mcf.base.model.BaseModel;

/**
 * Title. <br>
 * Description: 分页模型
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:27:48
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class Pagination extends BaseModel {
	/**
	 *
	 */
	private static final long serialVersionUID = -6649681589978260974L;
	/**
	 * 第几页
	 */
	private int page;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 总记录数
	 */
	private int totalCount;

	public Pagination() {

	}

	public Pagination(int totalPage, int totalCount) {
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}

	public Pagination(int page, int totalPage, int totalCount) {
		this.page = page;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
