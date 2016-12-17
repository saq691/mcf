package com.mcf.base.common.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:20:50
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class DateEditor extends PropertyEditorSupport {

	private static final List<String> formarts = new ArrayList<String>(2);
	static {
		formarts.add("yyyy-MM-dd");
		formarts.add("yyyy-MM-dd HH:mm:ss");
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat format = new SimpleDateFormat(formarts.get(1));
		Date date = null;
		try {
			date = format.parse(text);
		} catch (ParseException e) {
			format = new SimpleDateFormat(formarts.get(0));
			try {
				date = format.parse(text);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		setValue(date);
	}

}