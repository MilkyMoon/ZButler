package com.linestore.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linestore.service.GroupService;
import com.linestore.service.RuleGroupService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Group;
import com.linestore.vo.Rule;
import com.linestore.vo.RuleGroup;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GroupAction extends ActionSupport implements ModelDriven<Group>{
	private Group group = new Group();
	
	private GroupService groupService;
	private RuleGroupService ruleGroupService;
	private List<RuleGroup> ruleGroupList = new ArrayList<RuleGroup>();
	
	private String[] rules;
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";
	
	@Override
	public Group getModel() {
		return group;
	}
	
	
	public String selectAll() {
		ThinkUser thu = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		int totalNum = groupService.queryAll(thu.getThuId()).size();
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null || Integer.parseInt(pageNow) > Math.ceil((double)totalNum / Integer.parseInt(everyPage)) ){
			pageNow = "1";
		}
		
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalNum, Integer.parseInt(pageNow));
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		List<Group> gros = groupService.queryAll(page, thu.getThuId());
		request.put("gros", gros);
		request.put("page", page);
		return "gotoGroup";
	}
	
	public String add() {
		ThinkUser thu = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		ruleGroupList = ruleGroupService.selectAll(thu.getGroup().getGrpId());
		
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("rulelist", ruleGroupList);
		
		return "gotoAdd";
	}
	
	public String save() {
		groupService.addGroup(group);
		System.out.println("------>"+group.getGrpId());
		for (int i = 0; i < rules.length; i++) {
			RuleGroup rg = new RuleGroup();
			rg.setGroup(group);
			Rule r = new Rule();
			r.setRulId(Integer.parseInt(rules[i]));
			rg.setRule(r);
			ruleGroupService.AddRuleGroup(rg);
		}
		return "selectAll";
	}
	
	public String select() {
		ThinkUser thu = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		List<Group> gros = groupService.queryByTitle(group.getGrpTitle(), thu.getThuId());
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), gros.size(), Integer.parseInt(pageNow));
		request.put("gros", gros);
		request.put("page", page);
		return "gotoGroup";
	}
	
	public String read() {
		Group gp = groupService.queryById(group.getGrpId());
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("group", gp);
		return "read";
	}
	
	public String delete() {
		try {
			groupService.delGroup(group.getGrpId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return selectAll();
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


	public String[] getRules() {
		return rules;
	}


	public void setRules(String[] rules) {
		this.rules = rules;
	}


	public RuleGroupService getRuleGroupService() {
		return ruleGroupService;
	}


	public void setRuleGroupService(RuleGroupService ruleGroupService) {
		this.ruleGroupService = ruleGroupService;
	}
	
	
	
}
