package com.linestore.action;

import java.util.Map;

import com.linestore.service.BusTradingService;
import com.linestore.vo.BusTrading;
import com.linestore.vo.Business;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BusTradingAction extends ActionSupport implements ModelDriven<BusTrading> {
	
	private BusTrading busTading = new BusTrading();
	
	private BusTradingService busTradingService;
	
	Map<String, Object> request;

	@Override
	public BusTrading getModel() {
		return busTading;
	}
	
	public String queryIncome() {
		Business bus = (Business) ActionContext.getContext().getSession().get("store");
		busTradingService.queryWithdraw(bus.getBusId());
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("Income", busTradingService.queryIncome(bus.getBusId()));
		return "gotoIncom";
	}
	
	public String queryWithdraw() {
		Business bus = (Business) ActionContext.getContext().getSession().get("store");
		busTradingService.queryWithdraw(bus.getBusId());
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("Withdraw", busTradingService.queryWithdraw(bus.getBusId()));
		return "gotoWithdraw";
	}

	public BusTradingService getBusTradingService() {
		return busTradingService;
	}

	public void setBusTradingService(BusTradingService busTradingService) {
		this.busTradingService = busTradingService;
	}
	
}
