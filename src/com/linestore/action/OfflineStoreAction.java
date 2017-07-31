package com.linestore.action;

import java.util.List;

import com.linestore.service.BusinessService;
import com.linestore.vo.Business;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OfflineStoreAction extends ActionSupport implements ModelDriven<Business> {
	
	private Business business;
	
	private BusinessService businessService;

	@Override
	public Business getModel() {
		return business;
	}
	
	
	public String selectAll() {
		
		List<Business> buss = businessService.selectAll(business);
		return "gotoOfflineStore";
	}
	
}
