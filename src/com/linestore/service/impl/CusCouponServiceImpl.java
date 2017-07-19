package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CusCouponDao;
import com.linestore.service.CusCouponService;
import com.linestore.util.Page;
import com.linestore.vo.CusCoupon;

@Transactional
public class CusCouponServiceImpl implements CusCouponService {
	
	public CusCouponDao getCusCouponDao() {
		return cusCouponDao;
	}

	public void setCusCouponDao(CusCouponDao cusCouponDao) {
		this.cusCouponDao = cusCouponDao;
	}

	private CusCouponDao cusCouponDao;

	

	@Override
	public int allLength() {
		return cusCouponDao.queryAll().size();
	}

	@Override
	public List<CusCoupon> queryAll() {
		return cusCouponDao.queryAll();
	}

	@Override
	public List<CusCoupon> queryByPage(Page page) {
		return cusCouponDao.queryByPage(page);
	}

	@Override
	public void addCusCoupon(CusCoupon cusCoupon) {
		cusCouponDao.addCusCoupon(cusCoupon);
	}

}
