package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
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
	
	private ThinkUser think;
	
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
	
	public String add(){
		select();
		return "add";
	}
	
	public String edit(){
		select();
		areaReslut = areaService.queryById(area.getAreId());
		ActionContext.getContext().getSession().put("roots", areaReslut);
		return "edit";
	}
	
	public String save(){
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

}
