package com.linestore.dao.impl;

import java.util.List;

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

	@Override
	public List<CtaTrading> queryByCusid(int cusId) {
		System.out.println("exec queryByCusid");
		try {
			List<CtaTrading> ctaTradings = (List<CtaTrading>) this.getHibernateTemplate().find("from CtaTrading where customer.cusId=? order by ctaTime desc", cusId);
			System.out.println("queryByCusid successful!");
			return ctaTradings;
		} catch (RuntimeException e) {
			System.out.println("query failed!\n" + e);
			throw e;
		}
	}

}
