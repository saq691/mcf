package com.mcf.base.common.utils;

import java.util.Locale;

/**
 * Title. <br>
 * Description：获取国际化消息工具类
 * <p>
 * Copyright: Copyright (c) 2016年11月14日 上午10:10:07
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class MessageUtils {

	public static String getMessage(String code, Object[] args,
			String defaultMessage, Locale locale) {
		String msg = SpringUtils.getApplicationContext().getMessage(code, args,
				defaultMessage, locale);
		return msg != null ? msg.trim() : msg;
	}

	public static String getMessage(String code) {
		return getMessage(code, null, null, Locale.CHINA);
	}

}
