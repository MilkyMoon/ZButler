package com.linestore.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.BillService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Area;
import com.linestore.vo.Bill;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class BillAction extends ActionSupport implements ModelDriven<Bill>{
	Map<String, Object> request;
	private Bill bill = new Bill();
	private BillService billService;
	private List<Bill> billList;
	ThinkUser think;
	private Bill billResult;
	
//	private static final long serialVersionUID = -5452039838295753607L;
	private String data;
	private static final long serialVersionUID = 1L;
    //此变量必须有setter与getter方法
    private String result;
    
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";
	private String tranTime;
	private String startTime;
	private String endTime;
	private Float amountMin;
	private Float amountMax;

	private Integer thuId;
	@Override
	public Bill getModel() {
		// TODO Auto-generated method stub
		return bill;
	}
	
	public String select(){
		getId();

		String[] sTime=tranTime.split(" - ");
		
		String[] sTimeLeft = sTime[0].split("/");
		String[] sTimeRigh = sTime[1].split("/");
		
		String timeMin = sTimeLeft[2] + "-" + sTimeLeft[0] + "-" + sTimeLeft[1];
		String timeMax = sTimeRigh[2] + "-" + sTimeRigh[0] + "-" + (Integer.parseInt(sTimeRigh[1])+1);
		
		System.out.println(timeMin);
		System.out.println(timeMax);
		System.out.println("amountMax:"+amountMax);
		String hql;
		
		if(think.getArea().getPid() == 0){
			hql = "select count(*) from Bill where bilDate >= '"+timeMin+"' and bilDate <= '"+timeMax+"' and bilCusMoney <= "+amountMax+" and bilCusMoney >= "+amountMin;
		} else {
			hql = "from Bill where (thinkUserByThuPropertyId.thuId = "+thuId+" or thinkUserByThuCityId.thuId = "+thuId+" or thinkUserByThuProvinceId.thuId = "+thuId+") and bilDate >= '"+timeMin+"' and bilDate <= '"+timeMax+"' and bilCusMoney >= "+amountMin+" and bilCusMoney <= "+amountMax;
		}
		
		System.out.println(hql);

		int totalCount = billService.queryAll(hql);
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Integer.parseInt(everyPage)))){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		
		if(think.getArea().getPid() == 0){
			billList =  billService.selectAllByTime(page,timeMin,timeMax,amountMin,amountMax);
		} else {
			billList =  billService.selectByTime(page,thuId,timeMin,timeMax,amountMin,amountMax);
		}
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", billList);
		request.put("page", page);
		
		request.put("tranTime", tranTime);
		request.put("amountMin", amountMin);
		request.put("amountMax", amountMax);
		
		return "selectAll";
		
	}
	
	public String selectAll(){
		getId();
		String hql ="select count(*) from Bill";
		int totalCount = billService.queryAll(hql);
		if(everyPage.equals("") || everyPage == null){
			everyPage = "10";
		}
		if(pageNow.equals("") || pageNow == null){
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		
		if(think.getArea().getPid() == 0){
			billList =  billService.selectAll(page);
		} else {
			billList =  billService.select(page,thuId);
		}
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", billList);
		request.put("page", page);
		
		return "selectAll";
	}
	
	public Integer getId(){
		think = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		thuId = think.getArea().getAreId();
		return thuId;
	}
	
	public String chinaMap(){
		data = billService.mkData();
		return "map";
	}
	
	public String mapInfo(){
		try {
            //获取数据
			HttpServletRequest req = ServletActionContext.getRequest();
			req.setCharacterEncoding("utf-8");
        	String name = req.getParameter("userName");
            String pass = req.getParameter("passWord");
            
            System.out.println(name);
            //将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name", name);
            map.put("pass","哈哈哈哈哈");
             
            JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据

            this.result = json.toString();//给result赋值，传递给页面
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
	}
	
	public String read(){
		selectById();
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots",billResult);
		return "read";
	}
	
	public String search(){
		if(keywords.equals("") || keywords == null){
			return "select";
		}
		billList = billService.search(keywords);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots",billList);
		
		return "selectAll";
	}
	
	public String report() {
		BigDecimal day = new BigDecimal(0);
		BigDecimal month = new BigDecimal(0);
		BigDecimal year = new BigDecimal(0);
		ThinkUser thu = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		Area area = thu.getArea();
		if (area.getAreId() == 1) {
			day = billService.todayMoney();
			month = billService.monthMoney();
			year = billService.yearMoney();
		}
		List<Bill> bills = billService.queryByArea(area.getAreId());
		int type = -1;
		if (bills.size() > 0 ) {
			if ((int)area.getAreId() == (int)bills.get(0).getAreaByThuCityId().getAreId()) {
				type = 0;
			} else if((int)area.getAreId() == (int)bills.get(0).getAreaByThuCountyId().getAreId()) {
				type = 1;
			} else if ((int)area.getAreId() == (int)bills.get(0).getAreaByThuPropertyId().getAreId()) {
				type = 2;
			} else if ((int)area.getAreId() == (int)bills.get(0).getAreaByThuProvinceId().getAreId()) {
				type = 3;
			} else {
				System.out.println("找不到");
			}
		}
		System.out.println("type:" + type);
		for (int i = 0; i < bills.size(); i++) {
			Date date = bills.get(i).getBilDate();
			switch (type) {
			case 0:
				if (isToday(date)) {
					day = day.add(bills.get(i).getBilCityMoney());
				}
				if (isCurrMonth(date)) {
					month = month.add(bills.get(i).getBilCityMoney());
				}
				if (isCurrYear(date)) {
					year = year.add(bills.get(i).getBilCityMoney());
				}
				break;
			case 1:
				if (isToday(date)) {
					day = day.add(bills.get(i).getBilCountyMoney());
				}
				if (isCurrMonth(date)) {
					month = month.add(bills.get(i).getBilCountyMoney());
				}
				if (isCurrYear(date)) {
					year = year.add(bills.get(i).getBilCountyMoney());
				}
				break;
			case 2:
				if (isToday(date)) {
					day = day.add(bills.get(i).getBilPropertyMoney());
				}
				if (isCurrMonth(date)) {
					month = month.add(bills.get(i).getBilPropertyMoney());
				}
				if (isCurrYear(date)) {
					year = year.add(bills.get(i).getBilPropertyMoney());
				}
				break;
			case 3:
				if (isToday(date)) {
					day = day.add(bills.get(i).getBilProvinceMoney());
				}
				if (isCurrMonth(date)) {
					month = month.add(bills.get(i).getBilProvinceMoney());
				}
				if (isCurrYear(date)) {
					year = year.add(bills.get(i).getBilProvinceMoney());
				}
				break;
			default:
				break;
			}
		}
		ActionContext.getContext().getSession().put("Year", year);
		ActionContext.getContext().getSession().put("Month", month);
		ActionContext.getContext().getSession().put("Today", day);
		return "gotoReport";
	}
	
	public String query() {
		BigDecimal profit = new BigDecimal(0);
		String[] sTime = startTime.split("/");
		String[] eTime = endTime.split("/");
		startTime = sTime[2] + "-" + sTime[0] + "-" + sTime[1];
		endTime = eTime[2] + "-" + eTime[0] + "-" + eTime[1];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOne = new Date();
		Date dateTwo = new Date();
		try {
			dateOne = sdf.parse(startTime);
			dateTwo = sdf.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Bill> bills = billService.queryToDate(dateOne, dateTwo);
		ThinkUser thu = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		Area area = thu.getArea();
		int type = -1;
		if (bills.size() > 0 ) {
			if ((int)area.getAreId() == (int)bills.get(0).getAreaByThuCityId().getAreId()) {
				type = 0;
			} else if((int)area.getAreId() == (int)bills.get(0).getAreaByThuCountyId().getAreId()) {
				type = 1;
			} else if ((int)area.getAreId() == (int)bills.get(0).getAreaByThuPropertyId().getAreId()) {
				type = 2;
			} else if ((int)area.getAreId() == (int)bills.get(0).getAreaByThuProvinceId().getAreId()) {
				type = 3;
			} else {
				System.out.println("找不到");
			}
		}
		
		for (int i = 0; i < bills.size(); i++) {
			Date date = bills.get(i).getBilDate();
			switch (type) {
			case 0:
				profit = profit.add(bills.get(i).getBilCityMoney());
				break;
			case 1:
				profit = profit.add(bills.get(i).getBilCountyMoney());
				break;
			case 2:
				profit = profit.add(bills.get(i).getBilPropertyMoney());
				break;
			case 3:
				profit = profit.add(bills.get(i).getBilProvinceMoney());
				break;
			case -1:
				System.out.println(profit);
				System.out.println(profit);
				profit = profit.add(bills.get(i).getBilZongMoney());
				break;
			default:
				System.out.println("---------------------");
				break;
			}
		}
		Map<String, Object> reu = (Map<String, Object>) ActionContext.getContext().get("request");
		System.out.println(profit);
		reu.put("profit", profit);
		reu.put("dateOne", dateOne);
		reu.put("dateTwo", dateTwo);
		return "gotoReport";
	}
	
	private boolean isToday(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(new Date());
		String day = sdf.format(date);
		return today.equals(day);
	}
	
	private boolean isCurrMonth(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String today = sdf.format(new Date());
		String day = sdf.format(date);
		return today.equals(day);
	}
	
	private boolean isCurrYear(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String today = sdf.format(new Date());
		String day = sdf.format(date);
		return today.equals(day);
	}
	
	public String selectById(){
		billResult = billService.selectById(bill.getBilId());
		return "selectAll";
	}
	
	public void setBillService(BillService billService) {
		this.billService = billService;
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
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public Float getAmountMin() {
		return amountMin;
	}

	public void setAmountMin(Float amountMin) {
		this.amountMin = amountMin;
	}

	public Float getAmountMax() {
		return amountMax;
	}

	public void setAmountMax(Float amountMax) {
		this.amountMax = amountMax;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
