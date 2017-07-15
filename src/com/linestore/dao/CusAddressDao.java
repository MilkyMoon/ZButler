package com.linestore.dao;

import java.util.List;

import com.linestore.vo.CusAddressModel;

public interface CusAddressDao {
	// 获取用户全部地址
	List<CusAddressModel> selectAll(CusAddressModel cusAddress);

	// 为用户增加一个地址
	void add(CusAddressModel cusAddress);

	// 获取用户指定地址
	CusAddressModel select(CusAddressModel cusAddress);

	// 修改用户指定地址
	void update(CusAddressModel cusAddress);

	// 删除用户指定地址
	void del(CusAddressModel cusAddress);
}
