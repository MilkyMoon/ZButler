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
import com.linestore.service.CustomerService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.BusTrading;
import com.linestore.vo.Business;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminTradingAction extends ActionSupport implements ModelDriven<BusTrading> {

	private BusTrading busTrading = new BusTrading();

	private BusTradingService busTradingService;
	private List<BusTrading> busTradingList = new ArrayList<BusTrading>();
	Map<String, Object> request;
	private BusTrading bustradingResult;
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";

	@Override
	public BusTrading getModel() {
		return busTrading;
	}

	public String selectAll(){
		int totalCount = busTradingService.queryAll();
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		busTradingList = busTradingService.selectAll(page);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", busTradingList);
		request.put("page", page);
		
		return "selectAll";
	}
	
	public String selectById(){
		
		return "selectAll";
	}
	
	public String status(){
		if(busTrading.getBtaStatus() == 2){
			update();
			return "select";
		}
		
		if(busTrading.getBtaStatus() == 1){
			bustradingResult = busTradingService.queryById(busTrading.getBtaId());
			bustradingResult.getBtaMoney();
			
			WxEntPayRequest wxEntPayRequest = new WxEntPayRequest();
			wxEntPayRequest.setAmount(11);
			wxEntPayRequest.setDescription("描述");
			wxEntPayRequest.setOpenid("openid");
			wxEntPayRequest.setPartnerTradeNo("订单号");
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("wxEntPayRequest", wxEntPayRequest);
			request.put("busTrading", busTrading);
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
		busTradingList = busTradingService.search(keywords);
		
		return "selectAll";
	}
	
	public String update(){
		try {
			String hql = ReturnUpdateHql.ReturnHql(busTrading.getClass(), busTrading, busTrading.getBtaId());
			
			busTradingService.update(hql);
			
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

	public BusTrading getBusTrading() {
		return busTrading;
	}

	public void setBusTrading(BusTrading busTrading) {
		this.busTrading = busTrading;
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

	public void setBusTradingService(BusTradingService busTradingService) {
		this.busTradingService = busTradingService;
	}
	
	

}
