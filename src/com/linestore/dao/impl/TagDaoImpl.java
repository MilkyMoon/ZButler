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

}
