package com.linestore.dao;

import java.util.List;

import com.linestore.vo.RuleGroup;

public interface RuleGroupDao {
	
	public void AddRuleGroup(RuleGroup rg);
	
	public List<RuleGroup> selectAll(int id);

}
