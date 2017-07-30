package com.linestore.action;

import java.util.ArrayList;
import java.util.Arrays;
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
		List<ThinkUser> listFor = new ArrayList<ThinkUser>();
		List<ThinkUser> listOld = new ArrayList<ThinkUser>();
		List<ThinkUser> listNew = new ArrayList<ThinkUser>();
		List<ThinkUser> listResault = new ArrayList<ThinkUser>();
		Integer a = 0;
		
		
		if(thinkUser.getThuName() == null || thinkUser.getThuName().equals("")){
			thinkUser.setThuId(a);
			selectById();
			if(a == 0){
				thinkUserService.queryFormat(listNew, a, 0); //2为管理员id
			} else {
				thinkUserService.queryFormat(listNew, a, 1); //2为管理员id
				listResault.add(thinkUserResult);	
			}
			listResault.addAll(listNew);
		} else {
			System.out.println("搜索---else");
			thinkUserList = thinkUserService.select(thinkUser);
			thinkUserService.queryFormat(listOld, a, 1); //a为管理员id
			
			//当前管理员所能管理的管理员集合
			String arr[] = new String[listOld.size()+1];
			
			arr[0] = a.toString();
			for(int j = 0; j < listOld.size(); j++){
				arr[j+1] = listOld.get(j).getThuId().toString();
				System.out.println("arr:"+arr[j]);
			}
			
			//判断当前搜索的管理员是否是其管理的下级
			for(int k = 0; k < thinkUserList.size(); k++){
				for(int i=0;i<arr.length;i++){ 
					if(arr[i].equals(thinkUserList.get(k).getThuId().toString())){//循环查找字符串数组中的每个字符串中是否包含所有查找的内容 
						listNew.add(thinkUserList.get(k));
					}
				}
			}
			
			System.out.println("-----------------------------------");
			
			boolean inList = false;
			for(int i = 0; i < listNew.size(); i++){
				List<ThinkUser> list = new ArrayList<ThinkUser>();
				
				System.out.println("listNew:"+listNew.get(i).getThuArea());
				System.out.println("listNewId:"+listNew.get(i).getThuId());
				
				thinkUserService.queryFormat(list, listNew.get(i).getThuId(), 1);
				
				//判断当前集合是否存在于其他集合当中
				for(int j = 0; j < listNew.size(); j++){
					thinkUserService.queryFormat(listFor, listNew.get(j).getThuId(), 1);
					for(int m = 0; m < listFor.size(); m++){
						System.out.println("listFor:"+listFor.get(m).getThuId());
						if(listNew.get(i).getThuId() == listFor.get(m).getThuId()){
							System.out.println("id:"+listNew.get(i).getThuId());
							inList = true;
							break;
						}
					}
					
					if(inList){
						break;
					}
				}
				
				if(inList){
					inList = false;
					continue;
				}
				
				listResault.add(listNew.get(i));
				listResault.addAll(list);
			}
		}		
		
		ActionContext.getContext().getSession().put("list", listResault);
		
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
