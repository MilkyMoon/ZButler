package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.CateLineService;
import com.linestore.service.SiteConfigService;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.CateLine;
import com.linestore.vo.Catetory;
import com.linestore.vo.SiteConfig;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class CateLineAction extends ActionSupport implements ModelDriven<CateLine> {
	HttpServletRequest request = ServletActionContext.getRequest();
	private CateLine cateLine = new CateLine();
	private CateLineService cateLineService;
	private SiteConfigService siteConfigService;

	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}

	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}

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

	public String add() {
		selectAll();
		return "add";
	}

	public String edit() {
		selectById();
		selectAll();
		System.out.println(cateLineResult);
		request.setAttribute("root", cateLineResult);
		return "edit";
	}

	public void selectById() {
		cateLineResult = cateLineService.selectById(cateLine);
	}

	public String save() {
		cateLineService.save(cateLine);

		return "select";
	}

	public String update() {
		int id = cateLine.getCalId();
		// business.setBusId(null);

		String hql;
		try {
			hql = ReturnUpdateHql.ReturnHql(cateLine.getClass(), cateLine, id);
			// System.out.println(business.getBusStatus());
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

	public String delete() {

		cateLineService.delete(cateLine);

		return "select";
	}

	public String selectAll() {
		List<CateLine> list = new ArrayList<CateLine>();

		cateLineService.queryFormat(list, 0, 0);
		// cateLineList = cateLineService.selectChildren(0);

		request.setAttribute("roots", list);
		return "selectAll";
	}

	public String queryRoot() {

		List<CateLine> smalls = cateLineService.selectChildren(pid);
		// cateLineList = cateLineService.selectChildren(0);
		SiteConfig siteConfigs = siteConfigService.selectById(2);
		request.setAttribute("roots", smalls);
		request.setAttribute("sc", siteConfigs);
		return "selectAll";
	}

	public String editBus() {

		List<CateLine> smalls = cateLineService.selectChildren(pid);
		// cateLineList = cateLineService.selectChildren(0);

		request.setAttribute("roots", smalls);
		return "gotoEdit";
	}

	public String querySmall() {
		List<CateLine> smalls = cateLineService.selectChildren(pid);
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				if (name.equals("businesses")) {
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
