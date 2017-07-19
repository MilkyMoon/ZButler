package com.weixin.handler;

import java.util.Map;

import com.weixin.builder.TextBuilder;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

public class OAuth2Handler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		// TODO Auto-generated method stub
		String content = "<a href=\""
				+ wxMpService.oauth2buildAuthorizationUrl(wxMpService.getWxMpConfigStorage().getOauth2redirectUri(),
						WxConsts.OAUTH2_SCOPE_USER_INFO, null)
				+ "\">Ouath</a>";

		return new TextBuilder().build(content, wxMessage, wxMpService);
	}

}
