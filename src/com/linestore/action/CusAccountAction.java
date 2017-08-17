package com.linestore.action;

import com.linestore.service.CusAccountService;
import com.linestore.service.SiteConfigService;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.linestore.vo.SiteConfig;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CusAccountAction extends ActionSupport implements ModelDriven<CusAccount> {
	
	private CusAccount cusAccount = new CusAccount();
	
	private CusAccountService cusAccountService;
	
	private SiteConfigService siteConfigService;

	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}

	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}

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
		SiteConfig siteConfig = siteConfigService.selectById(3);
		ActionContext.getContext().getSession().put("jf", siteConfig);
		System.out.println(siteConfig.getConfigValue());
		ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
		return "gotoPointsOne";
	}
	
	public String delete(){
		
		return "delete";
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}

}
