package com.linestore.dao;

import com.linestore.vo.Customer;

public interface CustomerDao {
	// 新增用户
	void save(Customer customer);

	// 获取指定用户资料
	Customer select(Customer customer);
}
