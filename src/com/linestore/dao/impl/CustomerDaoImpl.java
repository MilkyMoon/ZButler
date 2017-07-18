package com.linestore.dao.impl;

import com.linestore.dao.CustomerDao;
import com.linestore.dao.UserDao;
import com.linestore.vo.Customer;
import com.linestore.vo.UserModel;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 用户管理的实现类
 * @author AmenWu
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{
	public void save(Customer customer) {
		System.out.println("DAO中的save方法！");
		//执行插入方法
		this.getHibernateTemplate().save(customer);
		System.out.println("save完毕");
	}

}
