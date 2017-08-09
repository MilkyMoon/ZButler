package com.linestore.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.linestore.service.SiteConfigService;
import com.linestore.vo.SiteConfig;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SiteConfigAction extends ActionSupport implements ModelDriven<SiteConfig> {
	private SiteConfig siteConfig;
	private SiteConfigService siteConfigService;
	List<SiteConfig> noticelist = new ArrayList<SiteConfig>();
	Map<String, Object> request;

	@Override
	public SiteConfig getModel() {
		// TODO Auto-generated method stub
		if (siteConfig == null) {
			return siteConfig = new SiteConfig();
		}
		return siteConfig;
	}

	// 查找客户中心所有文案配置
	public void initCustoemr() {
		Iterator<SiteConfig> iterator = siteConfigService.selectCusConfig("cus_config").iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next().getConfigKey()+iterator.next().getConfigValue());
		}

	}

	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}

	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
}
