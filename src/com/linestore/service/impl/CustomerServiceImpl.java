package com.linestore.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CustomerDao;
import com.linestore.service.CustomerService;
import com.linestore.util.QrCodeUtil;
import com.linestore.util.QrExistsUtil;
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
	
	public void save(Customer customer, HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 存储user并获取id
		System.out.println("Service中的save方法！");
		customerDao.addCustomer(customer);
		System.out.println(customer);
		Integer cusId = customer.getCusId();
		System.out.println(cusId);
		//生成用户邀请注册链接，并构造对应二维码图片，将图片url存入数据库
		//邀请注册链接,含邀请人id参数
		String url = "http://localhost:8080/User_register?cus_id=" + cusId;
		//二维码图片存放路径
		StringBuffer sb = new StringBuffer("");
		//tomcat运行时的项目所在路径
		String realPath = request.getSession().getServletContext().getRealPath("");
		//暂时用手写的项目路径代替
		//String realPath="/Users/wutianci/GitHub/ZButler/WebRoot/";
		sb.append(realPath);
		sb.append("uploads");
		String path = sb.toString();
		//文件名
		String fileName = cusId + ".jpg";
		//执行二维码生成及保存文件
		QrCodeUtil.createQrCode(url, path, fileName);
		//图片全路径
		String imgPath = path + "/" + fileName;
		//用户邀请链接、二维码路径存放到数据表
		customer.setCusShareUrl(url);
		customer.setCusTdCode(imgPath);

	}
	
	@Override
 +	public Customer select(Customer customer) {
 +		Customer customerResult=null;
 +		// 获取数据库中用户二维码信息
 +		customer = customerDao.select(customer);
 +		// 判断二维码信息是否存在
 +		if (customer.getCusTdCode() != null && !"".equals(customer.getCusTdCode())) {
 +			boolean isQrExists = QrExistsUtil.qrExists(customer.getCusTdCode());
 +			// 如果数据库二维码信息存在，判断二维码图片文件是否存在
 +			if (isQrExists == false) {
 +				customer=QrExistsUtil.qrCreate(customer);
 +				customer.setCusShareUrl(customerResult.getCusShareUrl());
 +				customer.setCusTdCode(customerResult.getCusTdCode());
 +			}
 +		} else {
 +
 +		 customerResult=QrExistsUtil.qrCreate(customer);
 +			customer.setCusShareUrl(customerResult.getCusShareUrl());
 +			customer.setCusTdCode(customerResult.getCusTdCode());
 +		}
 +	
 +		return customer;
 +	}
}
