package com.linestore.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.linestore.dao.CustomerDao;
import com.linestore.service.CustomerService;
import com.linestore.util.QrCodeUtil;
import com.linestore.util.QrExistsUtil;
import com.linestore.vo.Customer;

public class CustomerServiceImpl implements CustomerService {
	// 业务层注入DAO的类
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer, HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 存储user并获取id
		System.out.println("Service中的save方法！");
		customerDao.save(customer);
		System.out.println(customer);
		Integer cusId = customer.getCusId();
		System.out.println(cusId);

	}

	@Override
	public Customer select(Customer customer) {
		Customer customerResult=null;
		// 获取数据库中用户二维码信息
		customer = customerDao.select(customer);
		// 判断二维码信息是否存在
		if (customer.getCusTdCode() != null && !"".equals(customer.getCusTdCode())) {
			boolean isQrExists = QrExistsUtil.qrExists(customer.getCusTdCode());
			// 如果数据库二维码信息存在，判断二维码图片文件是否存在
			if (isQrExists == false) {
				customer=QrExistsUtil.qrCreate(customer);
				customer.setCusShareUrl(customerResult.getCusShareUrl());
				customer.setCusTdCode(customerResult.getCusTdCode());
			}
		} else {

		 customerResult=QrExistsUtil.qrCreate(customer);
			customer.setCusShareUrl(customerResult.getCusShareUrl());
			customer.setCusTdCode(customerResult.getCusTdCode());
		}
	
		return customer;
	}

}
