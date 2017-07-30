package com.linestore.action;

import java.util.ArrayList;
import java.util.List;

import com.linestore.vo.Group;
import com.linestore.vo.Rule;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GroupAction extends ActionSupport implements ModelDriven<Group>{
	private Group group = new Group();
	private List<Rule> rule = new ArrayList<Rule>();
	
	@Override
	public Group getModel() {
		// TODO Auto-generated method stub
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public String add(){
		
		return "add";
	}
	
	public String selectAll(){
		
		return "selectAll";
	}
	
	
	
}
