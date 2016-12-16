package com.mcf.base.common.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.mcf.base.common.constants.Constants;

/**
 * Title. <br>
 * Description：帮助工具类
 * <p>
 * Copyright: Copyright (c) 2016年11月14日 上午10:04:40
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class StringHelper {
	/**
	 * 给静态文件添加版本号，例如：?v=20150730115940
	 */
	public static String getVersion() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String version = format.format(new Date());
		return version;
	}

	/**
	 * 生成版权号，例如：2016
	 * 
	 * @return
	 */
	public static String getCopyright() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		String copyright = format.format(new Date());
		return copyright;
	}

	/**
	 * 隐藏字符串指定符合的数量
	 * 
	 * @param num
	 * @return
	 */
	public static String sethiddenAmount(String symbol, int num) {
		if (!Optional.ofNullable(symbol).isPresent()) {
			symbol = "*";
		}
		StringBuffer value = new StringBuffer();
		// 最小值数量6
		num = num == 0 ? Constants.MIN_SYMBOL_NUM : num;
		// 最小值数量12
		num = num > Constants.MAX_SYMBOL_NUM ? Constants.MAX_SYMBOL_NUM : num;
		for (int i = 0; i < num; i++) {
			value.append(symbol.replaceAll("\\s*", ""));
		}
		return value.toString();
	}

	/**
	 * 处理List集合NULL值为[]
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<T> getList(List<T> list) {
		return list == null ? new ArrayList<T>() : list;
	}

	/**
	 * 获取count个随机数
	 * 
	 * @param count
	 *            随机数个数
	 * @return
	 */
	public static String generateCode(int count) {
		StringBuffer sb = new StringBuffer();
		String str = "0123456789";
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			int num = r.nextInt(str.length());
			sb.append(str.charAt(num));
			str = str.replace((str.charAt(num) + ""), "");
		}
		return sb.toString();
	}

}
