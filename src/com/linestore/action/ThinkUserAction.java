package com.linestore.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linestore.service.CatetoryService;
import com.linestore.service.ThinkUserService;
import com.linestore.vo.Catetory;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ThinkUserAction extends ActionSupport implements ModelDriven<ThinkUser>{
	private ThinkUser thinkUser = new ThinkUser();
//	private List<ThinkUser> thinkUserList;
	private ThinkUserService thinkUserService;


	@Override
	public ThinkUser getModel() {
		// TODO Auto-generated method stub
		return thinkUser;
	}
	
//	public void setThinkUserList(List<ThinkUser> thinkUserList) {
//		this.thinkUserList = thinkUserList;
//	}

	public void setThinkUserService(ThinkUserService thinkUserService) {
		this.thinkUserService = thinkUserService;
	}

	public String SelectAll(){
		List<ThinkUser> list = new ArrayList<ThinkUser>();
		thinkUserService.queryFormat(list, 0);
		
		ActionContext.getContext().getSession().put("list", list);
		
		return "SelectAll";
	}

}
