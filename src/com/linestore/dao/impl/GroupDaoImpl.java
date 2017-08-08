package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.GroupDao;
import com.linestore.vo.Group;

public class GroupDaoImpl extends HibernateDaoSupport implements GroupDao {

	@Override
	public void addGroup(Group group) {
		System.out.println("exec addGroup");
		try {
			this.getHibernateTemplate().save(group);
			System.out.println("addGroup successful!");
		} catch (RuntimeException e) {
			System.out.println("addGroup failed!");
			throw e;
		}
	}

	@Override
	public void delGroup(int groId) {
		System.out.println("exec DelGroup");
		try {
			Group group = this.getHibernateTemplate().load(Group.class, groId);
			this.getHibernateTemplate().save(group);
			System.out.println("DelGroup successful!");
		} catch (RuntimeException e) {
			System.out.println("DelGroup failed!");
			throw e;
		}
	}

	@Override
	public void updateGroup(Group group) {
		System.out.println("exec updateGroup");
		try {
			this.getHibernateTemplate().update(group);
			System.out.println("updateGroup successful!");
		} catch (RuntimeException e) {
			System.out.println("updateGroup failed!");
			throw e;
		}
	}

	@Override
	public List<Group> queryAll() {
		System.out.println("exec queryAll");
		try {
			List<Group> gros = (List<Group>) this.getHibernateTemplate().find("from Group");
			System.out.println("queryAll successful!");
			return gros;
		} catch (RuntimeException e) {
			System.out.println("queryAll failed!");
			throw e;
		}
	}

}
