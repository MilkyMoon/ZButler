package com.linestore.service.impl;

import com.linestore.dao.CusAddressDao;
import com.linestore.dao.MessageDao;
import com.linestore.service.CusAddressService;
import com.linestore.service.MessageService;
import com.linestore.vo.CusAddress;
import com.linestore.vo.Message;

import java.util.List;

public class MessageServiceImpl implements MessageService{
	//业务层注入DAO的类
			private MessageDao messageDao;
	@Override
	public void add(Message message) {
		// TODO Auto-generated method stub
		messageDao.add(message);
	}

	@Override
	public List<Message> selectAll(Message message) {
		// TODO Auto-generated method stub
		return messageDao.selectAll(message);
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
}
