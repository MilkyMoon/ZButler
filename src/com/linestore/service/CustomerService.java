package com.linestore.service;

import java.util.List;

import com.linestore.vo.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void delCustomer(int cusId);

	public Customer findById(int cusId);
	
	public List<Customer> findByOpenId(String openId);

	public List<Customer> findByPhone(String phone);

	public List<Customer> queryAll(final int offset, final int length);

	public boolean checkCustomer(Customer customer);

	public void updateField(String field, String value, int id);

	// 获取一个指定用户
	Customer select(Customer customer);
}
