package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.BusinessTmpDao;
import com.linestore.vo.BusinessTmp;

public class BusinessTmpDaoImpl extends HibernateDaoSupport implements BusinessTmpDao  {

	@Override
	public void addBusinessTmp(BusinessTmp businessTmp) {
		System.out.println("exec addBusinessTmp");
		try {
			this.getHibernateTemplate().save(businessTmp);
			System.out.println("addBusinessTmp successful!");
		} catch (RuntimeException e) {
			System.out.println("addBusinessTmp failed!");
			throw e;
		}
		
	}

	@Override
	public void delBusinessTmp(int busTid) {
		System.out.println("exec delBusinessTmp");
		try {
			BusinessTmp bustmp = this.getHibernateTemplate().load(BusinessTmp.class, busTid);
			this.getHibernateTemplate().delete(bustmp);
			System.out.println("delBusinessTmp suceessful!");
		} catch (RuntimeException e) {
			System.out.println("delBusinessTmp failed!");
			throw e;
		}
	}
	
	public BusinessTmp queryById(int bustId) {
		System.out.println("exec queryById");
		try {
			List<BusinessTmp> bustmp = (List<BusinessTmp>) this.getHibernateTemplate().find("from BusinessTmp where busId=?", bustId);
			if (bustmp.size() > 0) {
				return bustmp.get(0);
			}
			return null;
		} catch (RuntimeException e) {
			System.out.println("queryById failed!");
			throw e;
		}
	}

}
