package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.BusinessService;
import com.linestore.service.BusinessTmpService;
import com.linestore.service.CateLineService;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.Business;
import com.linestore.vo.BusinessTmp;
import com.linestore.vo.CateLine;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BusinessTmpAction extends ActionSupport implements ModelDriven<BusinessTmp>{
	HttpServletRequest request = ServletActionContext.getRequest();
	private BusinessTmp businessTmp = new BusinessTmp();
	private List<BusinessTmp> businessTmpList = new ArrayList<BusinessTmp>();
	private BusinessTmpService businessTmpService;
	private BusinessService businessService;
	private Business businessResalut;
	private BusinessTmp businessTmpResalut;
	private CateLine cateLine = new CateLine();
	private CateLineService cateLineService;
	private CateLine cateLineBig;
	private CateLine cateLineSmall;
	private CateLine cateBus;
	
	@Override
	public BusinessTmp getModel() {
		// TODO Auto-generated method stub
		return businessTmp;
	}
	
	public String selectAll(){
		businessTmpList = businessTmpService.selectAll();
		
		ActionContext.getContext().getSession().put("list", businessTmpList);
		
		return "selectAll";
	}
	
	public String save() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		businessTmpResalut = businessTmpService.queryById(businessTmp.getBusId());
		System.out.println("busCalId:"+businessTmpResalut.getBusCalId());
		//通过
		Business bus = new Business(businessTmpResalut);
		String hql = ReturnUpdateHql.ReturnHql(Business.class, bus, bus.getBusId());
		if(businessTmp.getBusStatus() == 1){
			businessService.update(hql);
		}
		
		businessTmpService.delBusinessTmp(businessTmp.getBusId());
		
		return "select";
	}
	
	public String read(){
		businessTmpResalut = businessTmpService.queryById(businessTmp.getBusId());
		businessResalut = businessService.select(businessTmp.getBusId());
		
		if(businessTmpResalut.getBusCalId() != null){
			cateLine.setCalId(businessTmpResalut.getBusCalId());
			cateLineBig = cateLineService.selectById(cateLine);
		}
		
		if(businessTmpResalut.getBusSmallCate() != null){
			cateLine.setCalId(businessTmpResalut.getBusSmallCate());
			cateLineSmall = cateLineService.selectById(cateLine);
		}
		
		if(businessResalut.getBusSmallCate() != null){
			cateLine.setCalId(businessResalut.getBusSmallCate());
			cateBus = cateLineService.selectById(cateLine);
		}
		
		request.setAttribute("buslist", businessResalut);
		request.setAttribute("tmplist", businessTmpResalut);
		request.setAttribute("cateLineBig", cateLineBig);
		request.setAttribute("cateLineSmall", cateLineSmall);
		request.setAttribute("cateBus", cateBus);

		return "read";
	}

	public BusinessTmpService getBusinessTmpService() {
		return businessTmpService;
	}

	public void setBusinessTmpService(BusinessTmpService businessTmpService) {
		this.businessTmpService = businessTmpService;
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public CateLineService getCateLineService() {
		return cateLineService;
	}

	public void setCateLineService(CateLineService cateLineService) {
		this.cateLineService = cateLineService;
	}

	
}
