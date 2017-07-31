package com.linestore.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linestore.service.CustomerService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class AdminCustomerAction extends ActionSupport implements ModelDriven<Customer> {
	Map<String, Object> request;
	private Customer customer = new Customer();
	private CustomerService customerService;
	private List<Customer> customerList = new ArrayList<Customer>();
	
	private String pageNow = "1";

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String selectAll(){
		int totalCount = customerService.queryAll();
		Page page = PageUtil.createPage(10, totalCount, Integer.parseInt(pageNow));
		System.out.println("总页数："+page.getTotalPage());
		System.out.println("当前页："+page.getCurrentPage());
		System.out.println("每页数："+page.getEveryPage());
		System.out.println("上一页："+page.isHasPrePage());
		System.out.println("下一页："+page.isHasNextPage());
		customerList = customerService.queryAll(page);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", customerList);
		request.put("page", page);
		return "selectAll";
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}
	
	
	

}
