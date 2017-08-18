package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.TransferDao;
import com.linestore.util.Page;
import com.linestore.vo.Transfer;

public class TransferDaoImpl extends HibernateDaoSupport implements TransferDao {

	@Override
	public void save(Transfer transfer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(transfer);
	}

	@Override
	public int selectAllCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Transfer";
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		session.clear();
		
		return count;
	}

	@Override
	public List<Transfer> selectAll(Page page) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from Transfer order by traDate desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public Transfer selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByTimeCount(String timeMin, String timeMax, Float amountMin, Float amountMax, String keywords) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Transfer where (business.busShopName like '"+keywords+"' or business.busOwnerName like '"+keywords+"') and traDate >= '"+timeMin+"' and traDate <= '"+timeMax+"' and traMoney >= "+amountMin+" and traMoney <= "+amountMax;
		System.out.println(hql);
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		System.out.println(query.list().size());
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

	@Override
	public List<Transfer> selectByTime(Page page, String timeMin, String timeMax, Float amountMin, Float amountMax, String keywords) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from Transfer where (business.busShopName like '"+keywords+"' or business.busOwnerName like '"+keywords+"') and traDate >= '"+timeMin+"' and traDate <= '"+timeMax+"' and traMoney >= "+amountMin+" and traMoney <= "+amountMax+" order by traDate desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());

		return query.list();
	}

}
