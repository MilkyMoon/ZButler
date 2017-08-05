package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.BusMemberDao;
import com.linestore.vo.BusMember;

public class BusMemberDaoImpl extends HibernateDaoSupport implements BusMemberDao {
	

	@Override
	public List<BusMember> queryByOpenId(String openId) {
		List<BusMember> bmes = (List<BusMember>) this.getHibernateTemplate().find("from BusMember where bmeOpenId='" + openId + "'");
		return bmes;
	}

	@Override
	public void addBusMember(BusMember busMember) {
		this.getHibernateTemplate().save(busMember);
	}
	
}
