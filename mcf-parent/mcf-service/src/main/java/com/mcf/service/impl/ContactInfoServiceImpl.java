package com.mcf.service.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mcf.base.common.dao.IBaseMapperDao;
import com.mcf.base.common.page.Pager;
import com.mcf.base.common.service.impl.BaseServiceImpl;
import com.mcf.base.common.utils.JodaUtils;
import com.mcf.base.common.utils.RandomUtils;
import com.mcf.base.common.utils.ShowConvertUtils;
import com.mcf.base.dao.IContactInfoDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.ContactInfo;
import com.mcf.service.IContactInfoService;

/**
 * Title. <br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月15日 上午12:33:04
 * <p>
 * Company: 成都媒超风信息技术有限公司
 * <p>
 * Author: 10003/sunaiqiang saq691@126.com
 * <p>
 * Version: 1.0
 * <p>
 */
@Service("contactInfoService")
public class ContactInfoServiceImpl extends BaseServiceImpl<ContactInfo>
		implements IContactInfoService {

	private static Logger logger = LoggerFactory.getLogger(ContactInfoServiceImpl.class);

	@Resource
	private IContactInfoDao contactInfoDao;

	@Resource(name = "contactInfoDao")
	@Override
	public void setBaseMapperDao(IBaseMapperDao<ContactInfo> baseMapperDao) {
		super.setBaseMapperDao(baseMapperDao);
	}

	@Override
	public boolean updateIsContact(String id, Byte isContact) {
		boolean flag = false;
		try {
			if (StringUtils.isNotBlank(id)) {
				ContactInfo contactInfo = contactInfoDao.getById(id);
				if (contactInfo != null) {
					contactInfo.setIsContact(ShowConvertUtils.isContact(isContact));
					contactInfo.setVisitTime(JodaUtils.getNowDate());
					flag = contactInfoDao.update(contactInfo);
				}
			}
		} catch (Exception e) {
			logger.error("修改是否已经联系客户--->{}");
			flag = false;
		}
		return flag;
	}

	@Override
	public Map<String, Object> getContactInfoList(Map<String, Object> parameter,
			Pager pager) throws BaseException {
		Map<String, Object> listMap = null;
		try {
			listMap = this.getListData("getContactInfoList", parameter, pager);
		} catch (BaseException e) {
			logger.error("获取联系信息列表失败--->{}");
			throw e;
		}
		return listMap;
	}

	@Override
	public boolean updateRemark(String id, String remark) {
		boolean flag = false;
		try {
			if (StringUtils.isNotBlank(id)) {
				ContactInfo updateObj = contactInfoDao.getById(id);
				if (updateObj != null) {
					updateObj.setRemark(remark);
					flag = contactInfoDao.update(updateObj);
				}
			}
		} catch (Exception e) {
			logger.error("添加备注信息失败--->{}");
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean addContactInfo(ContactInfo contactInfo) {
		boolean status = false;
		Date nowTime = JodaUtils.getNowDate();

		// 发送联系信息
		contactInfo.setId(RandomUtils.getGenerateId());
		contactInfo.setCreateTime(nowTime);

		// 将entity对象值复制给target对象
		ContactInfo target = new ContactInfo();
		BeanUtils.copyProperties(contactInfo, target);

		// 执行保存
		status = contactInfoDao.add(target);
		return status;
	}

}
