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
	private List<ThinkUser> thinkUserList;
	private ThinkUserService thinkUserService;
	private ThinkUser thinkUserResult;


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

	public String selectAll(){
		List<ThinkUser> list = new ArrayList<ThinkUser>();
		thinkUserService.queryFormat(list, 0, 0);
		
		ActionContext.getContext().getSession().put("list", list);
		
		return "selectAll";
	}
	
	public String add(){
		List<ThinkUser> list = new ArrayList<ThinkUser>();
		selectById();
		List<ThinkUser> listResault = new ArrayList<ThinkUser>();
		
		thinkUserService.queryFormat(list, thinkUser.getThuId(), 1);
		
		listResault.add(thinkUserResult);
		listResault.addAll(list);
		System.out.println("------------------------");
		for(int i=0; i<listResault.size(); i++){
			System.out.println(listResault.get(i).getThuId());
		}
		
		ActionContext.getContext().getSession().put("list", listResault);
		return "add";
	}
	
	public void setThinkUserResult(ThinkUser thinkUserResult) {
		this.thinkUserResult = thinkUserResult;
	}

	public String save(){
		thinkUserService.add(thinkUser);
		selectAll();
		return "selectAll";
	}
	
	public String delete(){
		System.out.println(thinkUser.getThuId());
		thinkUserService.delete(thinkUser);
		selectAll();
		return "selectAll";
	}
	
	public String selectById(){
		this.thinkUserResult = thinkUserService.selectById(thinkUser);
		
		return "selectById";
	}
	
	public String select(){
		List<ThinkUser> list = new ArrayList<ThinkUser>();
		if(thinkUser.getThuName() == null || thinkUser.getThuName().equals("")){
			selectAll();
		} else {
			System.out.println("搜索---else");
			thinkUserList = thinkUserService.select(thinkUser);
			List<ThinkUser> listResault = new ArrayList<ThinkUser>();
			System.out.println("list:"+thinkUserList.get(0).getThuArea());
			System.out.println("-----------------------------------");
			for(int i = 0; i < thinkUserList.size(); i++){
				thinkUserService.queryFormat(list, thinkUserList.get(i).getThuId(), 1);
				listResault.add(thinkUserList.get(i));
				listResault.addAll(list);
			}
			
			ActionContext.getContext().getSession().put("list", listResault);
		}
		
		
		return "selectAll";
	}
	
	public String status(){
		selectById();
		thinkUserResult.setThuStatus(thinkUser.getThuStatus());
		thinkUserService.status(thinkUserResult);
		selectAll();
		
		return "selectAll";
	}

}
