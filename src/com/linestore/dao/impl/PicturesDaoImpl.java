package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.PicturesDao;
import com.linestore.vo.Pictures;

public class PicturesDaoImpl extends HibernateDaoSupport implements PicturesDao {

	@Override
	public void addPicture(Pictures pic) {
		this.getHibernateTemplate().save(pic);
	}

	@Override
	public void updatePicture(String hql) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public void delPicture(int id) {
		Pictures pic = this.getHibernateTemplate().load(Pictures.class, id);
		this.getHibernateTemplate().delete(pic);
	}

	@Override
	public List<Pictures> queryByOtherId(int id) {
		List<Pictures> pics = (List<Pictures>) this.getHibernateTemplate().find("from Pictures where picOtherId=?", id);
		return pics;
	}

}
