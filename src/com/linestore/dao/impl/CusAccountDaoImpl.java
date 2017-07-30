package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CusAccountDao;
import com.linestore.vo.CusAccount;

public class CusAccountDaoImpl extends HibernateDaoSupport implements CusAccountDao {

	@Override
	public void addCusAccount(CusAccount cusAccount) {
		System.out.println("exec AddCus");
		try {
			this.getHibernateTemplate().save(cusAccount);
			System.out.println("add successful!");
		} catch (RuntimeException e) {
			System.out.println("add failed!\n" + e);
			throw e;
		}
		
	}

	@Override
	public void updateField(String field, String value, int id) {
		System.out.println("exec updateField");
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			String hql = "update CusAccount ca set ca."+field+"='"+value+"' where id="+id;
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("updateField successful!");
		} catch (RuntimeException e) {
			System.out.println("updateField failed!\n" + e);
			throw e;
		}
	}

	@Override
	public CusAccount findByCusId(int cusId) {
		System.out.println("exec findByCusId");
		try {
			List<CusAccount> customers = (List<CusAccount>) this.getHibernateTemplate().find("from CusAccount where customer.cusId=?", cusId);
			System.out.println("find sucessful");
			return customers.get(0);
		} catch (RuntimeException e) {
			System.out.println("find failed!\n" + e);
			throw e;
		}
	}

	@Override
	public void updateCusAccount(CusAccount cusAccount) {
		
		System.out.println("exec updateCusAccount");
		try {
			this.getHibernateTemplate().update(cusAccount);
			System.out.println("update successful!");
		} catch (RuntimeException e) {
			System.out.println("update failed!\n" + e);
			throw e;
		}
	}

}
