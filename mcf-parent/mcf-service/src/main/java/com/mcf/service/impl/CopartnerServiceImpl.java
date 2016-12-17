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
import com.mcf.base.common.enums.CooperateType;
import com.mcf.base.common.page.Pager;
import com.mcf.base.common.service.impl.BaseServiceImpl;
import com.mcf.base.common.utils.JodaUtils;
import com.mcf.base.common.utils.RandomUtils;
import com.mcf.base.common.utils.ShowConvertUtils;
import com.mcf.base.dao.ICopartnerDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.Copartner;
import com.mcf.service.ICopartnerService;

@Service("copartnerService")
public class CopartnerServiceImpl extends BaseServiceImpl<Copartner>
		implements ICopartnerService {
	private static Logger logger = LoggerFactory.getLogger(CopartnerServiceImpl.class);

	@Resource
	private ICopartnerDao copartnerDao;

	@Resource(name = "copartnerDao")
	@Override
	public void setBaseMapperDao(IBaseMapperDao<Copartner> baseMapperDao) {
		super.setBaseMapperDao(baseMapperDao);
	}

	@Override
	public boolean updateIsContact(String id, Byte isContact) {
		boolean flag = false;
		try {
			if (StringUtils.isNotBlank(id)) {
				Copartner copartner = copartnerDao.getById(id);
				if (copartner != null) {
					copartner.setIsContact(ShowConvertUtils.isContact(isContact));
					copartner.setVisitTime(JodaUtils.getNowDate());
					flag = copartnerDao.update(copartner);
				}
			}
		} catch (Exception e) {
			logger.error("修改是否已经联系客户--->{}");
			flag = false;
		}
		return flag;
	}

	@Override
	public Map<String, Object> getCopartnerList(Map<String, Object> parameter,
			Pager pager) throws BaseException {
		Map<String, Object> listMap = null;
		try {
			listMap = this.getListData("getCopartnerList", parameter, pager);
		} catch (BaseException e) {
			logger.error("获取合伙人信息列表失败--->{}");
			throw e;
		}
		return listMap;
	}

	@Override
	public boolean updateRemark(String id, String remark) {
		boolean flag = false;
		try {
			if (StringUtils.isNotBlank(id)) {
				Copartner updateObj = copartnerDao.getById(id);
				if (updateObj != null) {
					updateObj.setRemark(remark);
					flag = copartnerDao.update(updateObj);
				}
			}
		} catch (Exception e) {
			logger.error("添加备注信息失败--->{}");
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean addCopartner(Copartner copartner) {
		boolean status = false;
		Date nowTime = JodaUtils.getNowDate();

		// 申请合伙人
		copartner.setId(RandomUtils.getGenerateId());
		copartner.setCooperateType(
				ShowConvertUtils.cooperateType(copartner.getScooperateType()));
		copartner.setCreateTime(nowTime);

		if (CooperateType.COMPANY.getValue().equals(copartner.getScooperateType())) {
			copartner.setCompanyScale(
					ShowConvertUtils.companyScale(copartner.getScompanyScale()));
		} else {
			copartner.setMainBusiness(null);
		}
		// 将entity对象值复制给target对象
		Copartner target = new Copartner();
		BeanUtils.copyProperties(copartner, target);

		// 执行保存
		status = copartnerDao.add(target);
		return status;
	}

}
