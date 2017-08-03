package com.weixin.handler;

import java.util.Map;

import com.weixin.builder.TextBuilder;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class MsgHandler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		// TODO Auto-generated method stub

		// 关键字转发
		System.out.println("文字消息转发");
		// TODO 组装回复消息
		WxMpUser userWxInfo = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), null);
		
//		// 消息分析 
//		switch (wxMessage.getContent().equals("ddd")) {
//		case value:
//			
//			break;
//
//		default:
//			break;
//		}
		String content = userWxInfo.getNickname() + ":" + wxMessage.getContent();

		return new TextBuilder().build(content, wxMessage, wxMpService);
	}

}
