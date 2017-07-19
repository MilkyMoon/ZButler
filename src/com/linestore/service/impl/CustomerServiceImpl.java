package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CustomerDao;
import com.linestore.service.CustomerService;
import com.linestore.vo.Customer;


@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void delCustomer(int cusId) {
		customerDao.delCustomer(cusId);
	}

	@Override
	public Customer findById(int cusId) {
		return customerDao.findById(cusId);
	}

	@Override
	public List<Customer> findByPhone(String phone) {
		return customerDao.findByPhone(phone);
	}

	@Override
	public List<Customer> queryAll(int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		return customerDao.checkCustomer(customer);
	}

	@Override
	public void updateField(String field, String value, int id) {
		customerDao.updateField(field, value, id);
	}
	
}
