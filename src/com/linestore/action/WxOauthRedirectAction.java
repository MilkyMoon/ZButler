package com.linestore.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import net.sf.json.JSONObject;

public class WxOauthRedirectAction extends WeXinConfigAction implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;

	private String result;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	public WxOauthRedirectAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;

	}

	public String WeXinLogin() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LoginUrl",
				this.wxService.oauth2buildAuthorizationUrl(this.wxService.getWxMpConfigStorage().getOauth2redirectUri(),
						WxConsts.OAUTH2_SCOPE_USER_INFO, "login"));
		this.result = JSONObject.fromObject(map).toString();
		return SUCCESS;
	}

	public void IntoPayPage() throws IOException {
		// 获取商户id
		// 微信授权
		String oauthUrl = this.wxService.oauth2buildAuthorizationUrl(
				this.wxService.getWxMpConfigStorage().getOauth2redirectUri(), WxConsts.OAUTH2_SCOPE_BASE, "pay");
		response.sendRedirect(oauthUrl);
	}

	public void IntoRechage() throws IOException {
		// 微信授权
		String oauthUrl = this.wxService.oauth2buildAuthorizationUrl(
				this.wxService.getWxMpConfigStorage().getOauth2redirectUri(), WxConsts.OAUTH2_SCOPE_BASE, "reChage");
		response.sendRedirect(oauthUrl);
	}
	
	public String bindWeChat() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LoginUrl",
				this.wxService.oauth2buildAuthorizationUrl(this.wxService.getWxMpConfigStorage().getOauth2redirectUri(),
						WxConsts.OAUTH2_SCOPE_USER_INFO, "bindWeChat"));
		this.result = JSONObject.fromObject(map).toString();
		return SUCCESS;
	}

	// 所有网页授权回调地址
	public String oauth() throws WxErrorException {
		// 获取state值 业务跳转
		String returnString;
		String state = request.getParameter("state");
		WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(request.getParameter("code"));

		switch (state) {
		case "login":
			// 获取用户信息
			WxMpUser wxMpUser = this.wxService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);

			// Session 存储
			Customer customer = new Customer();
			customer.setCusSex(wxMpUser.getSexId());
			customer.setCusImgUrl(wxMpUser.getHeadImgUrl());
			customer.setCusNickname(wxMpUser.getNickname());
			customer.setCusOpenId(wxMpUser.getOpenId());
			ActionContext.getContext().getSession().put("weChat", customer);
			returnString = "gotoWeChat";
			break;
		case "pay":
			ActionContext.getContext().getSession().put("SCOPE_BASE_OPENID", wxMpOAuth2AccessToken.getOpenId());
			returnString = "gotoPay";
			break;
		case "reChage":
			ActionContext.getContext().getSession().put("SCOPE_BASE_OPENID", wxMpOAuth2AccessToken.getOpenId());
			returnString = "gotoRecharge";
			break;
		case "bindWeChat":
			WxMpUser wxMpUserBind = this.wxService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
			ActionContext.getContext().getSession().put("openId", wxMpUserBind.getOpenId());
			ActionContext.getContext().getSession().put("Bind", "cusOpenId");
			returnString = "gotoBind";
			break;
		default:
			returnString = "gotoPay";
			break;
		}
		// 刷新access_token
		wxMpOAuth2AccessToken = this.wxService.oauth2refreshAccessToken(wxMpOAuth2AccessToken.getRefreshToken());
		System.out.println("跳转至" + returnString);
		return returnString;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
