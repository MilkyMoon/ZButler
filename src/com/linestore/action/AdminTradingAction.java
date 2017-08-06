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
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminTradingAction extends ActionSupport implements ModelDriven<BusTrading> {

	private BusTrading busTrading = new BusTrading();

	private BusTradingService busTradingService;
	private List<BusTrading> busTradingList = new ArrayList<BusTrading>();
	Map<String, Object> request;
	private BusTrading bustradingResult;
	private ThinkUser think = new ThinkUser();
	
	private Integer thuId;
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";

	@Override
	public BusTrading getModel() {
		return busTrading;
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
			totalCount = busTradingService.queryAll();
			page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
			busTradingList = busTradingService.selectAll(page);
		} else {
			totalCount = busTradingService.queryByAreaAll(think.getThuArea());
			page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
			String area = think.getThuArea();
			busTradingList = busTradingService.selectByArea(page,area);
		}
		
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
			String openid = busTrading.getBusiness().getCustomer().getCusOpenId();
			
			WxEntPayRequest wxEntPayRequest = new WxEntPayRequest();
			wxEntPayRequest.setAmount(11);
			wxEntPayRequest.setDescription(busTrading.getBtaType().toString());
			wxEntPayRequest.setOpenid(openid);
			wxEntPayRequest.setPartnerTradeNo(busTrading.getBtaId());
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
		getId();
		if(think.getThuPid() == 0){
			busTradingList = busTradingService.searchAll(keywords);
		} else {
			busTradingList = busTradingService.search(keywords,think.getThuArea());
		}
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", busTradingList);
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
	
	public Integer getId(){
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		thuId = think.getThuId();
		return thuId;
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

	public ThinkUser getThink() {
		return think;
	}

	public void setThink(ThinkUser think) {
		this.think = think;
	}

}
