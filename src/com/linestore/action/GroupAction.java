package com.linestore.action;

import java.util.List;
import java.util.Map;

import com.linestore.service.GroupService;
import com.linestore.vo.Group;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GroupAction extends ActionSupport implements ModelDriven<Group>{
	private Group group = new Group();
	
	private GroupService groupService;
	
	@Override
	public Group getModel() {
		// TODO Auto-generated method stub
		return group;
	}
	
	
	public String selectAll() {
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		List<Group> gros = groupService.queryAll();
		request.put("gros", gros);
		return "gotoGroup";
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	
	
	
}
