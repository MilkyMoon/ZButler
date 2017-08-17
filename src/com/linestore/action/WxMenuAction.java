package com.linestore.action;

import java.awt.Menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
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
//		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//				+ request.getContextPath() + "/";
		String basePath = "http://www.codwiki.cn/ZButler/";
		WxMenu menu = new WxMenu();
		WxMenuButton shopButton = new WxMenuButton();
		shopButton.setName("商城");
		WxMenuButton offlineButton = new WxMenuButton();
		offlineButton.setType(WxConsts.BUTTON_VIEW);
		offlineButton.setName("线下商城");
		offlineButton.setUrl(basePath+"offlineStore!offline");
		
		WxMenuButton onlineButton = new WxMenuButton();
		onlineButton.setType(WxConsts.BUTTON_CLICK);
		onlineButton.setName("线上商城");
		onlineButton.setKey("loadding");		
		shopButton.getSubButtons().add(onlineButton);
		shopButton.getSubButtons().add(offlineButton);
		menu.getButtons().add(shopButton);
		
		
		WxMenuButton merchant = new WxMenuButton();
		merchant.setName("商城入驻");
		
		WxMenuButton merchat1 = new WxMenuButton();
		merchat1.setName("商城入驻");
		merchat1.setType(WxConsts.BUTTON_VIEW);
		merchat1.setUrl(basePath+"cateLine_queryRoot");
		WxMenuButton merchat2 = new WxMenuButton();
		merchat2.setName("我的店铺");
		merchat2.setType(WxConsts.BUTTON_VIEW);
		merchat2.setUrl(basePath+"business_store.action");
		WxMenuButton merchat3 = new WxMenuButton();
		merchat3.setName("店铺收款");
		merchat3.setType(WxConsts.BUTTON_VIEW);
		merchat3.setUrl(basePath+"home/storeReceipts.jsp");
		
		merchant.getSubButtons().add(merchat1);
		merchant.getSubButtons().add(merchat2);
		merchant.getSubButtons().add(merchat3);
		menu.getButtons().add(merchant);
		
		WxMenuButton personalButton = new WxMenuButton();
		personalButton.setName("个人中心");
		personalButton.setType(WxConsts.BUTTON_VIEW);
		personalButton.setUrl(basePath+"home/customer.jsp");
		
		menu.getButtons().add(personalButton);
		System.out.println(menu.toString());
		this.wxService.getMenuService().menuCreate(menu);

	}

}
