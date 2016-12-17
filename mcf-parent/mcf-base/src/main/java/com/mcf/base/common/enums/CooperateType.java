package com.mcf.base.common.enums;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:24:18
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public enum CooperateType {
	COMPANY(0, "企业"), UNITY(1, "个体");

	private final Integer index;
	private final String value;

	private CooperateType(Integer index, String value) {
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
