package com.linestore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.linestore.dao.UserDao;
import com.linestore.vo.Order;
import com.linestore.vo.UserModel;

@Transactional
public interface OrderService {
	// 获取全部订单
	List<Order> selectAll(Order order);

	// 获取分类订单
	List<Order> selectType(Order order);

}
