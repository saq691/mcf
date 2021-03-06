package com.mcf.base.common.enums;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:24:08
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public enum ContactType {
	NOT_CONTACT(0, "否"), CONTACTED(1, "是");
	private final Integer index;
	private final String value;

	private ContactType(Integer index, String value) {
		this.index = index;
		this.value = value;
	}

	public Integer getIndex() {
		return index;
	}

	public Byte getOrdinal() {
		return index.byteValue();
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
