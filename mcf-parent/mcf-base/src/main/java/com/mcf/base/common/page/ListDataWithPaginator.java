package com.mcf.base.common.page;

import java.util.List;

import com.mcf.base.common.utils.StringHelper;
import com.mcf.base.model.BaseModel;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * 数据模型
 *
 * @param <T>
 * @author sunaiqiang
 * @version 2.0 2016-04-05
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
