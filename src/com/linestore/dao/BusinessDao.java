package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Business;

public interface BusinessDao {
	void add(Business business);
	void update(Business business);
	List<Business> selectAll(Business business);
	Business select(Business business);
	void delete(Business business);
}
