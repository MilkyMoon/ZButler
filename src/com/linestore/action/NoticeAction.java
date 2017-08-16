package com.linestore.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.linestore.dao.NoticeDao;
import com.linestore.service.NoticeService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Message;
import com.linestore.vo.Notice;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javassist.expr.NewArray;
import net.sf.json.JSONObject;

public class NoticeAction extends ActionSupport
		implements ModelDriven<Notice>, ServletRequestAware, ServletResponseAware {
	private String pageNow = "1";
	private HttpServletResponse res;
	private String result;
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private HttpServletRequest req;
	
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

	private String everyPage = "10";
	private String keywords = "";
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	List<Notice> noticelist = new ArrayList<Notice>();
	Map<String, Object> request;
	// 模型驱动使用的类
	private Notice notice = new Notice();

	@Override
	public Notice getModel() {
		// TODO Auto-generated method stub
		if (notice == null) {
			notice = new Notice();
		}
		return notice;
	}

	private NoticeService noticeService;

	public String selectAll() {

		System.out.println("select");
		int totalCount = noticeService.queryAll();
		if (everyPage.equals("") || everyPage == null) {
			everyPage = "10";
		}
		if (pageNow.equals("") || pageNow == null || (Integer.parseInt(pageNow) > Math.ceil(totalCount/Float.valueOf(everyPage)))) {
			pageNow = "1";
		}
		Page page = PageUtil.createPage(Integer.parseInt(everyPage), totalCount, Integer.parseInt(pageNow));
		System.out.println("总页数：" + page.getTotalPage());
		System.out.println("当前页：" + page.getCurrentPage());
		System.out.println("每页数：" + page.getEveryPage());
		System.out.println("上一页：" + page.isHasPrePage());
		System.out.println("下一页：" + page.isHasNextPage());
		noticelist = noticeService.allNoticesCenter(page);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", noticelist);
		request.put("page", page);
		return "selectAll";

	}

	public String hasNewNotice() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", noticeService.getNewNotice());
		this.result = JSONObject.fromObject(map).toString();
		return SUCCESS;
	}

	public String add() {
		return "add";
	}

	public String save() {
		// 设置发布时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		notice.setTime(sdf.format(new Date().getTime()));
		noticeService.pushNotice(notice);
		return "select";
	}

	public String del() {
		noticeService.delNotice(notice.getId());
		return "select";
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public String customerNotice() {
		noticelist = noticeService.customerNewNoticesCenter();
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", noticelist);
		return "history";
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.res = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.req = request;
	}

}
