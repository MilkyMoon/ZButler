package com.linestore.dao.impl;

import com.linestore.dao.OrderDao;
import com.linestore.vo.Customer;
import com.linestore.vo.Order;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 用户管理的实现类
 * 
 * @author AmenWu
 *
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	@Override
	public List<Order> selectAll(Order order) {
		System.out.println("DAO中的selectAll方法！");
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from Order where customer.cusId = ?";
		List<Order> list = (List<Order>) this.getHibernateTemplate().find(hql, order.getCustomer().getCusId());

		return list;
	}

	@Override
	public List<Order> selectType(Order order) {
		System.out.println("DAO中的select方法！");
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from Order where customer.cusId = ? and ordStatus=?";
		List<Order> list = (List<Order>) this.getHibernateTemplate().find(hql, order.getCustomer().getCusId(),
				order.getOrdStatus());

		return list;
	}

}
