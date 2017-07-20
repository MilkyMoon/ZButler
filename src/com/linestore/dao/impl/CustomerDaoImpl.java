package com.linestore.dao.impl;

import com.linestore.dao.CustomerDao;
import com.linestore.dao.UserDao;
import com.linestore.vo.CusAddress;
import com.linestore.vo.Customer;
import com.linestore.vo.UserModel;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 用户管理的实现类
 * 
 * @author AmenWu
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	// 新增用户
	@Override
	public void save(Customer customer) {
		System.out.println("DAO中的save方法！");
		// 执行插入方法
		this.getHibernateTemplate().save(customer);
		System.out.println("save完毕");
	}

	// 获取一个用户
	@Override
	public Customer select(Customer customer) {
		System.out.println("DAO中的select方法！");
		Customer customerResult = null;
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from Customer where cusId = ?";
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find(hql, customer.getCusId());
		if (list.size() > 0) {
			customerResult = list.get(0);
		}
		return customerResult;
	}

}
