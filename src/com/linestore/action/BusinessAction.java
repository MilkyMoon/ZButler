package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.BusinessService;
import com.linestore.service.CateLineService;
import com.linestore.service.ThinkUserService;
import com.linestore.util.ReturnSelectHql;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.Business;
import com.linestore.vo.CateLine;
import com.linestore.vo.Customer;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BusinessAction extends ActionSupport implements ModelDriven<Business>{
	private Business business = new Business();
	
	HttpServletRequest request = ServletActionContext.getRequest ();
	private List<Business> businessList;
	private Business businessResult;
	private List<ThinkUser> thinkUserList = new ArrayList<ThinkUser>();
	
	private Integer thuId;
	
	private List<CateLine> cateLineList;
	private CateLineService cateLineService;
	private ThinkUser thinkUser = new ThinkUser();
	private ThinkUser think = new ThinkUser();
	private ThinkUserService thinkUserService;
	private ThinkUserAction thinkUserAction= new ThinkUserAction();
	
	public void setCateLineService(CateLineService cateLineService) {
		this.cateLineService = cateLineService;
	}

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
		if(business.getBusScale() == null || business.getBusStatus() == 0 ||  business.getBusScale() > 1
				|| business.getBusScale() < 0){
			business.setBusScale((float) 0);
		}
		
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		String str = business.getBaProvince();
		String strs[] = str.split(" ");
		System.out.println(cus.getCusId());
		business.setCustomer(cus);
		business.setBaProvince(strs[0]);
		business.setBaCity(strs[1]);
		business.setBaCounty(strs[2]);
		business.setBusStatus(0);
		business.setBusChange(0.0f);
		business.setBusOrgUrl("Public/Uploads/store.png");
		businessService.add(business);
		businessService.CreateTd(business);
		return SUCCESS;
	}
	
	public String update(){
		
//		if(business.getBusStatus().equals("on")){
//			business.setBusStatus(1);
//		} else {
//			business.setBusStatus(0);
//		}
		
		if(business.getBusStatus() == 0 || business.getBusScale() == null || business.getBusScale() > 1
				|| business.getBusScale() < 0){
			business.setBusScale((float) 0);
		}
		
			int id = business.getBusId();
//			business.setBusId(null);
			
			String hql;
			try {
				
				hql = ReturnUpdateHql.ReturnHql(business.getClass(), business, id);
//				System.out.println(business.getBusStatus());
				businessService.update(hql);
				ActionContext.getContext().getSession().put("store", businessService.select(id));
				
				
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
	
public String updateBus(){
		
//		if(business.getBusStatus().equals("on")){
//			business.setBusStatus(1);
//		} else {
//			business.setBusStatus(0);
//		}
		
			int id = business.getBusId();
//			business.setBusId(null);
			
			String hql;
			try {
				
				hql = ReturnUpdateHql.ReturnHql(business.getClass(), business, id);
//				System.out.println(business.getBusStatus());
				businessService.update(hql);
				ActionContext.getContext().getSession().put("store", businessService.select(id));
				
				
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
			
			
		
		return "gotoStore";
	}
	
	public String delete(){
		businessService.delete(business);
		businessList = businessService.selectAll();
		ActionContext.getContext().getValueStack().set("list", businessList);
		
		return "selectAll";
	}
	
	public String selectAll(){
		getId();
		
		if(think.getArea().getPid() == 0){
			businessList = businessService.selectAll();
		}else{
			business.setBaCounty(think.getArea().getArea());
			business.setBaCity(think.getArea().getArea());
			business.setBaProvince(think.getArea().getArea());
			
			businessList = (List<Business>) businessService.selectByArea(business);
		}
		
//		System.out.println("list:"+businessList);
//		HttpServletRequest request = ServletActionContext.getRequest ();
//		request.setAttribute("businessList", businessList);
//		System.out.println(businessList.get(0).getBusDistrict());
//		request.setAttribute("list", businessList);
		ActionContext.getContext().getValueStack().set("list", businessList);
		return "selectAll";
	}
	
	public Business selectById(){
		String hql;
		try {
			hql = ReturnSelectHql.ReturnHql(business.getClass(), business);
			businessResult = businessService.select(hql).get(0);
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

		return businessResult;
	}
	
	
	public String read(){
		getId();
		businessResult = selectById();
		cateLineList = cateLineService.selectAll();
		
		List<ThinkUser> list = new ArrayList<ThinkUser>();
		thinkUserService.queryFormat(list, thuId, 0);
		
		if(businessResult == null){
			return ERROR;
		}else{
			request.setAttribute("roots", cateLineList);
			request.setAttribute("businessResult", businessResult);
			request.setAttribute("list", list);
			return "read";
		}
	}
	
	public String edit(){
		read();
		return "edit";
	}
	
	public String store() {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		List<Business> bus = (List<Business>) businessService.queryByCusId(cus.getCusId());
		if (bus.size() > 0) {
			System.out.println(bus.get(0));
			ActionContext.getContext().getSession().put("store", bus.get(0));
		}
		return "gotoStore";
	}
	
	public String select(){
		businessResult = businessService.select(business).get(0);
		
		cateLineList = cateLineService.selectAll();
		Map<String, Object> req = (Map<String, Object>) ActionContext.getContext().get("request");
		req.put("roots", cateLineList);
		
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
	
	public Integer getId(){
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		thuId = think.getThuId();
		return thuId;
	}
	
	public String[] inList(Integer id){
		//判断当前操作的id是否为当前用户可操作id
		List<ThinkUser> userList = new ArrayList<ThinkUser>();
		thinkUserService.queryFormat(userList, id, 1);
		//当前管理员所能管理的管理员集合
		String arr[] = new String[userList.size()+1];
		
		arr[0] = id.toString();
		for(int j = 0; j < userList.size(); j++){
			arr[j+1] = userList.get(j).getThuId().toString();
		}
		return arr;
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

	public void setThinkUserService(ThinkUserService thinkUserService) {
		this.thinkUserService = thinkUserService;
	}

	public void setThinkUser(ThinkUser thinkUser) {
		this.thinkUser = thinkUser;
	}
	
	
}
