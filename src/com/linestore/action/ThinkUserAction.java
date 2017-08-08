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
		String[] arr = inList(userId);

		int i = 0;
		// 判断当前搜索的管理员是否是其管理的下级
		for (i = 0; i < arr.length; i++) {
			System.out.println("arr:"+arr[i]);
			if (arr[i].equals(thinkUser.getThuId().toString())) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
				break;
			}
		}
		if (i == arr.length) {
			return "select";
		}
		selectById();
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

		List<ThinkUser> listFor = new ArrayList<ThinkUser>();
		List<ThinkUser> listNew = new ArrayList<ThinkUser>();
		List<ThinkUser> listResault = new ArrayList<ThinkUser>();

		if (thinkUser.getThuName() == null || thinkUser.getThuName().equals("")) {
			thinkUser.setThuId(userId);
			selectById();
			if (userId == 0) {
				thinkUserService.queryFormat(listNew, userId, 0); // userId为管理员id
			} else {
				thinkUserService.queryFormat(listNew, userId, 1); // userId为管理员id
				listResault.add(thinkUserResult);
			}
			listResault.addAll(listNew);
		} else {
			System.out.println("---------" + thinkUser.getThuName());
			thinkUserList = thinkUserService.select(thinkUser);

			String[] arr = inList(userId);

			// 判断当前搜索的管理员是否是其管理的下级
			for (int k = 0; k < thinkUserList.size(); k++) {
				for (int i = 0; i < arr.length; i++) {
					if (arr[i].equals(thinkUserList.get(k).getThuId().toString())) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
						listNew.add(thinkUserList.get(k));
					}
				}
			}

			System.out.println("-----------------------------------");

			boolean inList = false;
			for (int i = 0; i < listNew.size(); i++) {
				List<ThinkUser> list = new ArrayList<ThinkUser>();

				System.out.println("listArea:" + listNew.get(i).getArea().getArea());
				System.out.println("listNewId:" + listNew.get(i).getThuId());

				thinkUserService.queryFormat(list, listNew.get(i).getArea().getAreId(), 1);

				// 判断当前集合是否存在于其他集合当中
				for (int j = 0; j < listNew.size(); j++) {
					thinkUserService.queryFormat(listFor, listNew.get(j).getArea().getAreId(), 1);
					for (int m = 0; m < listFor.size(); m++) {
						System.out.println("listFor:" + listFor.get(m).getThuId());
						if (listNew.get(i).getThuId() == listFor.get(m).getThuId()) {
							System.out.println("id:" + listNew.get(i).getThuId());
							inList = true;
							break;
						}
					}

					if (inList) {
						break;
					}
				}

				if (inList) {
					inList = false;
					continue;
				}

				listResault.add(listNew.get(i));
				listResault.addAll(list);
			}
		}

		ActionContext.getContext().getSession().put("list", listResault);
		
		System.out.println();

		return "selectAll";
	}

	public String status() {
		ThinkUser think = new ThinkUser();
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		this.userId = think.getArea().getAreId();

		System.out.println("status:" + thinkUser.getThuId());
		if (thinkUser.getThuId() == userId) {
			return "select";
		}
		String[] arr = inList(userId);

		int i = 0;
		// 判断当前搜索的管理员是否是其管理的下级
		for (i = 0; i < arr.length; i++) {
			if (arr[i].equals(thinkUser.getThuId().toString())) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
				break;
			}
		}
		if (i == arr.length) {
			return "select";
		}

		selectById();
		thinkUserResult.setThuStatus(thinkUser.getThuStatus());
		thinkUserResult.getArea().setAreaScale((float) 1);
		thinkUserResult.getArea().setAreaScaleTwo((float) 0);
		thinkUserService.status(thinkUserResult);

		return "select";
	}

	public String[] inList(Integer id) {
		// 判断当前操作的id是否为当前用户可操作id
		List<ThinkUser> userList = new ArrayList<ThinkUser>();
		thinkUserService.queryFormat(userList, id, 1);
		// 当前管理员所能管理的管理员集合
		String arr[] = new String[userList.size() + 1];

		arr[0] = id.toString();
		for (int j = 0; j < userList.size(); j++) {
			arr[j + 1] = userList.get(j).getThuId().toString();
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
