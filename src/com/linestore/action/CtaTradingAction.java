package com.linestore.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.linestore.service.CtaTradingService;
import com.linestore.service.CusAccountService;
import com.linestore.vo.CtaTrading;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javassist.expr.NewArray;

public class CtaTradingAction extends ActionSupport implements ModelDriven<CtaTrading> {

	private CtaTrading ctaTrading = new CtaTrading();

	private CtaTradingService ctaTradingService;

	private CusAccountService cusAccountService;

	private Map<String, Object> request;

	private String point;

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

	public String pointToChange() {
		System.out.println(point);
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		CusAccount cac = (CusAccount) ActionContext.getContext().getSession().get("cac");
		System.out.println(cac);
		System.out.println(cac.getCacChange());
		cac.setCacChange(cac.getCacChange() + Float.valueOf(point) / 10);
		cac.setCacPoints(cac.getCacPoints() - Float.valueOf(point));
		cusAccountService.updateCusAccount(cac);
		Date date = new Date();
		CtaTrading cta = new CtaTrading();
		cta.setCtaId(getOrd(date));
		cta.setCtaMoney(Float.valueOf(point));
		cta.setCtaTime(new Timestamp(date.getTime()));
		cta.setCtaType(11);
		cta.setCustomer(cus);
		ctaTradingService.addCtaTrading(cta);
		ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
		return "update";
	}

	public String queryPoint() {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		if (cus != null) {
			List<CtaTrading> ctaTradings = ctaTradingService.queryPoint(cus.getCusId());
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("ctas", ctaTradings);
		}
		return "gotoRecord";
	}

	private String getOrd(Date date) {
		int max = 1000;
		int min = 9999;
		Random random = new Random();
		String out_trade_no = date.getTime() + "T" + random.nextInt(max) % (max - min + 1);
		return out_trade_no;
	}

	public CtaTradingService getCtaTradingService() {
		return ctaTradingService;
	}

	public void setCtaTradingService(CtaTradingService ctaTradingService) {
		this.ctaTradingService = ctaTradingService;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}

}
