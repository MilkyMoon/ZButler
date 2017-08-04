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
	public List queryHot(String city) {
		System.out.println("exec queryHot");
		Session session =  this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select count(*) as c,business.busId from BusTrading where btaAddress like '%"+ city +"%' group by business order by c desc");
		query.setMaxResults(15);  
		return query.list();
	}

	@Override
	public void addBusTrading(BusTrading busTrading) {
		System.out.println("exec addBusTrading");
		try {
			this.getHibernateTemplate().save(busTrading);
			System.out.println("addBusTrading successful!");
		} catch (RuntimeException e) {
			System.out.println("addBusTrading failed!\n" + e);
			throw e;
		}
		
	}

	@Override
	public List<BusTrading> queryIncome(int busId) {
		System.out.println("exec queryIncome");
		try {
			List<BusTrading> busTradings = (List<BusTrading>) this.getHibernateTemplate().find("from BusTrading where business.busId=? and btaType<10 order by btaStatus, btaTime desc", busId);
			System.out.println("queryIncome successful!");
			return busTradings;
		} catch (RuntimeException e) {
			System.out.println("queryIncome failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<BusTrading> queryWithdraw(int busId) {
		System.out.println("exec queryWithdraw");
		try {
			List<BusTrading> busTradings = (List<BusTrading>) this.getHibernateTemplate().find("from BusTrading where business.busId=? and btaType > 10 order by btaStatus, btaTime desc", busId);
			System.out.println("queryWithdraw successful!");
			return busTradings;
		} catch (RuntimeException e) {
			System.out.println("queryWithdraw failed!\n" + e);
			throw e;
		}
	}

	@Override
	public BusTrading queryById(String btaId) {
		List<BusTrading> btas = (List<BusTrading>) this.getHibernateTemplate().find("from BusTrading where btaId='" + btaId + "'");
		if (btas.size() > 0) {
			return btas.get(0);
		}
		return null;
	}

}
