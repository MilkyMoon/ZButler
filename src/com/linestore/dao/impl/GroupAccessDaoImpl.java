package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.GroupAccessDao;
import com.linestore.vo.GroupAccess;

public class GroupAccessDaoImpl extends HibernateDaoSupport implements GroupAccessDao {

	@Override
	public void addGroupAccess(GroupAccess ga) {
		System.out.println("exec addGroupAccess");
		try {
			this.getHibernateTemplate().save(ga);
			System.out.println("addGroupAccess successful!");
		} catch (RuntimeException e) {
			System.out.println("addGroupAccess failed!");
			throw e;
		}
	}

	@Override
	public void delGroupAccess(int gaId) {
		System.out.println("exec delGroupAccess");
		try {
			GroupAccess ga = this.getHibernateTemplate().load(GroupAccess.class, gaId);
			this.getHibernateTemplate().delete(ga);
			System.out.println("delGroupAccess successful!");
		} catch (RuntimeException e) {
			System.out.println("delGroupAccess failed!");
			throw e;
		}
	}

	@Override
	public void updateGroupAccess(GroupAccess ga) {
		System.out.println("exec updateGroupAccess");
		try {
			this.getHibernateTemplate().update(ga);
			System.out.println("updateGroupAccess successful!");
		} catch (RuntimeException e) {
			System.out.println("updateGroupAccess failed!");
			throw e;
		}
	}

	@Override
	public GroupAccess queryById(int gaId) {
		System.out.println("exec queryById");
		try {
			List<GroupAccess> gas = (List<GroupAccess>) this.getHibernateTemplate().find("from GroupAccess where id=?", gaId);
			if (gas.size() > 0) {
				return gas.get(0);
			}
			return null;
		} catch (RuntimeException e) {
			System.out.println("queryById failed!");
			throw e;
		}
	}

	@Override
	public List<GroupAccess> queryAll() {
		System.out.println("exec queryAll");
		try {
			List<GroupAccess> gas = (List<GroupAccess>) this.getHibernateTemplate().find("from GroupAccess");
			
			return gas;
		} catch (RuntimeException e) {
			System.out.println("queryAll failed!");
			throw e;
		}
	}

}
