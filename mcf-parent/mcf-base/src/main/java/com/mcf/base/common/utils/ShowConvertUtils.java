package com.mcf.base.common.utils;

import org.apache.commons.lang3.StringUtils;

import com.mcf.base.common.enums.CompanyScaleType;
import com.mcf.base.common.enums.ContactType;
import com.mcf.base.common.enums.CooperateType;
import com.mcf.base.common.enums.StickType;

/**
 * Title. <br>
 * Description：显示转换工具类
 * <p>
 * Copyright: Copyright (c) 2016年11月14日 上午10:11:16
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class ShowConvertUtils {
	/**
	 * 是否置顶转换显示，默认值：否
	 * 
	 * @param gender
	 * @return
	 */
	public static String converStick(Byte isStick) {
		if (StickType.NOT_STICK.getOrdinal().equals(isStick)) {
			return StickType.NOT_STICK.getValue();
		} else if (StickType.STICKED.getOrdinal().equals(isStick)) {
			return StickType.STICKED.getValue();
		} else {
			return StickType.NOT_STICK.getValue();
		}
	}

	/**
	 * 是否联系
	 * 
	 * @param isContact
	 *            联系标记
	 * @return
	 */
	public static Byte isContact(Byte isContact) {
		if (isContact == null) {
			isContact = ContactType.NOT_CONTACT.getOrdinal();
		} else {
			if (!ContactType.CONTACTED.getOrdinal().equals(isContact)
					&& !ContactType.NOT_CONTACT.getOrdinal().equals(isContact)) {
				isContact = ContactType.NOT_CONTACT.getOrdinal();
			}
		}
		return isContact;
	}

	/**
	 * 设置公司规模
	 * 
	 * @param companyScale
	 *            公司规模
	 * @return
	 */
	public static Byte companyScale(String companyScale) {
		Byte scale = null;
		if (!StringUtils.isNotBlank(companyScale)) {
			scale = CompanyScaleType.SCALE0.getOrdinal();
		} else {
			if (CompanyScaleType.SCALE0.getValue().equals(companyScale)) {
				scale = CompanyScaleType.SCALE0.getOrdinal();
			} else if (CompanyScaleType.SCALE1.getValue().equals(companyScale)) {
				scale = CompanyScaleType.SCALE1.getOrdinal();
			} else if (CompanyScaleType.SCALE2.getValue().equals(companyScale)) {
				scale = CompanyScaleType.SCALE2.getOrdinal();
			} else if (CompanyScaleType.SCALE3.getValue().equals(companyScale)) {
				scale = CompanyScaleType.SCALE3.getOrdinal();
			} else if (CompanyScaleType.SCALE4.getValue().equals(companyScale)) {
				scale = CompanyScaleType.SCALE4.getOrdinal();
			} else {
				scale = CompanyScaleType.SCALE0.getOrdinal();
			}
		}
		return scale;
	}

	/**
	 * 设置合作类型
	 * 
	 * @param cooperateType
	 *            合作类型
	 * @return
	 */
	public static Byte cooperateType(String cooperateType) {
		Byte type = null;
		if (!StringUtils.isNotBlank(cooperateType)) {
			type = CooperateType.COMPANY.getOrdinal();
		} else {
			if (CooperateType.COMPANY.getValue().equals(cooperateType)) {
				type = CooperateType.COMPANY.getOrdinal();
			} else if (CooperateType.UNITY.getValue().equals(cooperateType)) {
				type = CooperateType.UNITY.getOrdinal();
			} else {
				type = CooperateType.COMPANY.getOrdinal();
			}
		}
		return type;
	}

}
