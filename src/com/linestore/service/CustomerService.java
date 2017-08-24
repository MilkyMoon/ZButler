package com.linestore.service;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void delCustomer(int cusId);

	public Customer findById(int cusId);
	
	public List<Customer> findByOpenId(String openId);

	public List<Customer> findByPhone(String phone);

	public int queryAll();

	public boolean checkCustomer(Customer customer);

	public void updateField(String field, String value, int id);
	
	public List<Customer> queryAll(Page page);

	// 获取一个指定用户
	Customer select(Customer customer);
	
	void update(String hql);
	
	public List<Customer> search(String keywords);
	
	public void addByOpenId(Customer cus);
}
