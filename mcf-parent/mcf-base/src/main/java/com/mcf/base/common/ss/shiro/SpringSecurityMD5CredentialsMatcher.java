package com.mcf.base.common.ss.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.mcf.base.common.utils.SSEncryptionUtils;

/**
 * Title. <br>
 * Description：实现自定义的加密算法（Spring Security的MD5加密算法）实现自定义的加密算法（Spring
 * Security的MD5加密算法）
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:28:53
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class SpringSecurityMD5CredentialsMatcher
		extends
			SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {

		// token.getCredentials()实际类型为字符数组
		char[] credentials = (char[]) token.getCredentials();

		// 字符数组转字符串
		String credentialsStr = new String(credentials);

		// Spring Security的MD5加密
		Object tokenCredentials = SSEncryptionUtils
				.saltMD5Encoder(credentialsStr);
		Object accountCredentials = getCredentials(info);
		return equals(tokenCredentials, accountCredentials);
	}
}
