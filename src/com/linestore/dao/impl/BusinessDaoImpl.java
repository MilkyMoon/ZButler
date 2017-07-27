package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.linestore.dao.BusinessDao;
import com.linestore.vo.Business;

public class BusinessDaoImpl extends HibernateDaoSupport implements BusinessDao{
	@Override
	public void add(Business business){
		System.out.println("businessDao中的add方法！");
		this.getHibernateTemplate().save(business);
	}

	@Override
	public void update(Business business) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(business);
	}

	@Override
	public List<Business> selectAll(Business business) {
		// TODO Auto-generated method stub
		String hql = "from Business";
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);
		
		return list;
	}

	@Override
	public Business select(Business business) {
		// TODO Auto-generated method stub
		String hql = "from Business where busId = ?";
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql, business.getBusId());
		
		if(list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public void delete(Business business) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(business);
	}
}
