package com.linestore.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.LogDao;
import com.linestore.util.Page;
import com.linestore.vo.Log;

public class LogDaoImpl extends HibernateDaoSupport implements LogDao {

	@Override
	public void addLog(Log log) {
		System.out.println("exec addLog");
		try {
			this.getHibernateTemplate().save(log);
		} catch (RuntimeException e) {
			System.out.println("addLog failed!" + e);
			throw e;
		}
	}

	@Override
	public List<Log> queryByArea(int areaId, Page page) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Log where logAreaId=" + areaId + " order by logDate desc";
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

	@Override
	public int queryByAreaCount(int areaId) {
		Integer count =  (Integer) this.getHibernateTemplate().find("select count(*) from Log where logAreaId=?", areaId).listIterator().next();
		return count.intValue();
	}

	@Override
	public List<Log> queryByThu(int thuId, Page page) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Log where logThuId=" + thuId + " order by logDate desc";
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

	@Override
	public int queryByThuCount(int thuId) {
		Integer count =  (Integer) this.getHibernateTemplate().find("select count(*) from Log where logThuId=?", thuId).listIterator().next();
		return count.intValue();
	}

	@Override
	public List<Log> queryByDate(Date beginTime, Date endTime, Page page) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Log where logDate>=? and logDate<=? order by logDate desc";
		Query query = session.createQuery(hql);
		query.setDate(0, beginTime);
		query.setDate(1, endTime);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

	@Override
	public int queryByDateCount(Date beginTime, Date endTime) {
		Integer count =  (Integer) this.getHibernateTemplate().find("select count(*) from Log where logDate>=? and logDate<=?", beginTime, endTime).listIterator().next();
		return count.intValue();
	}

	@Override
	public List<Log> queryByDateAndThu(Date beginTime, Date endTime, int thuId, Page page) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Log where logDate>=? and logDate<=? and logThuId=? order by logDate desc";
		Query query = session.createQuery(hql);
		query.setDate(0, beginTime);
		query.setDate(1, endTime);
		query.setInteger(2, thuId);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

	@Override
	public int queryByDateAndThu(Date beginTime, Date endTime, int thuId) {
		Integer count =  (Integer) this.getHibernateTemplate().find("select count(*) from Log where logDate>=? and logDate<=? and logThuId=?", beginTime, endTime, thuId).listIterator().next();
		return count.intValue();
	}

	@Override
	public List<Log> queryByDateAndArea(Date beginTime, Date endTime, int areId, Page page) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Log where logDate>=? and logDate<=? and logAreaId=? order by logDate desc";
		Query query = session.createQuery(hql);
		query.setDate(0, beginTime);
		query.setDate(1, endTime);
		query.setInteger(2, areId);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

	@Override
	public int queryByDateAndArea(Date beginTime, Date endTime, int areId) {
		Integer count =  (Integer) this.getHibernateTemplate().find("select count(*) from Log where logDate>=? and logDate<=? and logAreaId=?", beginTime, endTime, areId).listIterator().next();
		return count.intValue();
	}

	@Override
	public int qureyAll() {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("select count(*) from Log");
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

	@Override
	public List<Log> selectAll() {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Log order by logDate desc";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
