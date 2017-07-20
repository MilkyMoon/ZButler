package com.linestore.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.CustomerService;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	// 模型驱动使用的类
	private Customer customer = new Customer();
	// 返回数据注入值栈
	private Customer customerResult;

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	// Struts和Spring整合过程中按名称来自动注入业务层的类
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 新增用户
	public String add() {
		System.out.println("Action中的save方法！");
		// 通过action上下文获取request
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) cxt.get(ServletActionContext.HTTP_REQUEST);
		customerService.save(customer, request);

		return SUCCESS;
	}

	// 获取当前用户的资料
	public String select() {
		System.out.println("Action中的save方法！");
		// 通过action上下文获取session
		// 直接将session中存的用户信息通过数据库获取完整，返回页面
		// 由于登录功能尚未完成，因此先写固定值cusId=1
		// HttpSession session = ServletActionContext.getRequest().getSession();
		// Customer customerResult = (Customer)
		// session.getAttribute("customer");
		customer.setCusId(1);
		customerResult=customerService.select(customer);
		return "customerResult";
	}

	// 返回结果getter/setter
	public Customer getCustomerResult() {
		return customerResult;
	}

	public void setCustomerResult(Customer customerResult) {
		this.customerResult = customerResult;
	}

}