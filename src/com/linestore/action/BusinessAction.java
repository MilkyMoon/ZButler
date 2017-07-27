package com.linestore.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.linestore.service.BusinessService;
import com.linestore.vo.Business;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.query.criteria.internal.expression.SizeOfPluralAttributeExpression;

public class BusinessAction extends ActionSupport implements ModelDriven<Business>{
	private Business business = new Business();
	
	HttpServletRequest request = ServletActionContext.getRequest ();
	private List<Business> businessList;
	private Business businessResult;
	

	@Override
	public Business getModel() {
		// TODO Auto-generated method stub
		return business;
	}
	
	private BusinessService businessService;
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public String add(){
		business.setBaCountry("中国");
//		business.getBusAddress().add(busAddress);
//		business.getBusBanks().add(busBank);
//		
//		busAddressService.add(busAddress);
//		busBankService.add(busBank);
		String str = business.getBaProvince();
		String strs[] = str.split(" ");
		business.setBaProvince(strs[0]);
		business.setBaCity(strs[1]);
		business.setBaCounty(strs[2]);
		business.setBusStatus(0);
		businessService.add(business);
		return SUCCESS;
	}
	
	public String update(){
		
//		if(business.getBusStatus().equals("on")){
//			business.setBusStatus(1);
//		} else {
//			business.setBusStatus(0);
//		}
		
		System.out.println(business.getBusStatus());
		businessService.update(business);
		businessList = businessService.selectAll(business);
		ActionContext.getContext().getValueStack().set("list", businessList);
		
		return "selectAll";
	}
	
	public String delete(){
		businessService.delete(business);
		businessList = businessService.selectAll(business);
		ActionContext.getContext().getValueStack().set("list", businessList);
		
		return "selectAll";
	}
	
	public String selectAll(){
		
		businessList = businessService.selectAll(business);
//		System.out.println("list:"+businessList);
//		HttpServletRequest request = ServletActionContext.getRequest ();
//		request.setAttribute("businessList", businessList);
		System.out.println(businessList.get(0).getBusDistrict());
		ActionContext.getContext().getValueStack().set("list", businessList);
		return "selectAll";
	}
	
	public String read(){
		businessResult = businessService.select(business);
		if(businessResult == null){
			return ERROR;
		}else{
			request.setAttribute("businessResult", businessResult);
			return "read";
		}
	}
	
	public String edit(){
		businessResult = businessService.select(business);
		if(businessResult == null){
			return ERROR;
		}else{
			return "edit";
		}
	}
	
	public String select(){
		businessResult = businessService.select(business);
		if(businessResult == null){
			return ERROR;
		}else{
			return "select";
		}
	}
	
	public String jump() {
		String js = "<script>YDUI.dialog.alert('申请成功！');</script>";
		Map<String, Object> map = (Map<String, Object>) ActionContext.getContext().get("request");
		map.put("js", js);
		return "gotoCustomer";
	}

	public List<Business> getBusinessList() {
		return businessList;
	}

	public void setBusinessList(List<Business> businessList) {
		this.businessList = businessList;
	}
	
	public Business getBusinessResult() {
		return businessResult;
	}

	public void setBusinessResult(Business businessResult) {
		this.businessResult = businessResult;
	}
}
