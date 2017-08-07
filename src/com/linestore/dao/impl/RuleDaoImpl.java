package com.linestore.dao.impl;

import com.linestore.dao.RuleDao;
import com.linestore.dao.UserDao;
import com.linestore.vo.Rule;
import com.linestore.vo.UserModel;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 用户管理的实现类
 * 
 * @author PengZong
 *
 */
public class RuleDaoImpl extends HibernateDaoSupport implements RuleDao {

	@Override
	public Rule select(Rule rule) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from Rule where rules = ? ";
		System.out.println(rule.getRules());
		List<Rule> list = (List<Rule>) this.getHibernateTemplate().find(hql, rule.getRules());
		if (list.size() > 0) {
			return list.get(0);
		}
	
		return null;
	}
	
}
