package com.linestore.dao.impl;

import com.linestore.dao.UserDao;
import com.linestore.vo.UserModel;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 用户管理的实现类
 * @author PengZong
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	public void save(UserModel user) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法！");
		//执行插入方法
		this.getHibernateTemplate().save(user);
	}

	@Override
	public UserModel select(UserModel user) {
		// TODO Auto-generated method stub
		//注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from UserModel where username = ? and password = ?";
		List<UserModel> list = (List<UserModel>) this.getHibernateTemplate().find(hql, user.getUsername(), user.getPassword());
		
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
