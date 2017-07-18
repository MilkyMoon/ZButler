package com.linestore.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import com.linestore.dao.UserDao;
import com.linestore.vo.Customer;
import com.linestore.vo.UserModel;

@Transactional
public interface CustomerService {

	void save(Customer customer,HttpServletRequest request);

	
}
