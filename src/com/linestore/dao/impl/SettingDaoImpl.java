package com.linestore.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.SettingDao;
import com.linestore.vo.Setting;

public class SettingDaoImpl extends HibernateDaoSupport implements SettingDao {

	@Override
	public Setting queryById(int setId) {
		List<Setting> sets = (List<Setting>) this.getHibernateTemplate().find("from Setting where setId=?", setId);
		return sets.get(0);
	}
	
	public void update(String hql) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public List<Setting> queryAll() {
		List<Setting> sets = (List<Setting>) this.getHibernateTemplate().find("from Setting");
		return sets;
	}

}
