package com.weixin.handler;

import java.util.Map;

import com.weixin.builder.TextBuilder;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class SubscribeHandler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		// TODO Auto-generated method stub

		// 获取用户信息
		WxMpUser userInfo = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), null);
		System.out.println("关注事件");
		if (userInfo != null) {
			System.out.println("关注事件");
			System.out.println(userInfo.toString());
		}

		// 关注回复
		try {

			System.out.println("关注事件");
			return new TextBuilder().build("感谢关注", wxMessage, wxMpService);
		} catch (Exception e) {
			// TODO: handle exception
			this.logger.error(e.getMessage(), e);
		}

		return null;
	}

	private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) throws Exception {
		return null;

	}

}
