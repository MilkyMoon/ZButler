package com.linestore.service;

import java.util.List;

import com.linestore.vo.Business;

public interface BusinessService {
	void add(Business business);
	void update(String hql);
	List<Business> selectAll();
	List<Business> selectStatus(int status);
	List<Business> selectStatusTwo(int status,int statustwo);
	List<Business> select(Business business);
	List<Business> selectByArea(Business business);
	List<Business> selectByAreaStatus(Business business,int status);
	List<Business> selectByAreaStatusTwo(Business business,int status, int statustwo);
	void delete(Business business);

	List<Business> select(String sql);

	public Business select(int busId);
	
	public List<Business> queryByCity(String city, int count);
	
	public List<Business> queryByCate(int cate, String city);
	
	public List<Business> queryByShopName(String seach, String city);
	
	public List<Business> querySmall(String city, int small);
	
	public List<Business> queryCate(String city, int small);
	
	public Business CreateTd(Business business);
	
	public List<Business> queryByCusId(int cusId);
	
	public void update(Business business);

}
