package com.linestore.service.impl;

import javax.servlet.http.HttpServletRequest;


import com.linestore.dao.CustomerDao;
import com.linestore.service.CustomerService;
import com.linestore.util.QrCodeUtil;
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

}
