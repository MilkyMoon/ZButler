package com.linestore.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import net.sf.json.JSONObject;

public class WxJsApiAction extends WeXinConfigAction implements ServletRequestAware, ServletResponseAware {
	private HttpServletResponse response;
	private String result;
	private HttpServletRequest request;

	public WxJsApiAction() {
		super();
		// TODO Auto-generated constructor stub
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

	public String JsApiParams() throws WxErrorException {
		this.wxService.getJsapiTicket(true);
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		String URL = request.getParameter("url");
		WxJsapiSignature signature = this.wxService.createJsapiSignature(URL);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("signature", signature.getSignature());
		map.put("nonceStr", signature.getNonceStr());
		map.put("timestamp", signature.getTimestamp());
		map.put("appId", signature.getAppId());
		this.result = JSONObject.fromObject(map).toString();
		System.out.println(this.result);
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
