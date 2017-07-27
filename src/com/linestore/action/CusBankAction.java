package com.linestore.action;

import java.util.List;
import java.util.Map;

import com.linestore.service.CusBankService;
import com.linestore.vo.CusBank;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CusBankAction extends ActionSupport implements ModelDriven<CusBank> {

	private CusBank cusBank = new CusBank();
	
	private CusBankService cusBankService;
	
	@Override
	public CusBank getModel() {
		return cusBank;
	}
	
	public String queryAll() {
		
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		List<CusBank> cusBanks = cusBankService.queryByCusId(cus.getCusId());
		ActionContext.getContext().getSession().put("cusBanks", cusBanks);
		return "gotoBindCardOne";
	}
	
	public String add() {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		cusBank.setCustomer(cus);
		cusBankService.addCusBank(cusBank);
		return queryAll();
	}
	
	public void del() {
		cusBankService.delCusBank(cusBank);
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		List<CusBank> cusBanks = cusBankService.queryByCusId(cus.getCusId());
		ActionContext.getContext().getSession().put("cusBanks", cusBanks);
	}

	public CusBankService getCusBankService() {
		return cusBankService;
	}

	public void setCusBankService(CusBankService cusBankService) {
		this.cusBankService = cusBankService;
	}
	

}
