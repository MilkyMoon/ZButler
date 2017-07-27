package com.linestore.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.linestore.service.CustomerService;
import com.linestore.service.MessageService;
import com.linestore.vo.Customer;
import com.linestore.vo.Message;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction extends ActionSupport implements ModelDriven<Message> {
	// 模型驱动使用的类
	private Message message = new Message();
	// 封装返回结果
	private List<Message> messageList;
	private Message messageResult;

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
		Customer customer = new Customer();
		customer.setCusId(1);
		message.setCustomer(customer);
		System.out.println(message.getMesType()+" : "+message.getMesTitle()+" : "+message.getMesContent());
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
		Customer customer = new Customer();
		customer.setCusId(1);
		message.setCustomer(customer);
		messageList = messageService.selectAll(message);

		return "selectAll";
	}
	//删除用户指定留言
	public String del(){
		System.out.println("MessageAction中的del方法！");
		messageService.del(message);
		Customer customer = new Customer();
		customer.setCusId(1);
		message.setCustomer(customer);
		messageList = messageService.selectAll(message);

		return "messageList";
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