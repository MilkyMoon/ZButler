package com.linestore.service;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.CusCoupon;

public interface CusCouponService {
	
	public void addCusCoupon(CusCoupon cusCoupon);
	
	public int allLength();
	
	public List<CusCoupon> queryAll();
	
	public List<CusCoupon> queryByPage(Page page);
	
}
