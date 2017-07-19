package com.linestore.util;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 阿里大于短信验证
 * @author mac
 *
 */

public class SendMessage {
	
	private static TaobaoClient client = 
			new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23705107", "314ab013d639b67cd218e3c7d8d75281");
	
	private static AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
	
	private static AlibabaAliqinFcSmsNumSendResponse rsp;
	
	public static void send(String code, String phone) {
		req.setExtend("");
		req.setSmsType("normal");
		req.setSmsFreeSignName("众邦管理");
		req.setSmsParamString("{\"code\":\""+ code +"\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_77505054");
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());
	}
	

}
