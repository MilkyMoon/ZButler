package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.CateLineService;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.CateLine;
import com.linestore.vo.Catetory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class CateLineAction extends ActionSupport implements ModelDriven<CateLine>{
	HttpServletRequest request = ServletActionContext.getRequest ();
	private CateLine cateLine = new CateLine();
	private CateLineService cateLineService;
	private CateLine cateLineResult;
	private List<CateLine> cateLineList;
	
	private int pid;
	
	private String result;
	
	public void setCateLineService(CateLineService cateLineService) {
		this.cateLineService = cateLineService;
	}

	@Override
	public CateLine getModel() {
		// TODO Auto-generated method stub
		return cateLine;
	}
	
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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
		cateLineList = cateLineService.selectChildren(0);
		
		request.setAttribute("roots", cateLineList);
		return "selectAll";
	}
	
	public String querySmall() {
		List<CateLine> smalls = cateLineService.selectChildren(pid);
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter()
		{
		         public boolean apply(Object source, String name, Object value) {
		           if(name.equals("businesses")) {
		             return true;
		           } else {
		             return false;
		          }
		}
		});
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smalls", smalls);
		this.result = JSONObject.fromObject(map, cfg).toString();
		return SUCCESS;
	}
}
