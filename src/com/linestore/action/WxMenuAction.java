package com.linestore.action;

import java.awt.Menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;

public class WxMenuAction extends WeXinConfigAction implements ServletRequestAware, ServletResponseAware {

	private HttpServletResponse response;
	private HttpServletRequest request;

	public WxMenuAction() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;

	}

	public void createMenu() throws WxErrorException {
		System.out.println(request.getRemoteHost());
		WxMenu menu = new WxMenu();
		WxMenuButton shopButton = new WxMenuButton();
		shopButton.setName("商城");
		WxMenuButton offlineButton = new WxMenuButton();
		offlineButton.setType(WxConsts.BUTTON_VIEW);
		offlineButton.setName("线下商城");
		offlineButton.setUrl("http://yanglan520.com/ZButler/offlineStore!offline");
		shopButton.getSubButtons().add(offlineButton);
		WxMenuButton personalButton = new WxMenuButton();
		personalButton.setName("个人中心");
		personalButton.setType(WxConsts.BUTTON_VIEW);
		personalButton.setUrl("http://yanglan520.com/ZButler/home/customer.jsp");
		menu.getButtons().add(shopButton);
		menu.getButtons().add(personalButton);
		System.out.println(menu.toString());
		this.wxService.getMenuService().menuCreate(menu);

	}

}
