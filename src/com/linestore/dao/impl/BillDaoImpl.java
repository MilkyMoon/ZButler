package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.BillDao;
import com.linestore.util.Page;
import com.linestore.vo.Bill;

public class BillDaoImpl extends HibernateDaoSupport implements BillDao{

	@Override
	public List<Bill> select(Page page, Integer id) {
		// TODO Auto-generated method stub
		String hql = "from Bill where thinkUserByThuPropertyId.thuId = ? or thinkUserByThuCityId.thuId = ? or thinkUserByThuProvinceId.thuId = ?";
		List<Bill> list = (List<Bill>) this.getHibernateTemplate().find(hql, id, id, id);
		return list;
	}

	@Override
	public List<Bill> selectAll(Page page) {
		// TODO Auto-generated method stub
//		String hql = "from Bill";
//		List<Bill> list = (List<Bill>) this.getHibernateTemplate().find(hql);
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from Bill");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public List<Bill> search(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryAll(String hql) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

}
