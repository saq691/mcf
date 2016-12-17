package com.mcf.base.common.page;

import java.util.List;

import com.mcf.base.model.BaseModel;

/**
 * Title. <br>
 * Description: 数据模型
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:27:02
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
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
