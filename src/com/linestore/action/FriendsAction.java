package com.linestore.action;

import java.util.List;

import com.linestore.service.FriendsService;
import com.linestore.vo.Customer;
import com.linestore.vo.Friends;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FriendsAction extends ActionSupport implements ModelDriven<Friends> {
	// 模型驱动使用的类
	private Friends friends = new Friends();
	// 返回数据注入值栈
	private List<Friends> friendsList;
	private Customer customerResult;

	@Override
	public Friends getModel() {
		// TODO Auto-generated method stub
		return friends;
	}

	// Struts和Spring整合过程中按名称来自动注入业务层的类
	private FriendsService friendsService;

	public void setFriendsService(FriendsService friendsService) {
		this.friendsService = friendsService;
	}

	// 获取用户朋友圈
	public String selectAll() {
		System.out.println("Action selectAll");
//		Customer customer = new Customer();
//		customer.setCusId(1);
		Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
		System.out.println(customer.getCusId());
//		System.out.println(customer.getCusNickname() + " : " + customer.getCusId());
		List<Friends> friA = friendsService.queryType(customer.getCusId(), 1);
		ActionContext.getContext().getSession().put("friA", friA);
		List<Friends> friB = friendsService.queryType(customer.getCusId(), 2);
		ActionContext.getContext().getSession().put("friB", friB);
		List<Friends> friC = friendsService.queryType(customer.getCusId(), 3);
		ActionContext.getContext().getSession().put("friC", friC);
//		System.out.println(customerResult.getCusNickname() + " : " + customerResult.getCusId());
		return "selectAll";
	}

	// 获取用户朋友圈A/B/C
	public String selectType() {
		System.out.println("Action selectAll");
		friendsList = friendsService.selectType(friends);
		return "selectType";
	}

	// 返回值注入值栈
	public List<Friends> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(List<Friends> friendsList) {
		this.friendsList = friendsList;
	}

	public Customer getCustomerResult() {
		return customerResult;
	}

	public void setCustomerResult(Customer customerResult) {
		this.customerResult = customerResult;
	}

}