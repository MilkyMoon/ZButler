package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.SiteConfigDao;
import com.linestore.vo.SiteConfig;


public class SiteConfigDaoImpl extends HibernateDaoSupport implements SiteConfigDao {

	@Override
	public List<SiteConfig> selectByConfigName(String configName) {
		// TODO Auto-generated method stub
		String hql = "from SiteConfig where configName = ?";
		List<SiteConfig> list = (List<SiteConfig>) this.getHibernateTemplate().find(hql, configName);
		return list;
	}

	@Override
	public void delConfig(int id) {
		// TODO Auto-generated method stub
		String hql = "from SiteConfig where id = ?";
		List<SiteConfig> list = (List<SiteConfig>) this.getHibernateTemplate().find(hql, id);
		this.getHibernateTemplate().delete(list.get(0));

	}

	@Override
	
	public void updateConfig(SiteConfig sc) {
		this.getHibernateTemplate().update(sc);
	}

	@Override
	public void addConfig(SiteConfig config) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(config);
	}

}
