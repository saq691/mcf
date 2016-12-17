package com.mcf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mcf.base.common.dao.IBaseMapperDao;
import com.mcf.base.common.service.impl.BaseServiceImpl;
import com.mcf.base.dao.IAddressDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.pojo.Address;
import com.mcf.service.IAddressService;

@Service("addressService")
public class AddressServiceImpl extends BaseServiceImpl<Address>
		implements IAddressService {
	private Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Resource
	private IAddressDao addressDao;

	@Resource(name = "addressDao")
	@Override
	public void setBaseMapperDao(IBaseMapperDao<Address> baseMapperDao) {
		super.setBaseMapperDao(baseMapperDao);
	}

	@Override
	public List<Address> getAutoCompleData(String name) {
		List<Address> list = null;
		try {
			list = addressDao.getAutoCompleData(name);
		} catch (BaseException e) {
			list = null;
			logger.error("获取自动补全列表失败--->{}", e.getMessage());
		}
		return list;
	}

	@Override
	public Address findCityByName(String name) {
		Address address = null;
		if (StringUtils.isNotBlank(name)) {
			address = addressDao.findCityByName(name);
		}
		return address;
	}

}
