package com.linestore.service;

import org.springframework.transaction.annotation.Transactional;
import com.linestore.dao.UserDao;
import com.linestore.vo.UserModel;

@Transactional
public interface UserService {

	void save(UserModel user);

	UserModel login(UserModel user);
	
	UserModel selectUserGroup(UserModel user);
}
