package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BusTradingDao;
import com.linestore.vo.BusTrading;


public class BusTradingDaoImpl extends HibernateDaoSupport implements BusTradingDao {

	@Override
	public List queryHot() {
		System.out.println("exec queryHot");
		Session session =  this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select count(*) as c,business.busId from BusTrading group by business order by c desc");
		query.setMaxResults(15);  
		return query.list();
	}

}
