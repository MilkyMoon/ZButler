package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linestore.service.CusAccountService;
import com.linestore.service.CustomerService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.util.ReturnUpdateHql;
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
	private CusAccountService cusAccountService;
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String select(){
		if(keywords.equals("") || keywords == null){
			return "select";
		}
		
		search();
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", customerList);
		
		return "selectAll";
	}
	
	public String search(){
		customerList = customerService.search(keywords);
		return "selectAll";
	}
	
	public String read(){
		
		
		return "read";
	}
	
	public String selectAll(){
		int totalCount = customerService.queryAll();
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
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
	
	public String update(){
		int id = customer.getCusId();
//		business.setBusId(null);
		
		String hql;
		try {
			hql = ReturnUpdateHql.ReturnHql(customer.getClass(), customer, id);
//			System.out.println(business.getBusStatus());
			customerService.update(hql);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "select";
	}
	
	public String delete(){
		customerService.delCustomer(customer.getCusId());
		
		return "select";
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
	
	public String getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(String everyPage) {
		this.everyPage = everyPage;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}
	
}
