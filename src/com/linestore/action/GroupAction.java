package com.linestore.action;

import java.util.List;
import java.util.Map;

import com.linestore.service.GroupService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Group;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GroupAction extends ActionSupport implements ModelDriven<Group>{
	private Group group = new Group();
	
	private GroupService groupService;
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";
	
	@Override
	public Group getModel() {
		return group;
	}
	
	
	public String selectAll() {
		int totalNum = groupService.queryAll().size();
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null || Integer.parseInt(pageNow) > Math.ceil((double)totalNum / Integer.parseInt(pageNow))){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalNum, Integer.parseInt(pageNow));
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		List<Group> gros = groupService.queryAll(page);
		request.put("gros", gros);
		request.put("page", page);
		return "gotoGroup";
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
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
