package com.linestore.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

public class WxJsApiAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

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

	public String JsApiParams() throws WxErrorException {
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		// 微信测试账号
		config.setAppId("wx33584f71b4a84fa9"); // 设置微信公众号的appid
		config.setSecret("029b4c9b947564b763b0191445aabdca"); // 设置微信公众号的
																// appsecret
		config.setToken("wxdev"); // 设置微信公众号的token
		WxMpService wxService = new WxMpServiceImpl();
		wxService.setWxMpConfigStorage(config);
		wxService.getJsapiTicket(true);
		wxService.createJsapiSignature("");
		System.out.println(wxService.getJsapiTicket());
		
		return null;
	}

}
