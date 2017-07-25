package com.linestore.service.impl;

import com.linestore.dao.UserDao;
import com.linestore.service.UserService;
import com.linestore.vo.UserModel;

public class UserServiceImpl implements UserService{
		//业务层注入DAO的类
		private UserDao userDao;

		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}

		@Override
		public void save(UserModel user) {
			// TODO Auto-generated method stub
			System.out.println("Service中的save方法！");
			userDao.save(user);
		}

		@Override
		/**
		 * 业务层登录方法
		 */
		public UserModel login(UserModel user) {
			// TODO Auto-generated method stub
			
			UserModel existUser = userDao.select(user);
			return existUser;
		}

		@Override
		public UserModel selectUserGroup(UserModel user) {
			// TODO Auto-generated method stub
			return userDao.selectUserGroup(user);
		}
}
