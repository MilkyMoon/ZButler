package com.linestore.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CtaTradingDao;
import com.linestore.vo.CtaTrading;

public class CtaTradingDaoImpl extends HibernateDaoSupport implements CtaTradingDao {

	@Override
	public void addCtaTrading(CtaTrading ctaTrading) {
	
		System.out.println("exec addCtaTrading");
		try {
			this.getHibernateTemplate().save(ctaTrading);
			System.out.println("addCtaTrading successful!");
		} catch (RuntimeException e) {
			System.out.println("add failed!\n" + e);
			throw e;
		}
	}

}
