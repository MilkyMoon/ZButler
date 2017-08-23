package com.linestore.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.linestore.service.BusinessService;
import com.linestore.service.CusAccountService;
import com.linestore.service.TransferService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Business;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Transfer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TransferAction extends ActionSupport implements ModelDriven<Transfer>{
	private Transfer transfer = new Transfer();
	private TransferService transferService;
	private Business businessResalut;
	private BusinessService businessService;
	private List<Transfer> transferList = new ArrayList<Transfer>();
	private CusAccount cusAccountResalut;
	private CusAccountService cusAccountService;
	
	private Map<String, Object> request;
	
	public int id;
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";
	private String tranTime;
	private String startTime;
	private String endTime;
	private Float amountMin;
	private Float amountMax;
	
	@Override
	public Transfer getModel() {
		// TODO Auto-generated method stub
		return transfer;
	}
	
	public String add(){
		businessResalut = businessService.select(id);
		System.out.println(businessResalut.getBusOwnerName());
		
		cusAccountResalut = cusAccountService.findByCusId(businessResalut.getCustomer().getCusId());
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("root", businessResalut);
		request.put("cusroot", cusAccountResalut);
		
		return "add";
	}
	
	public String save(){
		transfer.setTraDate(new Timestamp(new Date().getTime()));
		transferService.save(transfer);
		
		System.out.println(transfer.getBusiness().getBusId());
		
		businessResalut = businessService.select(transfer.getBusiness().getBusId());
		
		cusAccountResalut = cusAccountService.findByCusId(businessResalut.getCustomer().getCusId());
		cusAccountResalut.setCacChange(cusAccountResalut.getCacChange()-transfer.getTraMoney());
		
		cusAccountService.updateCusAccount(cusAccountResalut);
		
		return "save";
	}
	
	public String select(){
		String[] sTime=tranTime.split(" - ");
		
		String[] sTimeLeft = sTime[0].split("/");
		String[] sTimeRigh = sTime[1].split("/");
		
		String timeMin = sTimeLeft[2] + "-" + sTimeLeft[0] + "-" + sTimeLeft[1];
		String timeMax = sTimeRigh[2] + "-" + sTimeRigh[0] + "-" + (Integer.parseInt(sTimeRigh[1])+1);
		
		System.out.println("timeMin:"+timeMin);
		System.out.println("timeMax:"+timeMax);
		System.out.println("amountMin:"+amountMin);
		System.out.println("amountMax:"+amountMax);
		System.out.println("keywords:"+keywords);
		
		int totalCount = transferService.selectByTimeCount(timeMin, timeMax, amountMin, amountMax, keywords);
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		everyPage = String.valueOf(totalCount);
		if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Float.valueOf(everyPage)))){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		
		transferList = transferService.selectByTime(page, timeMin, timeMax, amountMin, amountMax, keywords);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("list", transferList);
		request.put("page", page);	
		request.put("tranTime", tranTime);
		request.put("amountMin", amountMin);
		request.put("amountMax", amountMax);
		request.put("keywords", keywords);
		
		return "selectAll";
	}
	
	public String selectAll(){
		int totalCount = transferService.selectAllCount();
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		everyPage = String.valueOf(totalCount);
		if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Float.valueOf(everyPage)))){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		
		transferList = transferService.selectAll(page);
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("list", transferList);
		request.put("page", page);
		request.put("keywords", keywords);
		
		return "selectAll";
	}

	public TransferService getTransferService() {
		return transferService;
	}

	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
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

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}

	public Float getAmountMin() {
		return amountMin;
	}

	public void setAmountMin(Float amountMin) {
		this.amountMin = amountMin;
	}

	public Float getAmountMax() {
		return amountMax;
	}

	public void setAmountMax(Float amountMax) {
		this.amountMax = amountMax;
	}
	
	
}
