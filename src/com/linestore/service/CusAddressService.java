package com.linestore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.linestore.vo.CusAddress;

@Transactional
public interface CusAddressService {
	// 为用户增加一个地址
	void add(CusAddress cusAddress);

	// 获取用户全部地址
	List<CusAddress> selectAll(CusAddress cusAddress);

	// 获取用户指定地址
	CusAddress select(CusAddress cusAddress);
	// 更新用户指定地址
	void update(CusAddress cusAddress);
	// 更新用户指定地址
	void del(CusAddress cusAddress);
}
