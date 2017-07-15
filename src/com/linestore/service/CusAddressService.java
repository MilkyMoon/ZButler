package com.linestore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.linestore.vo.CusAddressModel;

@Transactional
public interface CusAddressService {
	// 为用户增加一个地址
	void add(CusAddressModel cusAddress);

	// 获取用户全部地址
	List<CusAddressModel> selectAll(CusAddressModel cusAddress);

	// 获取用户指定地址
	CusAddressModel select(CusAddressModel cusAddress);
	// 更新用户指定地址
	void update(CusAddressModel cusAddress);
	// 更新用户指定地址
	void del(CusAddressModel cusAddress);
}
