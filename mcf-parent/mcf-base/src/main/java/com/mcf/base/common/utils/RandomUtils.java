package com.mcf.base.common.utils;

import java.util.UUID;

/**
 * Title. <br>
 * Description：32位UUID生成工具类
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:31:01
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class RandomUtils {
	/**
	 * 获取32位的uuid字符串
	 * 
	 * @return
	 */
	public static String getGenerateId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}