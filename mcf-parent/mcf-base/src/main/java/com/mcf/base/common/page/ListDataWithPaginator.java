package com.mcf.base.common.page;

import java.util.List;

import com.mcf.base.common.utils.StringHelper;
import com.mcf.base.model.BaseModel;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * Title. <br>
 * Description: 数据模型
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:27:16
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class ListDataWithPaginator<T> extends BaseModel {

	private static final long serialVersionUID = 3503243417651020553L;

	private List<T> list;

	private Paginator paginator;

	public List<T> getList() {
		list = StringHelper.getList(list);
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

}
