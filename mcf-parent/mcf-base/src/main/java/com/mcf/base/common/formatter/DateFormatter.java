package com.mcf.base.common.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 * Title. <br>
 * Description: 自定义Formatter，需要实现Formatter接口/Formatter接口泛型，就是要转换的类型
 * <p>
 * Copyright: Copyright (c) 2016年11月27日 下午4:53:26
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class DateFormatter implements Formatter<Date> {

	public String print(Date object, Locale locale) {
		return object.toString();
	}

	public Date parse(String text, Locale locale) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.parse(text);
	}

}
