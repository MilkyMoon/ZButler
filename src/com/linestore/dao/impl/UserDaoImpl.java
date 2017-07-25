package com.linestore.dao.impl;

import com.linestore.dao.UserDao;
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
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	public void save(UserModel user) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法！");
		// 执行插入方法
		this.getHibernateTemplate().save(user);
	}

	@Override
	public UserModel select(UserModel user) {
		// TODO Auto-generated method stub
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from UserModel where username = ? and password = ?";
		List<UserModel> list = (List<UserModel>) this.getHibernateTemplate().find(hql, user.getUsername(),
				user.getPassword());

		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public UserModel selectUserGroup(UserModel user) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "select u.id,u.username,u.password,g.title,g.status,g.rules,g.createTime,g.updateTime from UserModel u,GroupAccess ga,Group g where u.id=? and u.id = ga.uid and ga.groupid = g.id";
		List list = (List) this.getHibernateTemplate().find(hql, user.getId());
				UserModel userResult=new UserModel();
		if(list.size()>0){
			Object[] tuple = (Object[]) list.get(0);
			Integer id = (Integer) tuple[0];
			String username = (String) tuple[1];
			String password = (String) tuple[2];
			String title = (String) tuple[3];
			String status = (String) tuple[4];
			String rules = (String) tuple[5];
			Timestamp createTime = (Timestamp) tuple[6];
			Timestamp updateTime = (Timestamp) tuple[7];
			userResult.setId(id);
			userResult.setPassword(password);
			userResult.setRules(rules);
			userResult.setStatus(status);
			userResult.setTitle(title);
			userResult.setUpdateTime(updateTime);
			userResult.setUsername(username);
			userResult.setCreateTime(createTime);
		}
	
		return userResult;
	}
}
