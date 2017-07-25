package com.linestore.dao;

import com.linestore.vo.UserModel;

public interface UserDao{

	UserModel select(UserModel user);

	void save(UserModel user);
	
	UserModel selectUserGroup(UserModel user);

}
