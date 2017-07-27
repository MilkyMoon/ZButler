package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CusBankDao;
import com.linestore.vo.CusBank;

public class CusBankDaoImpl extends HibernateDaoSupport implements CusBankDao {

	@Override
	public void addCusBank(CusBank cusBank) {
		System.out.println("exec addCusBank");
		try {
			this.getHibernateTemplate().save(cusBank);
			System.out.println("add successful!");
		} catch (RuntimeException e) {
			System.out.println("add failed!\n" + e);
			throw e;
		}
		
	}

	@Override
	public void delCusBank(CusBank cusBank) {
		System.out.println("exec delCusBank");
		try {
			this.getHibernateTemplate().delete(cusBank);
			System.out.println("del successful!");
		} catch (RuntimeException e) {
			System.out.println("del failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<CusBank> queryAll() {
		System.out.println("exec queryAll");
		try {
			List<CusBank> cusBanks = (List<CusBank>) this.getHibernateTemplate().find("from CusBank");
			System.out.println("queryAll successful!");
			return cusBanks;
		} catch (RuntimeException e) {
			System.out.println("query failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<CusBank> queryByCusId(int cusId) {
		System.out.println("exec queryByCusId!");
		try {
			List<CusBank> cusBanks = (List<CusBank>) this.getHibernateTemplate().find("from CusBank where customer.cusId=?", cusId);
			System.out.println("queryByCusId successful!");
			return cusBanks;
		} catch (RuntimeException e) {
			System.out.println("query failed!\n" + e);
			throw e;
		}
	}

}
