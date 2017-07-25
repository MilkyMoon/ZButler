package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.OrderDao;
import com.linestore.dao.UserDao;
import com.linestore.service.OrderService;
import com.linestore.service.UserService;
import com.linestore.vo.Order;
import com.linestore.vo.UserModel;

@Transactional
public class OrderServiceImpl implements OrderService{
		//业务层注入DAO的类
		private OrderDao orderDao;

		public void setOrderDao(OrderDao orderDao) {
			this.orderDao = orderDao;
		}

		@Override
		public List<Order> selectAll(Order order) {
			return orderDao.selectAll(order);
		}

		@Override
		public List<Order> selectType(Order order) {
			return orderDao.selectType(order);
		}

		

	
}
