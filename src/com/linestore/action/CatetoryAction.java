package com.linestore.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linestore.service.CatetoryService;
import com.linestore.vo.Catetory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class CatetoryAction extends ActionSupport implements ModelDriven<Catetory> {
	
	private Catetory catetoey = new Catetory();
	
	private CatetoryService catetoryService;
	
	private Map<String, Object> request;
	
	private String result;
	
	private int pid;

	@Override
	public Catetory getModel() {
		return catetoey;
	}
	
	public String queryFirst() {
		List<Catetory> catetories = catetoryService.queryByPid(0);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", catetories);
		return "gotoApply";
	}
	
	public String querySmall() {
		List<Catetory> smalls = catetoryService.queryByPid(pid);
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter()
		{
		         public boolean apply(Object source, String name, Object value) {
		           if(name.equals("attValues")||name.equals("brands")||name.equals("goodses")
		        		   ||name.equals("suppliers")||name.equals("businesses")||name.equals("attributes")) {
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

	public CatetoryService getCatetoryService() {
		return catetoryService;
	}

	public void setCatetoryService(CatetoryService catetoryService) {
		this.catetoryService = catetoryService;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	

}
