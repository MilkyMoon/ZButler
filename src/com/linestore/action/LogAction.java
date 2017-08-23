package com.linestore.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linestore.service.LogService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Log;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LogAction extends ActionSupport implements ModelDriven<Log>{
	Map<String, Object> request;
	private Log log = new Log();
	private LogService logService;
	
	private List<Log> logList = new ArrayList<Log>();
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";
	
	@Override
	public Log getModel() {
		// TODO Auto-generated method stub
		return log;
	}
	
	public String select(){
		
		return "selectAll";
	}
	
	public String selectAll(){
		int totalCount = logService.qureyAll();
//		if(everyPage.equals("") || everyPage == null){
//			everyPage = "10";
//		}
//		everyPage = String.valueOf(totalCount);
//		if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Float.valueOf(everyPage)))){
//			pageNow = "1";
//		}
//		
//		System.out.println("totalCount:"+totalCount);
//		System.out.println("everyPage:"+everyPage);
//		
//		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
//		
		logList = logService.selectAll();
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", logList);
		
		return "selectAll";
	}

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
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
}
