package com.mcf.base.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcf.base.common.dao.impl.BaseMapperDaoImpl;
import com.mcf.base.dao.IAddressDao;
import com.mcf.base.exception.BaseException;
import com.mcf.base.mapper.AddressMapper;
import com.mcf.base.pojo.Address;

@Repository("addressDao")
public class AddressDaoImpl extends BaseMapperDaoImpl<Address> implements IAddressDao {
	private Logger logger = LoggerFactory.getLogger(AddressDaoImpl.class);

	@Autowired
	private AddressMapper addressMapper;

	@PostConstruct
	public void init() {
		super.setMapperClass(AddressMapper.class);
	}

	@Override
	public List<Address> getAutoCompleData(String name) {
		return addressMapper.getAutoCompleData(name);
	}

	@Override
	public Address findCityByName(String name) throws BaseException {
		Address address = null;
		try {
			address = addressMapper.findCityByName(name);
		} catch (BaseException e) {
			address = null;
			logger.error("根据名称查找城市信息失败--->{}");
		}
		return address;
	}

}
