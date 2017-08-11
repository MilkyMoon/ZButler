package com.linestore.service;

import java.util.List;

import com.linestore.vo.RuleGroup;

public interface RuleGroupService {
	
	public void AddRuleGroup(RuleGroup rg);
	
	public List<RuleGroup> selectAll(int id);

}
