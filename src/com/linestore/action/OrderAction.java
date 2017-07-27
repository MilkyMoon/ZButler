package com.linestore.action;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.linestore.service.FriendsService;
import com.linestore.service.OrderService;
import com.linestore.vo.Customer;
import com.linestore.vo.Friends;
import com.linestore.vo.OrdDetails;
import com.linestore.vo.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	// 模型驱动使用的类
	private Order order = new Order();
	// 返回数据注入值栈
	private List<Order> orderList;

	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}

	// Struts和Spring整合过程中按名称来自动注入业务层的类
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// 获取用户全部订单
	public String selectAll() {
		System.out.println("Action selectAll");
//		Customer customer = new Customer();
//		customer.setCusId(1);
		Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
		order.setCustomer(customer);
		orderList = orderService.selectAll(order);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(Order order:orderList){
			order.setOrdStartTimeStr(sdf.format(order.getOrdStartTime()));
			//order.setOrdPayTimeStr(sdf.format(order.getOrdPayTimeStr()));
		}
		return "selectAll";
	}

	// 获取用户分类订单
	public String selectType() {
		System.out.println("Action selectType");
//		Customer customer = new Customer();
//		customer.setCusId(1);
		Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
		order.setCustomer(customer);
		orderList = orderService.selectType(order);
		return "selectType";
	}

	// 返回值注入值栈
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}