package com.linestore.action;

import java.util.List;
import java.util.Map;

import com.linestore.service.CtaTradingService;
import com.linestore.vo.CtaTrading;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javassist.expr.NewArray;

public class CtaTradingAction extends ActionSupport implements ModelDriven<CtaTrading> {
	
	private CtaTrading ctaTrading = new CtaTrading();
	
	private CtaTradingService ctaTradingService;
	
	private Map<String, Object> request;
	

	@Override
	public CtaTrading getModel() {
		return ctaTrading;
	}
	
	public String queryByCusId() {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		if (cus != null) {
			List<CtaTrading> ctaTradings = ctaTradingService.queryByCusid(cus.getCusId());
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("ctas", ctaTradings);
		}
		return "gotoRecord";
	}

	public CtaTradingService getCtaTradingService() {
		return ctaTradingService;
	}

	public void setCtaTradingService(CtaTradingService ctaTradingService) {
		this.ctaTradingService = ctaTradingService;
	}
	
	
}
