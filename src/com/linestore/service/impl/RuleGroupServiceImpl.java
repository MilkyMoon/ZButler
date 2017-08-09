package com.linestore.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.RuleGroupDao;
import com.linestore.service.RuleGroupService;
import com.linestore.vo.RuleGroup;

@Transactional
public class RuleGroupServiceImpl implements RuleGroupService {
	
	private RuleGroupDao ruleGroupDao;

	
	@Override
	public void AddRuleGroup(RuleGroup rg) {
		ruleGroupDao.AddRuleGroup(rg);
	}
	
	public RuleGroupDao getRuleGroupDao() {
		return ruleGroupDao;
	}

	public void setRuleGroupDao(RuleGroupDao ruleGroupDao) {
		this.ruleGroupDao = ruleGroupDao;
	}


}
