package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.linestore.dao.BusinessDao;
import com.linestore.vo.Business;

public class BusinessDaoImpl extends HibernateDaoSupport implements BusinessDao {
	@Override
	public void add(Business business) {
		System.out.println("businessDao中的add方法！");
		this.getHibernateTemplate().save(business);
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		// this.getHibernateTemplate().update(business);

	}

	@Override
	public List<Business> selectAll() {
		// TODO Auto-generated method stub
		String hql = "from Business where busStatus != 4";
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);

		return list;
	}
	
	@Override
	public List<Business> selectStatus(int status) {
		// TODO Auto-generated method stub
		String hql = "from Business where busStatus = "+status;
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);

		return list;
	}
	
	@Override
	public List<Business> selectStatusTwo(int status,int statustwo) {
		// TODO Auto-generated method stub
		String hql = "from Business where busStatus = "+status+" or busStatus = "+statustwo;
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);

		return list;
	}

	public List<Business> select(String sql) {
		return (List<Business>) this.getHibernateTemplate().find(sql);
	}

	@Override
	public List<Business> select(Business business) {
		// TODO Auto-generated method stub

		System.out.println("busid:" + business.getBusId());
		List<Business> list = (List<Business>) this.getHibernateTemplate().findByExample(business);
		System.out.println("listsize:" + list.size());

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
		String hql = "from Business where busStatus != 4 and (baProvince like '%" + business.getBaProvince() + "%' or baCity like '%"
				+ business.getBaCity() + "%' or baCounty like '%" + business.getBaCounty() + "%')";
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);
		return list;
	}
	
	@Override
	public List<Business> selectByAreaStatus(Business business,int status) {
		// TODO Auto-generated method stub
		String hql = "from Business where busStatus = "+status+" and (baProvince like '%" + business.getBaProvince() + "%' or baCity like '%"
				+ business.getBaCity() + "%' or baCounty like '%" + business.getBaCounty() + "%')";
		System.out.println(hql);
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);
		return list;
	}
	
	@Override
	public List<Business> selectByAreaStatusTwo(Business business,int status, int statustwo) {
		// TODO Auto-generated method stub
		String hql = "from Business where (busStatus = "+status+" or busStatus = "+statustwo+") and (baProvince like '%" + business.getBaProvince() + "%' or baCity like '%"
				+ business.getBaCity() + "%' or baCounty like '%" + business.getBaCounty() + "%')";
		System.out.println(hql);
		List<Business> list = (List<Business>) this.getHibernateTemplate().find(hql);
		return list;
	}

	public Business select(int busId) {
		List<Business> buss = (List<Business>) this.getHibernateTemplate().find("from Business where busId=?", busId);
		if (buss != null && buss.size() > 0) {
			return buss.get(0);
		} else {
			return null;
		}
	}

	public List<Business> queryByCity(String city, int count) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Business where baCity like '%" + city + "%' and busStatus=1");
		if (count != 0) {
			query.setMaxResults(count);
		}
		return query.list();
	}

	@Override
	public List<Business> queryByCate(int cate, String city) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(
				"from Business where baCity like '%" + city + "%' and cateLine.calId=" + cate + " and busStatus=1");
		return query.list();
	}

	public List<Business> queryByShopName(String seach, String city) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(
				"from Business where baCity like '%" + city + "%' and busShopName like '%" + seach + "%' and busStatus=1");
		return query.list();
	}

	public List<Business> querySmall(String city, int small) {
		List<Business> buss = (List<Business>) this.getHibernateTemplate()
				.find("from Business where busStatus != 4 and baCity like '%" + city + "%' and busSmallCate=" + small);
		return buss;
	}
	
	public List<Business> queryCate(String city, int small) {
		List<Business> buss = (List<Business>) this.getHibernateTemplate()
				.find("from Business where busStatus != 4 and baCity like '%" + city + "%' and cateLine.calId=" + small);
		return buss;
	}

	@Override
	public void update(Business business) {
		this.getHibernateTemplate().update(business);
	}

	public List<Business> queryByCusId(int cusId) {
		return (List<Business>) this.getHibernateTemplate().find("from Business where customer.cusId=?", cusId);
	}
}
