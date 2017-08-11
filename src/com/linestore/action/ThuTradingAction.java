package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.github.binarywang.wxpay.bean.request.WxEntPayRequest;
import com.linestore.service.AreaService;
import com.linestore.service.ThinkUserService;
import com.linestore.service.ThuTradingService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.Area;
import com.linestore.vo.ThinkUser;
import com.linestore.vo.ThuTrading;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ThuTradingAction extends ActionSupport implements ModelDriven<ThuTrading>{
	private ThuTrading thuTrading = new ThuTrading();
	private ThuTradingService thuTradingService;
	private ThinkUserService thinkUserService;
	private AreaService areaService;
	private ThinkUser think = new ThinkUser();
	private Area area = new  Area();
	private ThuTrading thuTradingResule;
	private Area areaReaslut;
	
	Map<String, Object> request;
	private List<ThuTrading> thuTradingList = new ArrayList<ThuTrading>();
	private List<ThinkUser> thinkUser = new ArrayList<ThinkUser>();
	private List<Area> areaList = new ArrayList<Area>();
	private List<String> lastList = new ArrayList<>();
	
	
	
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";
	private Float money=(float) 0;

	@Override
	public ThuTrading getModel() {
		// TODO Auto-generated method stub
		return thuTrading;
	}

	public void setThuTrading(ThuTrading thuTrading) {
		this.thuTrading = thuTrading;
	}
	
	public String selectAll(){
		int totalCount = thuTradingService.selectCount();
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Integer.parseInt(everyPage)))){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		
		thuTradingList = thuTradingService.select(page);
		
		for(int i = 0; i < thuTradingList.size(); i++ ){
			thinkUser.add(thinkUserService.queryById(thuTradingList.get(i).getThuId()));
			areaList.add(areaService.queryById(thuTradingList.get(i).getAreId()));
		}
		
		ActionContext.getContext().getSession().put("thinklist", thinkUser);
		ActionContext.getContext().getSession().put("arealist", areaList);
		ActionContext.getContext().getSession().put("list", thuTradingList);
		ActionContext.getContext().getSession().put("page", page);
		
		return "selectAll";
	}
	
	public String select(){
		if(keywords.equals("") || keywords == null){
			return "select";
		}
		
		thinkUser = thinkUserService.selectAllByKey(keywords);
		areaList = areaService.selectByKey(keywords);
		
		List<ThinkUser> thinkList = new ArrayList<ThinkUser>();
		List<Area> areaListTwo = new ArrayList<Area>();
		
		Integer thuList[] = new Integer[thinkUser.size()];
		Integer areList[] = new Integer[areaList.size()];
		
		for(int i = 0; i < thinkUser.size(); i++){
			thuList[i] = thinkUser.get(i).getThuId();
		}
		
		for(int j = 0; j < areaList.size(); j++){
			areList[j] = areaList.get(j).getAreId();
		}
		
		Page page = null;
		
		if(thinkUser.size() < 1 && areaList.size() < 1){
			thuTradingList = null;
		}
		
		if(thinkUser.size() < 1 && areaList.size() > 0){
			int totalCount = thuTradingService.selectByKeyCountToAre(areList);
			if(everyPage.equals("") || everyPage == null){
				everyPage = "10";
			}
			if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Integer.parseInt(everyPage)))){
				pageNow = "1";
			}
			page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
			
			thuTradingList = thuTradingService.selectByKeytoAre(page, areList);
			
		}
		
		if(thinkUser.size() > 0 && areaList.size() < 1){
			int totalCount = thuTradingService.selectByKeyCountToThu(thuList);
			if(everyPage.equals("") || everyPage == null){
				everyPage = "10";
			}
			if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Integer.parseInt(everyPage)))){
				pageNow = "1";
			}
			page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
			
			thuTradingList = thuTradingService.selectByKeytoThu(page, thuList);
		}
		
		if(thinkUser.size() > 0 && areaList.size() > 0){
			int totalCount = thuTradingService.selectByKeyCount(thuList, areList);
			if(everyPage.equals("") || everyPage == null){
				everyPage = "10";
			}
			if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Integer.parseInt(everyPage)))){
				pageNow = "1";
			}
			page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
			
			thuTradingList = thuTradingService.selectByKey(page, thuList, areList);
		}
		
		for(int i = 0; i < thuTradingList.size(); i++){
			thinkList.add(thinkUserService.queryById(thuTradingList.get(i).getThuId()));
			areaListTwo.add(areaService.queryById(thuTradingList.get(i).getThuId()));
		}
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("thinklist", thinkList);
		request.put("arealist", areaListTwo);
		request.put("list", thuTradingList);
		request.put("page", page);
		
		return "selectAll";
	}
	
	public String add(){
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = String.valueOf((new Date()).getTime());// new Date()为获取当前系统时间，也可使用当前时间戳
		
		int max=9999;
        int min=1000;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        
        String thtId = date + s;
        System.out.println(date);
        System.out.println(s);
        System.out.println(thtId);
        
        getId();
		
		thuTrading.setAreId(think.getArea().getAreId());
		thuTrading.setThuId(think.getThuId());
		thuTrading.setThtId(thtId);
		thuTrading.setThtTime(new Timestamp(new Date().getTime()));
		thuTrading.setThtStatus(0);
		thuTrading.setThuMoney(money);
		
		//修改area表中的值
		area = areaService.queryById(think.getArea().getAreId());
		BigDecimal b1 = new BigDecimal(Float.toString(thuTrading.getThuMoney()));
		area.setAreaTotalMoney(area.getAreaTotalMoney().subtract(b1));
		areaService.updateArea(area);
		
		//添加账单到数据库
		thuTradingService.save(thuTrading);
			
		return "add";
	}
	
	public String status(){
		if(thuTrading.getThtStatus() == 2){
			//将提现金额还原回去
			
			thuTradingResule = thuTradingService.selectById(thuTrading.getThtId());
			
			areaReaslut = areaService.queryById(thuTradingResule.getAreId());
			areaReaslut.setAreaTotalMoney(areaReaslut.getAreaTotalMoney().add(new BigDecimal(Float.toString(thuTradingResule.getThuMoney()))));
			
			areaService.updateArea(areaReaslut);
			
			//将订单状态值更新
			String hql;
			try {
				hql = ReturnUpdateHql.ReturnHql(thuTrading.getClass(), thuTrading, thuTrading.getThtId());
				// System.out.println(business.getBusStatus());
				thuTradingService.update(hql);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "select";
		}
		
		if(thuTrading.getThtStatus() == 1){
			thuTradingResule = thuTradingService.selectById(thuTrading.getThtId());
			think = thinkUserService.queryById(thuTradingResule.getThuId());

			String openid = think.getThuOpenid();
			if(openid == null || openid.equals("")){
				return "select";
			}
			
			//修改状态值
			thuTradingResule.setThtStatus(1);
			
			WxEntPayRequest wxEntPayRequest = new WxEntPayRequest();
			wxEntPayRequest.setAmount(wxEntPayRequest.yuanToFee(thuTradingResule.getThuMoney().toString()));
			wxEntPayRequest.setDescription("代理提现");
			wxEntPayRequest.setOpenid(openid);
			wxEntPayRequest.setPartnerTradeNo(thuTradingResule.getThtId().toString());
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("wxEntPayRequest", wxEntPayRequest);
			request.put("thuTrading", thuTradingResule);
			// 写session 
			return "gotoPostalThu";
			// 数据更新
			
		}
		
		return "select";
	}
	
	public void getId(){
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
	}

	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}

	public String getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(String everyPage) {
		this.everyPage = everyPage;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public ThuTradingService getThuTradingService() {
		return thuTradingService;
	}

	public void setThuTradingService(ThuTradingService thuTradingService) {
		this.thuTradingService = thuTradingService;
	}

	public ThinkUserService getThinkUserService() {
		return thinkUserService;
	}

	public void setThinkUserService(ThinkUserService thinkUserService) {
		this.thinkUserService = thinkUserService;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public void setThink(ThinkUser think) {
		this.think = think;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public ThuTrading getThuTrading() {
		return thuTrading;
	}
}
