package com.linestore.action;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withUnauthorizedRequest;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linestore.service.BusTradingService;
import com.linestore.service.BusinessService;
import com.linestore.service.CateLineService;
import com.linestore.service.PicturesService;
import com.linestore.service.SiteConfigService;
import com.linestore.vo.Business;
import com.linestore.vo.CateLine;
import com.linestore.vo.SiteConfig;
import com.linestore.vo.Catetory;
import com.linestore.vo.Pictures;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OfflineStoreAction extends ActionSupport implements ModelDriven<Business> {
	
	private Business business;
	
	private Map<String, Object> request;
	
	private String city = "北京";
	
	private String seach;
	
	private int busId;
	
	private int cate;
	
	private int child = -1;
	
	private PicturesService picturesService;
	
	private BusinessService businessService;
	
	private BusTradingService busTradingService;
	
	private CateLineService cateLineService;
	
	private SiteConfigService siteConfigService;

	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}

	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}

	@Override
	public Business getModel() {
		return business;
	}
	
	public String offline() {
		//System.out.println("offline");
//		List list = busTradingService.queryHot();
//		List<Business> buss = new ArrayList<Business>();
//		for (int i = 0; i < list.size(); i++) {
//			Object[] arr = (Object[]) list.get(i);
//			//System.out.println(arr[0]);
//			buss.add(businessService.select(Integer.valueOf(arr[1].toString())));
//		}
		ActionContext.getContext().getSession().put("buss", businessService.queryByCity(city, 0));
		List<CateLine> cates = cateLineService.selectEight(0);
		ActionContext.getContext().getSession().put("city", city);
		//System.out.println(cates.size());
		ActionContext.getContext().getSession().put("cateLins", cates);
		List<SiteConfig> siteConfigs = siteConfigService.selectCusConfig("banner");
		ActionContext.getContext().getSession().put("banner", siteConfigs);
		List<SiteConfig> leftAdvConfigs = siteConfigService.selectCusConfig("shop_adv_left");
		List<String> la= new ArrayList<String>();
		for (SiteConfig siteConfig : leftAdvConfigs) {
			System.out.println(siteConfig.getConfigValue());
			la.add(siteConfig.getConfigValue());
		}
		ActionContext.getContext().getSession().put("leftAdvConfigs", la);
		// 右上
		List<SiteConfig> rightTopAdvConfigs = siteConfigService.selectCusConfig("shop_adv_rtop");
		List<String> rt= new ArrayList<String>();
		for (SiteConfig siteConfig : rightTopAdvConfigs) {
			rt.add(siteConfig.getConfigValue());
		}
		ActionContext.getContext().getSession().put("rightTopAdvConfigs", rt);
		// 右下
		List<SiteConfig> rightBottomConfigs = siteConfigService.selectCusConfig("shop_adv_rbottom");
		
		List<String> rb= new ArrayList<String>();
		for (SiteConfig siteConfig : rightTopAdvConfigs) {
			rb.add(siteConfig.getConfigValue());
		}
		ActionContext.getContext().getSession().put("rightBottomConfigs", rb);

	
		
		// 左侧 右侧 下面 
		
		return "gotoOfflineStore";
		
	}
	
	public String queryBusines() {
		Business bus = businessService.select(busId);
		List<Pictures> pics = picturesService.queryByOtherId(busId);
		System.out.println("+++++-------------->" + pics.size());
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("business", bus);
		List list = busTradingService.queryHot(city);
		List<Business> buss = new ArrayList<Business>();
		for (int i = 0; i < list.size(); i++) {
			Object[] arr = (Object[]) list.get(i);
			//System.out.println(arr[0]);
			buss.add(businessService.select(Integer.valueOf(arr[1].toString())));
		}
		request.put("pics", pics);
		request.put("hots", buss);
		return "gotoBusiness";
	}
	
	public String queryCate() {
		List<CateLine> cates = cateLineService.selectChildren(cate);
		List<CateLine> cateLines = cateLineService.selectChildren(0);
		List<CateLine> cateLine = cateLineService.selectChildren(cateLines.get(0).getCalId());
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("cate", cate);
		request.put("cates", cates);
		request.put("cateLines", cateLines);
		request.put("cateLine", cateLine);
		List<Business> buss = null;
		String city = (String) ActionContext.getContext().getSession().get("city");
		if (child == -1) {
			buss = businessService.queryCate(city, cate);
			CateLine cal =cateLineService.selectById(cate);
			if (cal != null) {
				request.put("name", cal.getCalName());
			}
		} else {
			buss = businessService.querySmall(city, child);
			for (int i =0; i < cates.size(); i++) {
				if (child == cates.get(i).getCalId()) {
					request.put("name", cates.get(i).getCalName());
					break;
				}
			}
		}
		request.put("child", child);
		request.put("buss", buss);
		return "gotoStoreCate";
	}
	
	public String seach() {
		System.out.println(city);
		System.out.println(seach);
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		CateLine cate = cateLineService.queryByName(seach);
		System.out.println("------");
		if (cate != null) {
			List<Business> buss = businessService.queryByCate(cate.getCalId(), city);
			System.out.println("cateSeach:" + buss);
			request.put("cateSeach", buss);
		}
		System.out.println("------");
		List<Business> bus = businessService.queryByShopName(seach, city);
		System.out.println(bus);
		System.out.println("buss:" + bus);
		request.put("buss", bus);
		return "gotoSeach";
	}


	public BusinessService getBusinessService() {
		return businessService;
	}


	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}


	public BusTradingService getBusTradingService() {
		return busTradingService;
	}


	public void setBusTradingService(BusTradingService busTradingService) {
		this.busTradingService = busTradingService;
	}


	public CateLineService getCateLineService() {
		return cateLineService;
	}


	public void setCateLineService(CateLineService cateLineService) {
		this.cateLineService = cateLineService;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getSeach() {
		return seach;
	}

	public void setSeach(String seach) {
		this.seach = seach;
	}

	public int getCate() {
		return cate;
	}

	public void setCate(int cate) {
		this.cate = cate;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public PicturesService getPicturesService() {
		return picturesService;
	}

	public void setPicturesService(PicturesService picturesService) {
		this.picturesService = picturesService;
	}
	
	
}
