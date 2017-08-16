package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.TagDao;
import com.linestore.vo.Tag;

public class TagDaoImpl extends HibernateDaoSupport implements TagDao {

	@Override
	public List<Tag> queryAll() {
		System.out.println("exec queryAll");
		try {
			List<Tag> tags = (List<Tag>) this.getHibernateTemplate().find("from Tag");
			System.out.println("query successful!");
			return tags;
		} catch (RuntimeException e) {
			System.out.println("query failed!\n" + e);
			throw e;
		}
	}

	@Override
	public void save(Tag tag) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(tag);
	}

	@Override
	public void update(Tag tag) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(tag);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = "delete from Tag where tagId = ?";
		Tag tag = this.getHibernateTemplate().load(Tag.class, id);
		this.getHibernateTemplate().delete(tag);
	}

	@Override
	public Tag selectById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Tag where tagId = ?";
		List<Tag> tag= (List<Tag>) this.getHibernateTemplate().find(hql, id);
		return tag.get(0);
	}

}
