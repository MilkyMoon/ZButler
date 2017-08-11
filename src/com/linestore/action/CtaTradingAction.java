package com.linestore.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.linestore.service.CtaTradingService;
import com.linestore.service.CusAccountService;
import com.linestore.service.SettingService;
import com.linestore.service.SiteConfigService;
import com.linestore.vo.Business;
import com.linestore.vo.CtaTrading;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.linestore.vo.Setting;
import com.linestore.vo.SiteConfig;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javassist.expr.NewArray;

public class CtaTradingAction extends ActionSupport implements ModelDriven<CtaTrading> {

	private CtaTrading ctaTrading = new CtaTrading();

	private CtaTradingService ctaTradingService;

	private CusAccountService cusAccountService;

	private Map<String, Object> request;

	private SettingService settingService;
	
	private SiteConfigService siteConfigService;

	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}

	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}

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
			// 积分转换比 jfzhb
			request.put("jfzhb", settingService.queryById(8).getSetValue());
		}
		return "gotoRecord";
	}

	public String pointToChange() {
		System.out.println(point);
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		CusAccount cac = (CusAccount) ActionContext.getContext().getSession().get("cac");
		System.out.println(cac);
		System.out.println(cac.getCacChange());
		cac.setCacChange(
				cac.getCacChange() + Float.valueOf(point) * Float.valueOf(settingService.queryById(8).getSetValue()));
		cac.setCacPoints(cac.getCacPoints() - Float.valueOf(point));
		cusAccountService.updateCusAccount(cac);
		Date date = new Date();
		CtaTrading cta = new CtaTrading();
		cta.setCtaId(getOrd(date));
		cta.setCtaMoney(Float.valueOf(point) * Float.valueOf(settingService.queryById(8).getSetValue()));
		cta.setCtaTime(new Timestamp(date.getTime()));
		cta.setCtaType(11);
		cta.setCtaStatus(1);
		cta.setCustomer(cus);
		ctaTradingService.addCtaTrading(cta);
		ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
		SiteConfig siteConfig = siteConfigService.selectById(3);
		ActionContext.getContext().getSession().put("sc", siteConfig);
		return "update";
	}

	public String queryPoint() {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		if (cus != null) {
			List<CtaTrading> ctaTradings = ctaTradingService.queryPoint(cus.getCusId());
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("ctas", ctaTradings);
			request.put("jfzhb", settingService.queryById(8).getSetValue());
		}
		return "gotoRecord";
	}
	
	public String add() {
		ctaTrading.setCtaTime(new Timestamp(new Date().getTime()));
		ctaTrading.setCtaType(4);
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		CusAccount cac = (CusAccount) ActionContext.getContext().getSession().get("cac");

		String btaId = new java.util.Date().getTime() + "T" + this.RandomStr();
		ctaTrading.setCtaId(btaId);
		ctaTrading.setCustomer(cus);
		ctaTrading.setCtaStatus(0);
		ctaTradingService.addCtaTrading(ctaTrading);
		Float money = cac.getCacChange() - ctaTrading.getCtaMoney();
		cac.setCacChange(money);
		cusAccountService.updateField("cacChange", String.valueOf(money), cac.getCacId());
//		bus.setBusChange(bus.getBusChange() - ctaTrading.getCtaMoney());
//		businessService.update(bus);
		ActionContext.getContext().getSession().put("cac", cac);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("js", "<script>YDUI.dialog.alert('申请成功！');</script>");
		return "smallMoney";
	}
	
	public String piontToChange() {
		return "gotoptc";
	}

	private String getOrd(Date date) {
		int max = 1000;
		int min = 9999;
		Random random = new Random();
		String out_trade_no = date.getTime() + "G" + random.nextInt(max) % (max - min + 1);
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

	public SettingService getSettingService() {
		return settingService;
	}

	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
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
