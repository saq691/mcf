package com.mcf.base.common.enums;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月14日 上午10:04:31
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public enum CompanyScaleType {
	SCALE0(0, "1-49人"), SCALE1(0, "50-99人"), SCALE2(0, "100-499人"), SCALE3(0,
			"500-999人"), SCALE4(0, "1000人以上");

	private final Integer index;
	private final String value;

	private CompanyScaleType(Integer index, String value) {
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
