package com.linestore.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.CateLineService;
import com.linestore.vo.CateLine;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CateLineAction extends ActionSupport implements ModelDriven<CateLine>{
	HttpServletRequest request = ServletActionContext.getRequest ();
	private CateLine cateLine = new CateLine();
	private CateLineService cateLineService;
	private List<CateLine> cateLineList;
	
	public void setCateLineService(CateLineService cateLineService) {
		this.cateLineService = cateLineService;
	}

	@Override
	public CateLine getModel() {
		// TODO Auto-generated method stub
		return cateLine;
	}

	public void setCateLine(CateLine cateLine) {
		this.cateLine = cateLine;
	}

	public String add(){
		
		return "add";
	}
	
	public String selectAll(){
		cateLineList = cateLineService.selectAll();
		
		request.setAttribute("roots", cateLineList);
		return "selectAll";
	}
}
