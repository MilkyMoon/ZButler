package com.linestore.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.RuleGroupDao;
import com.linestore.vo.RuleGroup;

public class RuleGroupDaoImpl extends HibernateDaoSupport implements RuleGroupDao {

	@Override
	public void AddRuleGroup(RuleGroup rg) {
		System.out.println("exec AddRuleGroup");
		try {
			this.getHibernateTemplate().save(rg);
			System.out.println("AddRuleGroup successful!");
		} catch (RuntimeException e) {
			System.out.println("AddRuleGroup failed!");
			throw e;
		}
		
	}

}
