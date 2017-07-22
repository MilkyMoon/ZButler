package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Customer;
import com.linestore.vo.Friends;

public interface FriendsDao {
	// 新增朋友
	void save(Friends friends);

	// 获取用户全部朋友资料
	List<Friends> selectAll(Customer customer);

	// 获取用户全部朋友资料A/B/C
	List<Friends> selectType(Friends friends);

	// 获取指定朋友资料
	Friends select(Friends friends);

}
