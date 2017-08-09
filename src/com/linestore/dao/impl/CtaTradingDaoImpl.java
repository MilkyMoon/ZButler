package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CtaTradingDao;
import com.linestore.util.Page;
import com.linestore.vo.BusTrading;
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

	@Override
	public List<CtaTrading> queryPoint(int cusId) {
		System.out.println("exec queryByCusid");
		try {
			List<CtaTrading> ctaTradings = (List<CtaTrading>) this.getHibernateTemplate().find("from CtaTrading where customer.cusId=? and ctaType > 10 order by ctaTime desc", cusId);
			System.out.println("queryByCusid successful!");
			return ctaTradings;
		} catch (RuntimeException e) {
			System.out.println("query failed!\n" + e);
			throw e;
		}
	}

	@Override
	public CtaTrading queryById(String ctaId) {
		// TODO Auto-generated method stub
		List<CtaTrading> btas = (List<CtaTrading>) this.getHibernateTemplate().find("from CtaTrading where ctaId='" + ctaId + "'");
		return btas.get(0);
	}

	@Override
	public List<CtaTrading> selectAll(Page page) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from CtaTrading order by ctaTime desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}
	
	@Override
	public List<CtaTrading> selectAllType(Page page,int type) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from CtaTrading where ctaType = "+type+" order by ctaTime desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public int queryAll() {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("select count(*) from CtaTrading");
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		session.clear();
        System.out.println(count);
		
		System.out.println("query successful");
		return count;
	}
	
	@Override
	public int queryAllType(int type) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("select count(*) from CtaTrading where ctaType = "+type);
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		session.clear();
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
	public List<CtaTrading> search(String keywords,int type) {
		// TODO Auto-generated method stub
		String hql = "from CtaTrading where ctaType = "+type+" and (customer.cusNickname like '%"+keywords+"%' or customer.cusPhone like '%"+keywords+"%') order by ctaTime desc";
		List<CtaTrading> list = (List<CtaTrading>) this.getHibernateTemplate().find(hql);
		return list;
	}

}
