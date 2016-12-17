package com.mcf.manage.web.controller.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mcf.base.common.utils.QiniuUtils;
import com.mcf.base.config.ConfigUtils;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年12月17日 下午2:42:09
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@RestController
@RequestMapping("/upload")
public class UploadController extends BaseController {
	@Autowired
	private QiniuUtils qiniuUtils;

	/**
	 * 多文件上传支持
	 * 
	 * @param upfile
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/toImage", method = RequestMethod.POST)
	public Map<String, Object> uploadFile(MultipartHttpServletRequest request)
			throws Exception {
		Map<String, Object> valMap = new HashMap<String, Object>();
		Iterator<String> iterator = request.getFileNames();
		MultipartFile multipartFile = null;

		try {
			while (iterator.hasNext()) {
				multipartFile = request.getFile(iterator.next());
				String fileName = multipartFile.getOriginalFilename();
				byte[] fileByte = multipartFile.getBytes();

				qiniuUtils.uploadFile(fileByte, fileName);
				valMap.put("error", 0);
				valMap.put("url", ConfigUtils.getProperty("qiniu.withlink") + fileName);
			}
		} catch (Exception e) {
			valMap.put("error", 500);
			valMap.put("message", "系统异常，上传失败！");
		}
		return valMap;
	}

}
