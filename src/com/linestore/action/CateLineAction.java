package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.CateLineService;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.CateLine;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CateLineAction extends ActionSupport implements ModelDriven<CateLine>{
	HttpServletRequest request = ServletActionContext.getRequest ();
	private CateLine cateLine = new CateLine();
	private CateLineService cateLineService;
	private CateLine cateLineResult;
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
	
	public String edit(){
		selectById();
		request.setAttribute("root", cateLineResult);
		return "edit";
	}
	
	public void selectById(){
		cateLineResult = cateLineService.selectById(cateLine);
	}
	
	public String save(){
		cateLineService.save(cateLine);
		
		return "select";
	}
	
	public String update(){
		int id = cateLine.getCalId();
//		business.setBusId(null);
		
		String hql;
		try {
			hql = ReturnUpdateHql.ReturnHql(cateLine.getClass(), cateLine, id);
//			System.out.println(business.getBusStatus());
			cateLineService.update(hql);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "select";
	}
	
	public String delete(){
		cateLineService.delete(cateLine);
		
		return "select";
	}
	
	public String selectAll(){
		cateLineList = cateLineService.selectAll();
		
		request.setAttribute("roots", cateLineList);
		return "selectAll";
	}
}
