package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.EvaluateDao;
import com.linestore.util.Page;
import com.linestore.vo.Customer;
import com.linestore.vo.Evaluate;
import com.linestore.vo.Message;

public class EvaluateDaoImpl extends HibernateDaoSupport implements EvaluateDao {

	@Override
	public void addEvaluate(Evaluate evaluate) {
		System.out.println("exec addEvaluate");
		try {
			this.getHibernateTemplate().save(evaluate);
			System.out.println("add successful");
		} catch (RuntimeException e) {
			System.out.println("add failed!\n" + e);
			throw e;
		}
		
	}

	@Override
	public void delEvaluate(int evaId) {
		System.out.println("exec delEvaluate");
		try {
			Evaluate evaluate  =  (Evaluate) this.getHibernateTemplate().load(Evaluate.class, evaId);
			this.getHibernateTemplate().delete(evaluate);
			System.out.println("delete successful");
		} catch (RuntimeException e) {
			System.out.println("delete failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<Evaluate> queryAll() {
		System.out.println("exec queryAll");
		try {
			List<Evaluate> evaluates = (List<Evaluate>) this.getHibernateTemplate().find("from Evaluate");
			System.out.println("queryAll successful!");
			return evaluates;
		} catch (RuntimeException e) {
			System.out.println("queryAll failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<Evaluate> queryAll(Page page) {
		System.out.println("exec queryByPage");
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from Evaluate");
			query.setMaxResults(page.getEveryPage());
			query.setFirstResult(page.getBeginIndex());
			List<Evaluate> evaluates = query.list();
			System.out.println("queryByPage successful!");
			return evaluates;
		} catch (RuntimeException e) {
			System.out.println("queryByPage failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<Evaluate> queryAll(int cusId) {
		System.out.println("exec queryAll");
		try {
			List<Evaluate> evaluates = (List<Evaluate>) this.getHibernateTemplate().find("from Evaluate e where e.evaCusId="+cusId);
			System.out.println("queryAll successful!");
			return evaluates;
		} catch (RuntimeException e) {
			System.out.println("queryAll failed!\n" + e);
			throw e;
		}
	}

}
