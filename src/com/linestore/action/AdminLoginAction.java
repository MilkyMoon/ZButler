package com.linestore.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.ThinkUserService;
import com.linestore.util.CodeUtil;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminLoginAction extends ActionSupport implements ModelDriven<ThinkUser> {

	private ThinkUserService thinkUserService;
	
	private ByteArrayInputStream inputStream; 
	
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
		if (confire.equals(code) &&  thinkUser != null) {
			ActionContext.getContext().getSession().put("admin", thinkUser);
			return "gotoIndex";
		}
		ActionContext.getContext().getSession().put("test", "1");
		return "gotoLogin";
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
	
	

}
