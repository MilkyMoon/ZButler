package com.linestore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CustomerDao;
import com.linestore.vo.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void addCustomer(Customer customer) {
		System.out.println("exec addCustomer");
		try {
			this.getHibernateTemplate().save(customer);
			System.out.println("add successful");
		} catch (RuntimeException e) {
			System.out.println("add failed!\n" + e);
			throw e;
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("exec updateCustomer");
		try {
			this.getHibernateTemplate().update(customer);
			System.out.println("update successful");
		} catch (RuntimeException e) {
			System.out.println("update failed!\n" + e);
			throw e;
		}
	}

	@Override
	public void delCustomer(int cusId) {
		System.out.println("exec delCustomer");
		try {
			Customer customer = (Customer) this.getHibernateTemplate().load(Customer.class, cusId);
			this.getHibernateTemplate().delete(customer);
			System.out.println("delete successful");
		} catch (RuntimeException e) {
			System.out.println("delete failed!\n" + e);
			throw e;
		}
	}

	@Override
	public Customer findById(int cusId) {
		System.out.println("exec cusId");
		try {
			List<Customer> customers = (List<Customer>) this.getHibernateTemplate().find("from Customer where cusId=?", cusId);
			System.out.println("exec cusId");
			return customers.get(0);
		} catch (RuntimeException e) {
			System.out.println("find failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<Customer> findByPhone(String phone) {
		System.out.println("exec findByPhone");
		try {
			List<Customer> customers = (List<Customer>) this.getHibernateTemplate().find("from Customer where cusPhone=?", phone);
			System.out.println("find sucessful");
			return customers;
		} catch (RuntimeException e) {
			System.out.println("find failed!\n" + e);
			throw e;
		}
	}

	/**
	 * offset 第几页
	 * length 每页长度
	 */
	@Override
	public List<Customer> queryAll(final int offset, final int length) {
		System.out.println("exec queryAll");
		try {
			List<Customer> customers = (List<Customer>) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {
					Query query = session.createQuery("from Customer");
					query.setFirstResult(offset);
					query.setMaxResults(length);
					List list = query.list();
					return list;
				}
			});
			System.out.println("query successful");
			return customers;
		} catch (RuntimeException e) {
			System.out.println("query failed!\n" + e);
			throw e;
		}
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		System.out.println("exec checkCustomer");
		try {
			List<Customer> cus =  (List<Customer>) this.getHibernateTemplate().find(
					"from Customer where cusPhone=? and cusPassword=?", 
					customer.getCusPhone(), 
					customer.getCusPassword()
					);
			if (cus.size() == 1) {
				System.out.println("登录成功！");
				return true;
			} else {
				System.out.println("登录失败！");
				return false;
			}
		} catch (Exception e) {
			System.out.println("check failed!\n" + e);
			throw e;
		}
	}

	@Override
	public void updateField(String field, String value, int id) {
		// TODO Auto-generated method stub
		System.out.println("exec updateField");
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			String hql = "update Customer c set c."+field+"='"+value+"' where id="+id;
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("updateField successful!");
		} catch (Exception e) {
			System.out.println("updateField failed!\n" + e);
			throw e;
		}
	}

}
