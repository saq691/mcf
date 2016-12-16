package com.mcf.base.common.utils;

import java.security.MessageDigest;

import com.mcf.base.common.ss.encoding.Md5PasswordEncoder;

/**
 * Title. <br>
 * Description：Spring Security MD5加密
 * <p>
 * Copyright: Copyright (c) 2016年11月14日 上午10:11:57
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class SSEncryptionUtils {

	private final static char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private static String bytesToHex(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		int t;
		for (int i = 0; i < 16; i++) {
			t = bytes[i];
			if (t < 0)
				t += 256;
			sb.append(hexDigits[(t >>> 4)]);
			sb.append(hexDigits[(t % 16)]);
		}
		return sb.toString();
	}

	public static String md5(String input) {
		return code(input, 32);
	}

	public static String md5Hex(String input) {
		return code(input, 16);
	}

	public static String code(String input, int bit) {
		try {
			MessageDigest md = MessageDigest
					.getInstance(System.getProperty("MD5.algorithm", "MD5"));
			if (bit == 16) {
				return bytesToHex(md.digest(input.getBytes("utf-8"))).substring(8, 24);
			} else {
				return bytesToHex(md.digest(input.getBytes("utf-8")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String saltMD5Encoder(String rawStr) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		/** 不带盐值的MD5加密 */
		return encoder.encodePassword(rawStr, null);
	}

	public static void main(String[] args) {
		System.out.println(saltMD5Encoder("bppd#2016"));
	}

}
