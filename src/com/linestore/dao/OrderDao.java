package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Order;

public interface OrderDao {

	// 获取全部订单
	List<Order> selectAll(Order order);
	// 获取分类订单
	List<Order> selectType(Order order);

}
