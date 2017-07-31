package com.linestore.action;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withUnauthorizedRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linestore.service.BusTradingService;
import com.linestore.service.BusinessService;
import com.linestore.service.CateLineService;
import com.linestore.vo.Business;
import com.linestore.vo.CateLine;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OfflineStoreAction extends ActionSupport implements ModelDriven<Business> {
	
	private Business business;
	
	private Map<String, Object> request;
	
	private String city = "北京";
	
	private BusinessService businessService;
	
	private BusTradingService busTradingService;
	
	private CateLineService cateLineService;

	@Override
	public Business getModel() {
		return business;
	}
	
	public String offline() {
		System.out.println("offline");
//		List list = busTradingService.queryHot();
//		List<Business> buss = new ArrayList<Business>();
//		for (int i = 0; i < list.size(); i++) {
//			Object[] arr = (Object[]) list.get(i);
//			//System.out.println(arr[0]);
//			buss.add(businessService.select(Integer.valueOf(arr[1].toString())));
//		}
		ActionContext.getContext().getSession().put("buss", businessService.queryByCity(city, 0));
		List<CateLine> cates = cateLineService.selectEight();
		ActionContext.getContext().getSession().put("city", city);
		System.out.println(cates.size());
		ActionContext.getContext().getSession().put("cateLins", cates);
		
		return "gotoOfflineStore";
		
	}
	
	public String queryBusines() {
		Business bus = businessService.select(business.getBusId());
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("business", bus);
		return "gotoBusiness";
	}


	public BusinessService getBusinessService() {
		return businessService;
	}


	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}


	public BusTradingService getBusTradingService() {
		return busTradingService;
	}


	public void setBusTradingService(BusTradingService busTradingService) {
		this.busTradingService = busTradingService;
	}


	public CateLineService getCateLineService() {
		return cateLineService;
	}


	public void setCateLineService(CateLineService cateLineService) {
		this.cateLineService = cateLineService;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
}
