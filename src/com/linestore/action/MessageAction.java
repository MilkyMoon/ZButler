package com.linestore.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.linestore.service.CustomerService;
import com.linestore.service.MessageService;
import com.linestore.util.Page;
import com.linestore.util.PageUtil;
import com.linestore.vo.Customer;
import com.linestore.vo.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction extends ActionSupport implements ModelDriven<Message> {
	// 模型驱动使用的类
	private Message message = new Message();
	// 封装返回结果
	private List<Message> messageList;
	private Message messageResult;
	private String everyPage = "10";
	private String pageNow = "1";
	Map<String, Object> request;

	public String getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(String everyPage) {
		this.everyPage = everyPage;
	}

	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}

	public int getmesId() {
		return mesId;
	}

	public void setmesId(int id) {
		this.mesId = id;
	}

	private int mesId;

	// cusAddress已在上方实例化
	@Override
	public Message getModel() {
		if (message == null) {
			message = new Message();
		}
		return message;
	}

	// Struts和Spring整合过程中按名称来自动注入业务层的类
	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	// 增加留言（模拟已登录用户）
	public String add() {
		System.out.println("MessageAction中的add方法！");
		Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
		// customer.setCusId(1);
		message.setCustomer(customer);
		System.out.println(message.getMesType() + " : " + message.getMesTitle() + " : " + message.getMesContent());
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		message.setMesTime(timestamp);
		messageService.add(message);
		messageList = messageService.selectAll(message);
		return "goto";
	}

	// 获取已登录用户的全部留言
	public String selectAll() {
		System.out.println("MessageAction中的selectAll方法！");
		Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
		// customer.setCusId(1);
		message.setCustomer(customer);
		messageList = messageService.selectAll(message);

		return "selectAll";
	}

	// 删除用户指定留言
	public String del() {
		System.out.println("MessageAction中的del方法！");
		messageService.del(message);
		Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
		// customer.setCusId(1);
		message.setCustomer(customer);
		messageList = messageService.selectAll(message);

		return "messageList";
	}

	public String selectAllMessage() {
		System.out.println("select");
		int totalCount = messageService.queryAll();
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
		messageList = messageService.SelectAll(page);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roots", messageList);
		request.put("page", page);
		return "selectAll";
	}

	public String delMessage() {
		this.messageService.del(message.getMesId());
		return "select";
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public Message getMessageResult() {
		return messageResult;
	}

	public void setMessageResult(Message messageResult) {
		this.messageResult = messageResult;
	}

	public MessageService getMessageService() {
		return messageService;
	}

}