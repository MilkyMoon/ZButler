package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CateLineDao;
import com.linestore.vo.CateLine;

public class CateLineDaoImpl extends HibernateDaoSupport implements CateLineDao{

	@Override
	public List<CateLine> selectAll() {
		// TODO Auto-generated method stub
		List<CateLine> catetories = (List<CateLine>) this.getHibernateTemplate().find("from CateLine");
		return catetories;
	}

	@Override
	public void save(CateLine cateLine) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(cateLine);
	}

	@Override
	public void delete(CateLine cateLine) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(cateLine);
	}

	@Override
	public void status(CateLine cateLine) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(cateLine);
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public CateLine selectById(CateLine cateLine) {
		// TODO Auto-generated method stub
		String hql = "from CateLine where calId = ?";
		List<CateLine> list = (List<CateLine>)this.getHibernateTemplate().find(hql, cateLine.getCalId());
		return list.get(0);
	}

}
