package com.linestore.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.SettingService;
import com.linestore.service.ThinkUserService;
import com.linestore.util.CodeUtil;
import com.linestore.vo.Setting;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminLoginAction extends ActionSupport implements ModelDriven<ThinkUser> {

	private ThinkUserService thinkUserService;
	
	private ByteArrayInputStream inputStream; 
	
	private SettingService settingService;
	
	private String code;

	@Override
	public ThinkUser getModel() {
		return thinkUser;
	}

	private ThinkUser thinkUser = new ThinkUser();

	public String login() {
		String confire = (String) ActionContext.getContext().getSession().get("code");
		System.out.println("con:"+confire);
		System.out.println("code:"+code);
		thinkUser = thinkUserService.checkThinkUser(thinkUser);
		Setting setting = settingService.queryById(2);
		if (confire.equals(code) &&  thinkUser != null) {
			ActionContext.getContext().getSession().put("admin", thinkUser);
			ActionContext.getContext().getSession().put("netName", setting);
			System.out.println("setting:"+setting);
			return "gotoIndex";
		}
		Map<String, Object> req = (Map<String, Object>) ActionContext.getContext().get("request");
		req.put("test", "1");
		return "gotoLogin";
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}

	public String code() {
		CodeUtil cu = CodeUtil.Instance();
		this.setInputStream(cu.getImage());
		ActionContext.getContext().getSession().put("code", cu.getString());
		return SUCCESS;
	}

	public ThinkUserService getThinkUserService() {
		return thinkUserService;
	}

	public void setThinkUserService(ThinkUserService thinkUserService) {
		this.thinkUserService = thinkUserService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public SettingService getSettingService() {
		return settingService;
	}

	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}
	
	

}
