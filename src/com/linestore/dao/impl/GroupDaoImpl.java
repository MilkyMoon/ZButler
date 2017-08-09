package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.GroupDao;
import com.linestore.util.Page;
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
			this.getHibernateTemplate().delete(group);
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
	public List<Group> queryAll(int id) {
		System.out.println("exec queryAll");
		try {
			List<Group> gros = (List<Group>) this.getHibernateTemplate().find("from Group where grpAdmin=?", id);
			System.out.println("queryAll successful!");
			return gros;
		} catch (RuntimeException e) {
			System.out.println("queryAll failed!");
			throw e;
		}
	}

	@Override
	public List<Group> queryAll(Page page, int id) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from Group where grpAdmin="+id);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

	@Override
	public Group queryById(int id) {
		System.out.println("exec queryById");
		try {
			List<Group> gros = (List<Group>) this.getHibernateTemplate().find("from Group where grpId=?", id);
			if (gros.size() > 0) {
				return gros.get(0);
			}
			return null;
		} catch (RuntimeException e) {
			System.out.println("queryById failed!");
			throw e;
		}
	}

	@Override
	public List<Group> queryByTitle(String title, int id) {
		System.out.println("exec queryByTitle");
		try {
			List<Group> gros = (List<Group>) this.getHibernateTemplate().find("from Group where grpTitle='"+ title + "' and grpAdmin=" + id);
			return gros;
		} catch (RuntimeException e) {
			System.out.println("queryByTitle failed!");
			throw e;
		}
	}

	@Override
	public List<Group> queryByTitle(Page page, String title, int id) {
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from Group where grpTitle='"+ title + "' and grpAdmin=" + id);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		return query.list();
	}

}
