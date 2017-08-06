package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.github.binarywang.wxpay.bean.request.WxEntPayRequest;
import com.linestore.service.BusTradingService;
import com.linestore.service.BusinessService;
import com.linestore.service.CtaTradingService;
import com.linestore.service.CustomerService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.BusTrading;
import com.linestore.vo.Business;
import com.linestore.vo.CtaTrading;
import com.linestore.vo.Customer;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminTradingAction extends ActionSupport implements ModelDriven<CtaTrading> {

	private CtaTrading ctaTrading = new CtaTrading();

	private CtaTradingService ctaTradingService;
	private List<CtaTrading> ctaTradingList = new ArrayList<CtaTrading>();
	Map<String, Object> request;
	private CtaTrading ctatradingResult;
	private ThinkUser think = new ThinkUser();
	
	private Integer thuId;
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";

	@Override
	public CtaTrading getModel() {
		return ctaTrading;
	}

	public String selectAll(){
		
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null){
			pageNow = "1";
		}
		
		getId();
		System.out.println("thuArea:"+think.getThuArea());
		System.out.println("thuId:"+think.getThuId());
		int totalCount = 0;
		Page page = null;
		if(think.getThuPid() == 0){
			totalCount = ctaTradingService.queryAll();
			page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
			ctaTradingList = ctaTradingService.selectAll(page);
		} else {
			totalCount = ctaTradingService.queryByAreaAll(think.getThuArea());
			page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
			String area = think.getThuArea();
			ctaTradingList = ctaTradingService.selectByArea(page,area);
		}
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", ctaTradingList);
		request.put("page", page);
		
		return "selectAll";
	}
	
	public String selectById(){
		
		return "selectAll";
	}
	
	public String status(){
		if(ctaTrading.getBtaStatus() == 2){
			update();
			return "select";
		}
		
		if(ctaTrading.getBtaStatus() == 1){
			ctatradingResult = ctaTradingService.queryById(ctaTrading.getBtaId());
			ctatradingResult.getBtaMoney();
			String openid = ctatradingResult.getBusiness().getCustomer().getCusOpenId();
			
			//修改状态值
			ctatradingResult.setBtaStatus(1);
			
			WxEntPayRequest wxEntPayRequest = new WxEntPayRequest();
			wxEntPayRequest.setAmount(wxEntPayRequest.yuanToFee(ctatradingResult.getBtaMoney().toString()));
			wxEntPayRequest.setDescription(ctatradingResult.getBtaType().toString());
			wxEntPayRequest.setOpenid(openid);
			wxEntPayRequest.setPartnerTradeNo(ctatradingResult.getBtaId());
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("wxEntPayRequest", wxEntPayRequest);
			request.put("busTrading", ctatradingResult);
			// 写session 
			return "gotoPostal";
			// 数据更新
			
		}		
		return "selectAll";
	}
	
	public String search(){
		if(keywords.equals("") || keywords == null){
			return "select";
		}
		getId();
		if(think.getThuPid() == 0){
			ctaTradingList = ctaTradingService.searchAll(keywords);
		} else {
			ctaTradingList = ctaTradingService.search(keywords,think.getThuArea());
		}
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", ctaTradingList);
		return "selectAll";
	}
	
	public String update(){
		try {
			String hql = ReturnUpdateHql.ReturnHql(ctaTrading.getClass(), ctaTrading, ctaTrading.getBtaId());
			
			ctaTradingService.update(hql);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "selectAll";
	}
	
	public Integer getId(){
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		thuId = think.getThuId();
		return thuId;
	}

	public BusTrading getBusTrading() {
		return ctaTrading;
	}

	public void setBusTrading(BusTrading busTrading) {
		this.ctaTrading = busTrading;
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

	public void setBusTradingService(CtaTradingService ctaTradingService) {
		this.ctaTradingService = ctaTradingService;
	}

	public ThinkUser getThink() {
		return think;
	}

	public void setThink(ThinkUser think) {
		this.think = think;
	}

}
