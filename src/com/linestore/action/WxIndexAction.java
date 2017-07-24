package com.linestore.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

//import org.apache.jasper.runtime.ProtectedFunctionMapper;
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

public class WxIndexAction extends WeXinConfigAction implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected WxMpMessageRouter wxMpMessageRouter;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	public WxIndexAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;

	}

	public void wxConfig() throws Exception {

		// 消息路由 注意顺序
		wxMpMessageRouter = new WxMpMessageRouter(this.wxService);
		wxMpMessageRouter.rule().async(false).content("oauth").handler(new OAuth2Handler()).end().rule().async(false)
				.msgType(WxConsts.CUSTOM_MSG_TEXT).handler(new MsgHandler()).end().rule().async(false)
				.msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_SUBSCRIBE).handler(new SubscribeHandler()).end()
				.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_UNSUBSCRIBE)
				.handler(new MsgHandler()).end();

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		String signature = request.getParameter("signature");
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");

		if (!this.wxService.checkSignature(timestamp, nonce, signature)) {
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
