package com.linestore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import com.linestore.dao.UserDao;
import com.linestore.vo.Customer;
import com.linestore.vo.Friends;
import com.linestore.vo.UserModel;

@Transactional
public interface FriendsService {
	// 新增朋友
	void save(Friends friends);

	// 获取用户全部朋友资料
	List<Friends> selectAll(Customer customer);

	// 获取用户全部朋友资料A/B/C
	List<Friends> selectType(Friends friends);

	// 获取指定朋友资料
	Friends select(Friends friends);
	
	public Friends queryByPhone(String phone);
	
	public List<Friends> queryType(int cusId, int type);
}
