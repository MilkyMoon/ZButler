package com.linestore.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.service.BillService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
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
	
//	private static final long serialVersionUID = -5452039838295753607L;
	private String data;
	private static final long serialVersionUID = 1L;
    //此变量必须有setter与getter方法
    private String result;
    
	private String pageNow = "1";
	private String everyPage = "10";
	private String keywords = "";

	private Integer thuId;
	@Override
	public Bill getModel() {
		// TODO Auto-generated method stub
		return bill;
	}
	
	public String select(){
		
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
		
		if(think.getThuPid() == 0){
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
		thuId = think.getThuId();
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
	
}
