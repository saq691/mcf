package com.mcf.base.common.page;

import com.mcf.base.common.constants.Constants;
import com.mcf.base.model.BaseModel;

public class Pager extends BaseModel {
	/**
	 *
	 */
	private static final long serialVersionUID = -3361651088667088509L;
	/**
	 * 开始页
	 */
	private int currentPage;
	/**
	 * 每页大小
	 */
	private int pageSize;
	/**
	 * 分页插件已经处理sql注入的问题 ex: "id.asc,code.desc" or "code.desc"
	 */
	private String orderSegment;

	public Pager() {

	}

	public Pager(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public Pager(int currentPage, int pageSize, String orderSegment) {
		this(currentPage, pageSize);
		this.orderSegment = orderSegment;
	}

	public int getCurrentPage() {
		try {
			if (currentPage <= 0) {
				currentPage = Constants.PAGE;
			}
		} catch (RuntimeException e) {
			currentPage = Constants.PAGE;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		try {
			if (pageSize <= 0) {
				pageSize = Constants.PAGESIZE;
			}
		} catch (RuntimeException e) {
			pageSize = Constants.PAGESIZE;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderSegment() {
		return orderSegment;
	}

	public void setOrderSegment(String orderSegment) {
		this.orderSegment = orderSegment;
	}

}
