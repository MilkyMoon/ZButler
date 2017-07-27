package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CatetoryDao;
import com.linestore.vo.Catetory;

public class CatetoryDaoImpl extends HibernateDaoSupport implements CatetoryDao {

	@Override
	public void addCatetory(Catetory catetory) {
		System.out.println("exec addCatetory");
		try {
			this.getHibernateTemplate().save(catetory);
			System.out.println("addCatetory successful");
		} catch (RuntimeException e) {
			System.out.println("add failed!\n" + e);
			throw e;
		}
	}

	@Override
	public void delCatetory(Catetory catetory) {
		System.out.println("exec delCatetory");
		try {
			this.getHibernateTemplate().delete(catetory);
			System.out.println("del successful!");
		} catch (RuntimeException e) {
			System.out.println("del failed!\n" + e);
			throw e;
		}
	}

	@Override
	public void updateCatetoey(Catetory catetory) {
		System.out.println("exec updateCatetoey");
		try {
			this.getHibernateTemplate().update(catetory);
			System.out.println("update successful!");
		} catch (RuntimeException e) {
			System.out.println("update failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<Catetory> queryByPid(int pid) {
		System.out.println("exec queryAllByPid");
		try {
			List<Catetory> catetories = (List<Catetory>) this.getHibernateTemplate().find("from Catetory where catePid=?", pid);
			System.out.println("queryAllByPid successful!");
			return catetories;
		} catch (RuntimeException e) {
			System.out.println("queryAllByPid failed!");
			throw e;
		}
		
	}

	@Override
	public List<Catetory> queryAll() {
		System.out.println("exec queryAll");
		try {
			List<Catetory> catetories = (List<Catetory>) this.getHibernateTemplate().find("from Catetory");
			System.out.println("queryAll successful!");
			return catetories;
		} catch (RuntimeException e) {
			System.out.println("queryAll failed!\n" + e);
			throw e;
		}
	}


}
