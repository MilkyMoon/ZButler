package com.linestore.action;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.linestore.service.SiteConfigService;
import com.linestore.vo.SiteConfig;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SiteConfigAction extends ActionSupport
		implements ModelDriven<SiteConfig>, ServletRequestAware, ServletResponseAware {
	private SiteConfig siteConfig;
	private SiteConfigService siteConfigService;
	private HttpServletRequest Request;
	private HttpServletResponse Response;
	List<SiteConfig> noticelist = new ArrayList<SiteConfig>();
	Map<String, Object> request;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.Response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.Request = request;

	}

	@Override
	public SiteConfig getModel() {
		// TODO Auto-generated method stub
		if (siteConfig == null) {
			return siteConfig = new SiteConfig();
		}
		return siteConfig;
	}

	// 查找客户中心所有文案配置
	public String selectCustoemrConfig() {

		List<SiteConfig> list = siteConfigService.selectCusConfig("cus_config");
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", list);
		return "CustConfig";

	}

	// 广告位
	public String SelectCustAdv() {
		// 左侧位置
		List<SiteConfig> leftAdvConfigs = siteConfigService.selectCusConfig("shop_adv_left");
		// 右上
		List<SiteConfig> rightTopAdvConfigs = siteConfigService.selectCusConfig("shop_adv_rtop");
		// 右下
		List<SiteConfig> rightBottomConfigs = siteConfigService.selectCusConfig("shop_adv_rbottom");

		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("leftAdvConfigs", leftAdvConfigs);
		request.put("rightTopAdvConfigs", rightTopAdvConfigs);
		request.put("rightBottomConfigs", rightBottomConfigs);

		return "selectAll";

	}

	public String displayAddUrl() {
		return "AddFriendUrl";
	}

	// 获取友情链接
	public String SelectFriendUrl() {
		List<SiteConfig> friendSiteConfigs = siteConfigService.selectCusConfig("friend_url");
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", friendSiteConfigs);
		return "SelectUrl";
	}

	public String addFriendUrl() {
		siteConfigService.addCusConfig(siteConfig);
		return "selectFriendUrl";
	}
	

	public String delFriendUrl() {
		siteConfigService.delCusConfig(siteConfig.getId());
		return "selectFriendUrl";
	}

	// 获取所有banner
	public String selectBannerString() {
		List<SiteConfig> bannerSiteConfigs = siteConfigService.selectCusConfig("banner");
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", bannerSiteConfigs);
		return "SelectBanner";
	}

	public String addBanner() {
		siteConfigService.addCusConfig(siteConfig);
		return "selectBanner";
	}

	public String delBanner() {
		siteConfigService.delCusConfig(siteConfig.getId());
		return "selectBanner";
	}

	// 分类广告保存
	public String save() {
		this.UtillsSave();
		return "SUCCESS";
	}

	// 客户端站点配置保存
	public String saveCusConfig() {
		this.UtillsSave();
		return "saveCusConfig";
	}

	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}

	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}

	public void UtillsSave() {
		String[] configValues = Request.getParameterValues("configValue");
		String[] configIds = Request.getParameterValues("Sid");
		String[] configKeys = Request.getParameterValues("configKey");
		String[] configNames = Request.getParameterValues("configName");
		for (int i = 0; i < configNames.length; i++) {
			SiteConfig siteConfig = new SiteConfig();
			siteConfig.setId(Integer.parseInt(configIds[i]));
			siteConfig.setConfigName(configNames[i]);
			siteConfig.setConfigKey(configKeys[i]);
			siteConfig.setConfigValue(configValues[i]);
			System.out.println(configValues[i]);
			siteConfigService.updateCusConfig(siteConfig);
		}
	}

}
