package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CusCouponDao;
import com.linestore.util.Page;
import com.linestore.vo.CusCoupon;

public class CusCouponDaoImpl extends HibernateDaoSupport implements CusCouponDao {

	@Override
	public List<CusCoupon> queryByPage(Page page) {
		System.out.println("exec queryByPage");
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from CusCoupon");
			query.setMaxResults(page.getEveryPage());
			query.setFirstResult(page.getBeginIndex());
			List<CusCoupon> cusCoupons = query.list();
			System.out.println("queryByPage successful!");
			return cusCoupons;
		} catch (RuntimeException e) {
			System.out.println("queryByPage failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<CusCoupon> queryAll() {
		System.out.println("exec queryAll");
		try {
			List<CusCoupon> cusCoupons = (List<CusCoupon>) this.getHibernateTemplate().find("from CusCoupon");
			System.out.println("queryAll successful!");
			return cusCoupons;
		} catch (RuntimeException e) {
			System.out.println("queryAll failed!\n" + e);
			throw e;
		}
	}

	@Override
	public void addCusCoupon(CusCoupon cusCoupon) {
		System.out.println("exec addCusCoupon");
		try {
			this.getHibernateTemplate().save(cusCoupon);
			System.out.println("addCusCoupon successful");
		} catch (Exception e) {
			System.out.println("addCusCoupon failed!");
			throw e;
		}
		
	}

}
