package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CateLineDao;
import com.linestore.vo.CateLine;

public class CateLineDaoImpl extends HibernateDaoSupport implements CateLineDao{

	@Override
	public List<CateLine> selectAll() {
		// TODO Auto-generated method stub
		List<CateLine> catetories = (List<CateLine>) this.getHibernateTemplate().find("from CateLine");
		System.out.println("queryAll successful!");
		return catetories;
	}

}
