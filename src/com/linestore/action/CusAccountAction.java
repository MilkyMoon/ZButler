package com.linestore.action;

import com.linestore.service.CusAccountService;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CusAccountAction extends ActionSupport implements ModelDriven<CusAccount> {
	
	private CusAccount cusAccount = new CusAccount();
	
	private CusAccountService cusAccountService;

	@Override
	public CusAccount getModel() {
		return cusAccount;
	}
	
	public String change() {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		System.out.println(cus.getCusId());
		ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
		return "gotoChangeOne";
	}
	
	public String points() {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		System.out.println(cus.getCusId());
		ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
		return "gotoPointsOne";
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}

}
