package com.linestore.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import com.linestore.dao.UserDao;
import com.linestore.vo.Customer;
import com.linestore.vo.UserModel;

@Transactional
public interface CustomerService {
	// 新增用户
	void save(Customer customer, HttpServletRequest request);

	// 获取一个指定用户
	Customer select(Customer customer);

}
