package com.mcf.base.common.page;

import java.util.List;

import com.mcf.base.model.BaseModel;

/**
 * 数据模型
 *
 * @author sunaiqiang
 * @version 2.0 2016-04-05
 */
public class ListDataModel<T> extends BaseModel {

	private static final long serialVersionUID = 7306881256389994639L;

	private List<T> list;

	private Pagination pagination;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
