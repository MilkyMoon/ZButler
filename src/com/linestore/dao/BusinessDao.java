package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Business;

public interface BusinessDao {
	void add(Business business);
	void update(String hql);
	List<Business> selectAll();
	List<Business> select(Business business);
	List<Business> selectByArea(Business business);
	void delete(Business business);
	List<Business> select(String sql);
}
