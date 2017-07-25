package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Order;
import com.linestore.vo.Rule;

public interface RuleDao {

	// 根据方法获取权限ID
	Rule select(Rule rule);

}
