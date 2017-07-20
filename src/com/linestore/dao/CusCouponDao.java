package com.linestore.dao;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.CusCoupon;

public interface CusCouponDao {
	
	public void addCusCoupon(CusCoupon cusCoupon);
	
	public List<CusCoupon> queryAll();
	
	public List<CusCoupon> queryByPage(Page page);

}
