package com.linestore.action;

import com.opensymphony.xwork2.ActionSupport;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

public class WeXinConfigAction extends ActionSupport {

	protected WxMpService wxService;
	protected WxMpInMemoryConfigStorage config;

	public WeXinConfigAction() {
		super();
		// TODO Auto-generated constructor stub
		config = new WxMpInMemoryConfigStorage();
		config.setAppId("wx5b69c56ac01ed858"); // 设置微信公众号的appid
		config.setSecret("4ad3ebbd02e8f82aede3a22d1a3335a6"); // 设置微信公众号的
																// appsecret
		config.setOauth2redirectUri("http://yanglan520.com/ZButler/WxOauthRedirect!oauth.action");
		config.setToken("wxdev"); // 设置微信公众号的token
		this.wxService = new WxMpServiceImpl();
		wxService.setWxMpConfigStorage(config);
	}

}
