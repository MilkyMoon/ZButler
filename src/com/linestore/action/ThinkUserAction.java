package com.linestore.action;

import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.AreaService;
import com.linestore.service.CatetoryService;
import com.linestore.service.ThinkUserService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.Area;
import com.linestore.vo.Catetory;
import com.linestore.vo.GroupAccess;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ThinkUserAction extends ActionSupport implements ModelDriven<ThinkUser> {
	private ThinkUser thinkUser = new ThinkUser();
	private List<ThinkUser> thinkUserList;
	private ThinkUserService thinkUserService;
	private ThinkUser thinkUserResult;
	private Area area = new Area();
	private AreaService areaService;
	private Integer userId;
	List<Area> areaList = new ArrayList<Area>();
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";

	@Override
	public ThinkUser getModel() {
		// TODO Auto-generated method stub
		return thinkUser;
	}

	// public void setThinkUserList(List<ThinkUser> thinkUserList) {
	// this.thinkUserList = thinkUserList;
	// }

	public void setThinkUserService(ThinkUserService thinkUserService) {
		this.thinkUserService = thinkUserService;
	}

	public String selectAll() {
		List<ThinkUser> list = new ArrayList<ThinkUser>();
		thinkUserService.queryFormat(list, 0, 0);
		ActionContext.getContext().getSession().clear();
		ActionContext.getContext().getSession().put("list", list);

		return "selectAll";
	}

	public String add() {
		ThinkUser think = new ThinkUser();
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		this.userId = think.getArea().getAreId();
		
		List<Area> list = new ArrayList<Area>();
		Area areaResult;
		List<Area> listResalut = new ArrayList<Area>();
		
		areaResult = areaService.queryById(userId);
		areaService.queryArea(list, userId, 1);

		listResalut.add(areaResult);
		listResalut.addAll(list);

		ActionContext.getContext().getSession().put("list", listResalut);
		return "add";
	}

	public String edit() {
		ThinkUser think = new ThinkUser();
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		this.userId = think.getArea().getAreId();
		Integer[] arr = inList(userId);

		selectById();
		int i = 0;
		// 判断当前搜索的管理员是否是其管理的下级
		for (i = 0; i < arr.length; i++) {
			System.out.println("arr:"+arr[i]);
			if (arr[i] == thinkUserResult.getArea().getAreId()) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
				break;
			}
		}
		if (i == arr.length) {
			return "select";
		}
		
		ActionContext.getContext().getSession().put("listInfo", thinkUserResult);

		
		add();
		return "edit";
	}

	public void setThinkUserResult(ThinkUser thinkUserResult) {
		this.thinkUserResult = thinkUserResult;
	}

	public String save() {
		if (thinkUser.getThuStatus().equals("-1") || thinkUser.getArea().getAreaScale() == null || thinkUser.getArea().getAreaScale() > 1
				|| thinkUser.getArea().getAreaScale() < 0) {
			thinkUser.getArea().setAreaScale((float) 1);
		}
		if (thinkUser.getThuStatus().equals("-1") || thinkUser.getArea().getAreaScaleTwo() == null || thinkUser.getArea().getAreaScaleTwo() > 1
				|| thinkUser.getArea().getAreaScaleTwo() < 0) {
			thinkUser.getArea().setAreaScaleTwo((float) 0);
		}
		thinkUserService.add(thinkUser);
		return "select";
	}


	public String updateThuOpenid() {
		System.out.println("------think_user_action_进来了");
		String thuOpenid = (String) ActionContext.getContext().getSession().get("thuOpenid");
		int id = (int) ActionContext.getContext().getSession().get("thuId");
		thinkUser.setThuOpenid(thuOpenid);
		System.out.println(thuOpenid + "-----" + id);

		String hql;
		try {

			hql = ReturnUpdateHql.ReturnHql(thinkUser.getClass(), thinkUser, id);
			// System.out.println(business.getBusStatus());
			thinkUserService.update(hql);

			thinkUser.setThuName(null);
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
	
	public String update() {
		int id = thinkUser.getThuId();

		String hql;
		try {

			hql = ReturnUpdateHql.ReturnHql(thinkUser.getClass(), thinkUser, id);
			// System.out.println(business.getBusStatus());
			thinkUserService.update(hql);

			thinkUser.setThuName(null);
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

	public String delete() {
		ThinkUser think = new ThinkUser();
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		this.userId = think.getThuId();
		Integer thId = thinkUser.getThuId();
		
		if (thId == userId) {
			return "select";
		}

		System.out.println("-----------------------------------");
		
		thinkUserService.delete(thinkUser.getThuId());
		return "select";
	}

	public String selectById() {
		this.thinkUserResult = thinkUserService.selectById(thinkUser);

		return "selectById";
	}

	public String select() {
		ThinkUser think = new ThinkUser();
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		this.userId = think.getArea().getAreId();

		System.out.println("userId:" + userId);
		System.out.println("pid:"+think.getArea().getPid());

		List<ThinkUser> listNew = new ArrayList<ThinkUser>();
		List<ThinkUser> listResault = new ArrayList<ThinkUser>();
		
		Integer[] arr = inList(userId);
		
		int totalCount;
		if(keywords == null || keywords.equals("")){
			totalCount = thinkUserService.selectAllByAreaCount(arr);
		} else {
			totalCount = thinkUserService.selectAllByKeyCount(keywords);
		}	
		
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Integer.parseInt(everyPage)))){
			pageNow = "1";
		}
		
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));

		if (keywords == null || keywords.equals("")) {
			
			listNew = thinkUserService.selectAllByArea(page, arr);// userId为管理员id
			
		} else {

			listNew = thinkUserService.selectAllByKey(page, keywords);
		}
		
		listResault.addAll(listNew);
		
		ActionContext.getContext().getSession().put("page", page);
		ActionContext.getContext().getSession().put("list", listResault);

		return "selectAll";
	}

	public String status() {
		ThinkUser think = new ThinkUser();
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		this.userId = think.getArea().getAreId();

		System.out.println("status:" + thinkUser.getThuId());
		if (thinkUser.getThuId() == think.getThuId()) {
			return "select";
		}
		Integer[] arr = inList(userId);
		
		selectById();

		int i = 0;
		// 判断当前搜索的管理员是否是其管理的下级
		for (i = 0; i < arr.length; i++) {
			if (arr[i] == thinkUserResult.getArea().getAreId()) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
				break;
			}
		}
		if (i == arr.length) {
			return "select";
		}
		
		thinkUserResult.setThuStatus(thinkUser.getThuStatus());
		thinkUserResult.getArea().setAreaScale((float) 1);
		thinkUserResult.getArea().setAreaScaleTwo((float) 0);
		thinkUserService.status(thinkUserResult);

		return "select";
	}

	public Integer[] inList(Integer id) {
		// 判断当前操作的id是否为当前用户可操作id
		areaService.queryArea(areaList, id, 1);
		// 当前管理员所能管理的管理员集合
		Integer arr[] = new Integer[areaList.size() + 1];

		arr[0] = id;
		for (int j = 0; j < areaList.size(); j++) {
			System.out.println("areId:"+areaList.get(j).getAreId());
			arr[j + 1] = areaList.get(j).getAreId();
		}
		return arr;
	}
	
	public Integer[] inListThink(Integer id) {
		// 判断当前操作的id是否为当前用户可操作id
		List<ThinkUser> thinkList = new ArrayList<ThinkUser>();
		thinkUserService.queryFormat(thinkList, id, 1);
		// 当前管理员所能管理的管理员集合
		Integer arr[] = new Integer[thinkList.size() + 1];

		arr[0] = id;
		for (int j = 0; j < thinkList.size(); j++) {
			System.out.println("areId:"+thinkList.get(j).getThuId());
			arr[j + 1] = thinkList.get(j).getThuId();
		}
		return arr;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
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
	
//	public String viewImages() {  
//        HttpServletResponse response = null;  
//        ServletOutputStream out = null;  
//        try {  
//            response = ServletActionContext.getResponse();  
//            response.setContentType("multipart/form-data");  
//            out = response.getOutputStream();  
//            Object file;
//			out.write(((Object) file).getContent());
//            out.flush();  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {
//            if (out != null) {  
//                try {  
//                    out.close();  
//                } catch (Exception e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//            if (response != null) {  
//                try {  
//                    ((OutputStream) response).close();  
//                } catch (Exception e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return null;  
//    }
	
	

}
