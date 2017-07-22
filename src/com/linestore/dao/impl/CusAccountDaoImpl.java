package com.linestore.dao.impl;

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
		} catch (Exception e) {
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
		} catch (Exception e) {
			System.out.println("updateField failed!\n" + e);
			throw e;
		}
	}

}
