package com.mcf.base.common.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * Title. <br>
 * Description: 七牛云上传图片工具类
 * <p>
 * Copyright: Copyright (c) 2016年11月17日 下午11:28:36
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Component
public class QiniuUtils {
	private Logger logger = LoggerFactory.getLogger(QiniuUtils.class);

	/**
	 * 设置好账号的ACCESS_KEY和SECRET_KEY
	 */
	private String ACCESS_KEY = "ZAFEasnv4_948ZPzXozSTe2a3-nK_2cachgxPh3C";
	private String SECRET_KEY = "HXn0n3ASyGHeJfUYL8JNQz7SqO-PDzyWHk_4lFVQ";

	/**
	 * 要上传的空间
	 */
	private String bucketname = "51bppd";

	/**
	 * 密钥配置
	 */
	private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

	/**
	 * 创建上传对象
	 */
	private UploadManager uploadManager = new UploadManager();

	/**
	 * 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	 * 
	 * @return
	 */
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	public void upload(byte[] file, String key) throws IOException {
		try {
			// 调用put方法上传
			Response res = uploadManager.put(file, key, getUpToken());
			logger.info(res.bodyString());
		} catch (QiniuException e) {
			Response r = e.response;
			logger.error(r.toString());
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 *            byte
	 * @param key
	 *            文件名
	 * @throws Exception
	 */
	public void uploadFile(byte[] file, String key) throws Exception {
		new QiniuUtils().upload(file, key);
	}

}
