package com.linestore.service;

import java.util.List;

import com.linestore.vo.Business;

public interface BusinessService {
	void add(Business business);
	void update(String hql);
	List<Business> selectAll(Business business);
	Business select(Business business);
	void delete(Business business);
	
	public Business select(int busId);
	
	public List<Business> queryByCity(String city, int count);
}
