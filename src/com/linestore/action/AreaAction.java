package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linestore.service.AreaService;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.Area;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AreaAction extends ActionSupport implements ModelDriven<Area>{
	Map<String, Object> request;
	private Area area = new Area();
	private AreaService areaService;
	private List<Area> areaList = new ArrayList<Area>();
	private List<Area> areaListReslut = new ArrayList<Area>();
	private Area areaReslut;
	private int pagewhere;
	
	private ThinkUser think;

	private String keywords = "";
	
	@Override
	public Area getModel() {
		// TODO Auto-generated method stub
		return area;
	}
	
	public String select(){
		getId();
		
		if(think.getArea().getPid() == 0){
			areaService.queryArea(areaList, 0, 0);
		} else {
			areaService.queryArea(areaList, think.getArea().getAreId(), 1);
			areaListReslut.add(areaService.queryById(think.getArea().getAreId()));
		}
		areaListReslut.addAll(areaList);
		
		ActionContext.getContext().getSession().put("list", areaListReslut);
		
		return "selectAll";
	}
	
	public String search(){
		if(keywords == null || keywords.equals("")){
			if(pagewhere == 2){
				return "agent";
			}
			return "select";
		}
		
		areaListReslut = areaService.selectByKey(keywords);
		
		ActionContext.getContext().getSession().put("list", areaListReslut);
		
		if(pagewhere == 2){
			return "agent";
		}
		
		return "selectAll";
	}
	
	public String agent(){
		select();
		
		return "agent";
	}
	
	public String add(){
		select();
		return "add";
	}
	
	public String update(){
		if ((area.getStatus() != null && area.getStatus() == 0) || area.getAreaScale() == null || area.getAreaScale() > 1 || area.getAreaScale() < 0) {
			area.setAreaScale((float) 1);
		}
		
		if ((area.getStatus() != null && area.getStatus() == 0) || area.getAreaScaleTwo() == null || area.getAreaScaleTwo() > 1 || area.getAreaScaleTwo() < 0) {
			area.setAreaScaleTwo((float) 0);
		}

		int id = area.getAreId();
		// business.setBusId(null);

		String hql;
		try {

			hql = ReturnUpdateHql.ReturnHql(area.getClass(), area, id);
			// System.out.println(business.getBusStatus());
			areaService.upadteArea(hql);

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

		if(pagewhere == 2){
			return "agentSelect";
		}
		
		return "select";
	}
	
	public String edit(){
		select();
		areaReslut = areaService.queryById(area.getAreId());
		ActionContext.getContext().getSession().put("roots", areaReslut);
		
		if(pagewhere == 2){
			System.out.println("agentEdit");
			return "agentEdit";
		}
		
		System.out.println("edit");
		
		return "edit";
	}

	public String save(){
		area.setAreaScale((float) 1);
		area.setAreaScaleTwo((float) 0);
		area.setAreaTotalMoney(new BigDecimal(0));
		areaService.addArea(area);
		return "select";
	}
	
	public String delete(){
		areaService.queryArea(areaList, area.getAreId(), 0);
		if(areaList.size() < 1){
			areaService.delArea(area.getAreId());
		}
		
		return "select";
	}
	
	public String status(){
		try {
			String hql = ReturnUpdateHql.ReturnHql(area.getClass(), area, area.getAreId());
			areaService.upadteArea(hql);
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
	
	public void getId(){
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public void setThink(ThinkUser think) {
		this.think = think;
	}

	public ThinkUser getThink() {
		return think;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public int getPagewhere() {
		return pagewhere;
	}

	public void setPagewhere(int pagewhere) {
		this.pagewhere = pagewhere;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	
}
