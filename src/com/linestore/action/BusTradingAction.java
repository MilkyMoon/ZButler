package com.linestore.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import com.linestore.service.BusTradingService;
import com.linestore.service.BusinessService;
import com.linestore.vo.BusTrading;
import com.linestore.vo.Business;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BusTradingAction extends ActionSupport implements ModelDriven<BusTrading> {
	
	private BusTrading busTrading = new BusTrading();
	
	private BusTradingService busTradingService;
	
	private BusinessService businessService;
	
	Map<String, Object> request;

	@Override
	public BusTrading getModel() {
		return busTrading;
	}
	
	public String add() {
		busTrading.setBtaTime(new Timestamp(new Date().getTime()));
		busTrading.setBtaType(11);
		Business bus = (Business) ActionContext.getContext().getSession().get("store");
		
		String btaId = new java.util.Date().getTime() + "T" + this.RandomStr();
		busTrading.setBtaId(btaId);
		busTrading.setBusiness(bus);
		busTrading.setBtaAddress(bus.getBaCity());
		busTrading.setBtaStatus(0);
		busTradingService.addBusTrading(busTrading);
		bus.setBusChange(bus.getBusChange() - busTrading.getBtaMoney());
		businessService.update(bus);
		ActionContext.getContext().getSession().put("store", bus);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("js", "<script>YDUI.dialog.alert('申请成功！');</script>");
		return "gotoSamllMoney";
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

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	private String RandomStr() {
		Random random = new Random();
		String radnString = "";
		for (int i = 0; i < 4; i++) {
			radnString += (int) (Math.random() * 10);
		}

		return radnString;
	}
	
	
}
