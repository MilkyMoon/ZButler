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
	public List<Business> selectAll() {
		// TODO Auto-generated method stub
		List<Business> allBusiness = businessDao.selectAll();
		return allBusiness;
	}

	@Override
	public List<Business> select(Business business) {
		// TODO Auto-generated method stub
		return businessDao.select(business);
	}

	@Override
	public void delete(Business business) {
		// TODO Auto-generated method stub
		businessDao.delete(business);
	}

	@Override
	public List<Business> selectByArea(Business business) {
		// TODO Auto-generated method stub
		return businessDao.selectByArea(business);
	}

	@Override
	public List<Business> select(String sql) {
		// TODO Auto-generated method stub
		return businessDao.select(sql);
    }
    
	public Business select(int busId) {
		return businessDao.select(busId);
	}

	@Override
	public List<Business> queryByCity(String city, int count) {
		
		return businessDao.queryByCity(city, count);
	}

	@Override
	public List<Business> queryByCate(int cate, String city) {
		return businessDao.queryByCate(cate, city);
	}

	@Override
	public List<Business> queryByShopName(String seach, String city) {
		// TODO Auto-generated method stub
		return businessDao.queryByShopName(seach, city);
	}
	
}
