package com.linestore.action;

import java.util.List;
import java.util.Map;

import com.linestore.service.BillService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Bill;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BillAction extends ActionSupport implements ModelDriven<Bill>{
	Map<String, Object> request;
	private Bill bill = new Bill();
	private BillService billService;
	private List<Bill> billList;
	ThinkUser think;
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";

	private Integer thuId;
	@Override
	public Bill getModel() {
		// TODO Auto-generated method stub
		return bill;
	}
	
	public String select(){
		
		return "selectAll";
	}
	
	public String selectAll(){
		getId();
		String hql ="select count(*) from Bill";
		int totalCount = billService.queryAll(hql);
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		
		if(think.getThuPid() == 0){
			billList =  billService.selectAll(page);
		} else {
			billList =  billService.select(page,thuId);
		}
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", billList);
		request.put("page", page);
		
		return "selectAll";
	}
	
	public Integer getId(){
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		thuId = think.getThuId();
		return thuId;
	}
	
	public void setBillService(BillService billService) {
		this.billService = billService;
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
	
	
	
}
