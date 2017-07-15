package com.linestore.dao;

import java.util.List;

import com.linestore.vo.CusAddress;

public interface CusAddressDao {
	// 获取用户全部地址
	List<CusAddress> selectAll(CusAddress cusAddress);

	// 为用户增加一个地址
	void add(CusAddress cusAddress);

	// 获取用户指定地址
	CusAddress select(CusAddress cusAddress);

	// 修改用户指定地址
	void update(CusAddress cusAddress);

	// 删除用户指定地址
	void del(CusAddress cusAddress);
}
