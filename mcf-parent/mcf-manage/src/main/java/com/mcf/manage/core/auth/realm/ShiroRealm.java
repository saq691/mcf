package com.mcf.manage.core.auth.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.mcf.base.common.enums.EnabledType;
import com.mcf.base.common.utils.SSEncryptionUtils;
import com.mcf.base.pojo.AdminUser;
import com.mcf.manage.core.auth.token.LoginToken;
import com.mcf.manage.core.exception.AccountDisableException;
import com.mcf.service.IAdminUserService;

/**
 * Title. <br>
 * Description: 配置后台自定义 Shiro Realm
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:40:14
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private IAdminUserService adminUserService;

	@Autowired
	public ShiroRealm(ApplicationContext ctx) {
		super();
		setCredentialsMatcher(new AllowAllCredentialsMatcher());
		setAuthenticationTokenClass(LoginToken.class);
	}

	/**
	 * 获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		LoginToken loginToken = (LoginToken) authcToken;
		String username = null;
		String password = null;
		if (loginToken.getPassword() != null) {
			password = SSEncryptionUtils.saltMD5Encoder(loginToken.getPassword().trim());
		}
		if (loginToken.getUsername() != null) {
			username = loginToken.getUsername().trim();
		}
		// 用户名密码登录
		AdminUser adminUser = adminUserService.getByUsername(username);
		if (adminUser == null) {
			throw new UnknownAccountException();// 帐号不存在
		}
		// 密码不正确
		if (!adminUser.getPassword().equals(password)) {
			throw new IncorrectCredentialsException();
		}
		// 账号已禁用
		if (adminUser.getEnabled().equals(EnabledType.DISABLED.getOrdinal())) {
			throw new AccountDisableException();
		}
		// 账户授权
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(adminUser, adminUser.getPassword().toCharArray(),
				getName());
		return info;
	}

	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Object object = principals.fromRealm(getName()).iterator().next();
		if (object != null) {
			info.addRole("ROLE_ADMIN");
			return info;
		}
		return null;
	}

}