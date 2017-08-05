package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BusTradingDao;
import com.linestore.util.Page;
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
		return btas.get(0);
	}

	@Override
	public List<BusTrading> selectAll(Page page) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from BusTrading where btaStatus = 0");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public int queryAll() {
		// TODO Auto-generated method stub
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("select count(*) from BusTrading where btaStatus = 0");
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
        System.out.println(count);
		
		System.out.println("query successful");
		return count;
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.clear();
	}

	@Override
	public List<BusTrading> search(String keywords) {
		// TODO Auto-generated method stub
		String hql = "from BusTrading where business.busShopName like '%"+keywords+"%' or business.busOwnerName like '%"+keywords+"%' or btaAddress like '%"+keywords+"%'";
		List<BusTrading> list = (List<BusTrading>) this.getHibernateTemplate().find(hql);
		return list;
	}

}
