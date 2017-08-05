package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.SettingDao;
import com.linestore.vo.Setting;

public class SettingDaoImpl extends HibernateDaoSupport implements SettingDao {

	@Override
	public Setting queryById(int setId) {
		List<Setting> sets = (List<Setting>) this.getHibernateTemplate().find("from Setting where setId=?", setId);
		return sets.get(0);
	}
	
	

}
