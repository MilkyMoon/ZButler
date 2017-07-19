package com.linestore.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.jasper.runtime.ProtectedFunctionMapper;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;

import com.linestore.WxUtils.JsonUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.weixin.handler.MsgHandler;
import com.weixin.handler.OAuth2Handler;
import com.weixin.handler.SubscribeHandler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpMassNews;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.builder.kefu.TextBuilder;

public class WxTestAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected WxMpMessageRouter wxMpMessageRouter;

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

	public void wxConfig() throws Exception {
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		// 众邦管理账号
//		config.setAppId("wx5b69c56ac01ed858"); // 设置微信公众号的appid
//		config.setSecret("4ad3ebbd02e8f82aede3a22d1a3335a6"); // 设置微信公众号的app appsecret
//		config.setToken("wxdev"); // 设置微信公众号的token
//		config.setAesKey("Cm4ntEWySoVGGA6aFGG8CeLzqVf4le9cif4BkW4GHaj"); // 设置微信公众号的EncodingAESKey
		// 微信测试账号
		config.setAppId("wx33584f71b4a84fa9"); // 设置微信公众号的appid
		config.setSecret("029b4c9b947564b763b0191445aabdca"); // 设置微信公众号的app appsecret
		config.setToken("wxdev"); // 设置微信公众号的token
		config.setOauth2redirectUri("http://2463335a.ngrok.io/ZButler/WxOauthRedirect!oauth.action");
		

		WxMpService wxService = new WxMpServiceImpl();
		wxService.setWxMpConfigStorage(config);
		
		// 消息路由 注意顺序
		wxMpMessageRouter = new WxMpMessageRouter(wxService);
		wxMpMessageRouter
		.rule()
		.async(false)
		.content("oauth")
		.handler(new OAuth2Handler())
		.end()
		.rule()
		.async(false)
		.msgType(WxConsts.CUSTOM_MSG_TEXT)
		.handler(new MsgHandler())
		.end()
		.rule()
		.async(false)
		.msgType(WxConsts.XML_MSG_EVENT)
		.event(WxConsts.EVT_SUBSCRIBE)
		.handler(new SubscribeHandler())
		.end()
		.rule()
		.async(false)
		.msgType(WxConsts.XML_MSG_EVENT)
		.event(WxConsts.EVT_UNSUBSCRIBE)
		.handler(new MsgHandler())
		.end();


		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		String signature = request.getParameter("signature");
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");
		
		if (!wxService.checkSignature(timestamp, nonce, signature)) {
			// 消息签名不正确，说明不是公众平台发过来的消息
			response.getWriter().println("非法请求");
			return;
		}

		String echoStr = request.getParameter("echostr");
		if (StringUtils.isNotBlank(echoStr)) {
			// 说明是一个仅仅用来验证的请求，回显echostr
			String echoStrOut = String.copyValueOf(echoStr.toCharArray());
			response.getWriter().println(echoStrOut);
			return;
		}

		String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ? "raw"
				: request.getParameter("encrypt_type");

		WxMpXmlMessage inMessage = null;

		if ("raw".equals(encryptType)) {
			// 明文传输的消息
			inMessage = WxMpXmlMessage.fromXml(request.getInputStream());

		} else if ("aes".equals(encryptType)) {
			// 是aes加密的消息
			String msgSignature = request.getParameter("msg_signature");
			inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), config, timestamp, nonce,
					msgSignature);
		} else {
			response.getWriter().println("不可识别的加密类型");
			return;
		}

		// 消息转发
		WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);

		if (outMessage != null) {
			if ("raw".equals(encryptType)) {
				response.getWriter().write(outMessage.toXml());
			} else if ("aes".equals(encryptType)) {
				response.getWriter().write(outMessage.toEncryptedXml(config));
			}
			return;
		}
		return;
	}
}
