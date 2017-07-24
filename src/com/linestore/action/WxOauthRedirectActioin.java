package com.linestore.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
//import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.opensymphony.xwork2.ActionSupport;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import net.sf.json.JSONObject;

public class WxOauthRedirectActioin extends WeXinConfigAction implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;

	private String result;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	public WxOauthRedirectActioin() {
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
		map.put("LoginUrl", this.wxService.oauth2buildAuthorizationUrl(
				this.wxService.getWxMpConfigStorage().getOauth2redirectUri(), WxConsts.OAUTH2_SCOPE_USER_INFO, null));
		this.result = JSONObject.fromObject(map).toString();
		return SUCCESS;
	}

	public void oauth() throws WxErrorException {
		WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(request.getParameter("code"));
		// 获取用户信息
		WxMpUser wxMpUser = this.wxService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
		// 区别登陆或者绑定
		wxMpOAuth2AccessToken = this.wxService.oauth2refreshAccessToken(wxMpOAuth2AccessToken.getRefreshToken());
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
