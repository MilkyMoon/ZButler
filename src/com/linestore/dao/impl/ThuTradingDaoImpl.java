package com.linestore.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.ThuTradingDao;
import com.linestore.util.Page;
import com.linestore.vo.ThinkUser;
import com.linestore.vo.ThuTrading;

public class ThuTradingDaoImpl extends HibernateDaoSupport implements ThuTradingDao {

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThuTrading";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

	@Override
	public List<ThuTrading> select(Page page) {
		// TODO Auto-generated method stub
		String hql = "from ThuTrading order by thtTime desc";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public void save(ThuTrading thuTrading) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(thuTrading);
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
	public int selectByKeyCount(Integer[] thuList,Integer[] areList) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThuTrading where thuId in (:thuList) or areId in (areList)";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setParameterList("thuList", Arrays.asList(thuList));
		query.setParameterList("areList", Arrays.asList(areList));
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

	@Override
	public List<ThuTrading> selectByKey(Page page, Integer[] thuList,Integer[] areList) {
		// TODO Auto-generated method stub
		String hql = "from ThuTrading where thuId in (:thuList) or areId in (areList) order by thtTime desc";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setParameterList("thuList", Arrays.asList(thuList));
		query.setParameterList("areList", Arrays.asList(areList));
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public ThuTrading selectById(String id) {
		// TODO Auto-generated method stub
		List<ThuTrading> thus = (List<ThuTrading>) this.getHibernateTemplate().find("from ThuTrading where thtId=?", id);
		if (thus.size() > 0) {
			return thus.get(0);
		}
		return null;
	}

	@Override
	public void update(ThuTrading thuTrading) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(thuTrading);
	}

	@Override
	public ThuTrading selectByAreaId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ThuTrading> selectByKeytoThu(Page page, Integer[] thuList) {
		// TODO Auto-generated method stub
		String hql = "from ThuTrading where thuId in (:thuList) order by thtTime desc";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setParameterList("thuList", Arrays.asList(thuList));
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public List<ThuTrading> selectByKeytoAre(Page page, Integer[] areList) {
		// TODO Auto-generated method stub
		String hql = "from ThuTrading where areId in (areList) order by thtTime desc";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setParameterList("areList", Arrays.asList(areList));
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public int selectByKeyCountToThu(Integer[] thuList) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThuTrading where thuId in (:thuList)";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setParameterList("thuList", Arrays.asList(thuList));
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

	@Override
	public int selectByKeyCountToAre(Integer[] areList) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThuTrading where areId in (areList) order by thtTime desc";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setParameterList("areList", Arrays.asList(areList));
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

}
