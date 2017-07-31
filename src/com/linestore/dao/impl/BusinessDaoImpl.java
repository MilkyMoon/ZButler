package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
	public void update(String hql) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
//		this.getHibernateTemplate().update(business);
		
	}

	@Override
	public List<Business> selectAll() {
		// TODO Auto-generated method stub
		String hql = "from Business";
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);
		
		return list;
	}
	
	public List<Business> select(String sql){
		return (List<Business>) this.getHibernateTemplate().find(sql);
	}

	@Override
	public List<Business> select(Business business) {
		// TODO Auto-generated method stub
		
		System.out.println("busid:"+business.getBusId());
		List<Business> list = (List<Business>) this.getHibernateTemplate().findByExample(business);
		System.out.println("listsize:"+list.size());
		
		return list;
	}

	@Override
	public void delete(Business business) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(business);
	}

	@Override
	public List<Business> selectByArea(Business business) {
		// TODO Auto-generated method stub
		String hql = "from Business where baProvince like '%"+business.getBaProvince()+"%' or baCity like '%"+business.getBaCity()+"%' or baCounty like '%"+business.getBaCounty()+"%'";
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);
		return list;
    }

	public Business select(int busId) {
		return (Business) this.getHibernateTemplate().find("from Business where busId=?", busId).get(0);
	}
	
	public List<Business> queryByCity(String city, int count) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Business where baCity like '%"+ city +"%'");
		if (count != 0) {
			query.setMaxResults(count);
		}
		return query.list();
	}
}
