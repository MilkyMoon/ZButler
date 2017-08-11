package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.linestore.service.SettingService;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.Setting;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SettingAction extends ActionSupport implements ModelDriven<Setting> {
	
	private Setting setting = new Setting();
	
	private SettingService settingService;
	@Override
	public Setting getModel() {
		// TODO Auto-generated method stub
		return setting;
	}
	
	
	public String selectAll() {
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		List<Setting> sets = settingService.queryAll();
		request.put("sets", sets);
		return "selectAll";
	}
	
	public String update() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String hql = ReturnUpdateHql.ReturnHql(Setting.class, setting, setting.getSetId());
		settingService.update(hql);
		return "update";
	}
	
	
	
	public SettingService getSettingService() {
		return settingService;
	}
	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}
	
	

}
