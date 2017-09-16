package com.linestore.action;

import org.apache.struts2.ServletActionContext;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.google.common.reflect.ClassPath;
import com.opensymphony.xwork2.ActionSupport;

public class WeiXinPayConfigAction extends ActionSupport {
	protected WxPayService wxPayService;
	protected WxPayConfig payConfig;
//	protected final String BASE_PATH = "http://www.codwiki.cn/ZButler/";
	protected final String BASE_PATH = "http://yanglan520.com/ZButler/";

	public WeiXinPayConfigAction() {
		super();
		// TODO Auto-generated constructor stub
		payConfig = new WxPayConfig();
		payConfig.setAppId("wx5b69c56ac01ed858");
		payConfig.setMchId("1462547202");
		payConfig.setMchKey("OGL9fvig9y2HrXrQ86tM4jTwyv4ja6G5");
		payConfig.setKeyPath("classpath:/apiclient_cert.p12");
		this.wxPayService = new WxPayServiceImpl();
		wxPayService.setConfig(payConfig);
	}

}