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
import com.linestore.service.CusAccountService;
import com.linestore.service.CustomerService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.BusTrading;
import com.linestore.vo.Business;
import com.linestore.vo.CtaTrading;
import com.linestore.vo.CusAccount;
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
	private CusAccount cusAccount = new CusAccount();
	private CusAccountService cusAccountService;
	private CusAccount cusAccountReslut;
	
	private Integer thuId;
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";
	private int type;

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
		
		int totalCount = 0;
		Page page = null;
		
		totalCount = ctaTradingService.queryAll();
		everyPage = String.valueOf(totalCount);
		page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		ctaTradingList = ctaTradingService.selectAll(page);
	
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", ctaTradingList);
		request.put("page", page);
		
		return "selectAll";
	}
	
	public String selectCash(){
		int totalCount = 0;
		Page page = null;
		
		totalCount = ctaTradingService.queryAllType(4);
		
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Float.valueOf(everyPage)))){
			pageNow = "1";
		}
		
		everyPage = String.valueOf(totalCount);
		page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		ctaTradingList = ctaTradingService.selectAllType(page,4);
	
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", ctaTradingList);
		request.put("page", page);
		request.put("type", 4);
		
		return "selectAll";
	}
	
	public String selectRech(){
		
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null){
			pageNow = "1";
		}
		
		int totalCount = 0;
		Page page = null;
		
		totalCount = ctaTradingService.queryAllType(1);
		everyPage = String.valueOf(totalCount);
		System.out.println("rech:"+totalCount);
		page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		ctaTradingList = ctaTradingService.selectAllType(page,1);
	
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", ctaTradingList);
		request.put("page", page);
		request.put("type", 1);
		
		return "selectAll";
	}
	
	public String selectById(){
		
		return "selectAll";
	}
	
	public String status(){
		if(ctaTrading.getCtaStatus() == 2){
			ctatradingResult = ctaTradingService.queryById(ctaTrading.getCtaId());
			cusAccountReslut = cusAccountService.findByCusId(ctatradingResult.getCustomer().getCusId());
			System.out.println("ctaMoney:"+ctatradingResult.getCtaMoney());
			System.out.println("cacMoney:"+cusAccountReslut.getCacChange());
			Float cacChange = cusAccountReslut.getCacChange() + ctatradingResult.getCtaMoney();
			cusAccountReslut.setCacChange(cacChange);
			
			System.out.println("cacChange:"+cusAccountReslut.getCacChange());
			cusAccountService.updateField("cacChange", String.valueOf(cacChange), cusAccountReslut.getCacId());
			
			update();
			return "select";
		}
		
		if(ctaTrading.getCtaStatus() == 1){
			ctatradingResult = ctaTradingService.queryById(ctaTrading.getCtaId());
			ctatradingResult.getCtaMoney();
			String openid = ctatradingResult.getCustomer().getCusOpenId();
			
			//修改状态值
			ctatradingResult.setCtaStatus(1);
			
			WxEntPayRequest wxEntPayRequest = new WxEntPayRequest();
			wxEntPayRequest.setAmount(wxEntPayRequest.yuanToFee(ctatradingResult.getCtaMoney().toString()));
			wxEntPayRequest.setDescription(ctatradingResult.getCtaType().toString());
			wxEntPayRequest.setOpenid(openid);
			wxEntPayRequest.setPartnerTradeNo(ctatradingResult.getCtaId());
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

		ctaTradingList = ctaTradingService.search(keywords,type);
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", ctaTradingList);
		return "selectAll";
	}
	
	public String update(){
		try {
			String hql = ReturnUpdateHql.ReturnHql(ctaTrading.getClass(), ctaTrading, ctaTrading.getCtaId());
			
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

	public CtaTrading getCtaTrading() {
		return ctaTrading;
	}

	public void setCtaTrading(CtaTrading ctaTrading) {
		this.ctaTrading = ctaTrading;
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

	public void setCtaTradingService(CtaTradingService ctaTradingService) {
		this.ctaTradingService = ctaTradingService;
	}

	public ThinkUser getThink() {
		return think;
	}

	public void setThink(ThinkUser think) {
		this.think = think;
	}

	public CusAccount getCusAccount() {
		return cusAccount;
	}

	public void setCusAccount(CusAccount cusAccount) {
		this.cusAccount = cusAccount;
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
