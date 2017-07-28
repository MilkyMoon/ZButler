package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BusinessDao;
import com.linestore.service.BusinessService;
import com.linestore.vo.Business;

@Transactional
public class BusinessServiceImpl implements BusinessService{

	private BusinessDao businessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	@Override
	public void add(Business business) {
		// TODO Auto-generated method stub
		System.out.println("BusinessService中的add方法！");
		businessDao.add(business);
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		businessDao.update(hql);
	}

	@Override
	public List<Business> selectAll(Business business) {
		// TODO Auto-generated method stub
		List<Business> allBusiness = businessDao.selectAll(business);
		return allBusiness;
	}

	@Override
	public Business select(Business business) {
		// TODO Auto-generated method stub
		return businessDao.select(business);
	}

	@Override
	public void delete(Business business) {
		// TODO Auto-generated method stub
		businessDao.delete(business);
	}
	
}
