package com.weixin.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

public class TextBuilder extends AbstractBuilder{

	@Override
	public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, WxMpService wxMpService) {
		// TODO Auto-generated method stub
		return WxMpXmlOutMessage
				.TEXT()
				.content(content)
				.fromUser(wxMessage.getToUser())
				.toUser(wxMessage.getFromUser())
				.build();
	}

}
