package com.linestore.service.impl;

import com.linestore.dao.CusAddressDao;
import com.linestore.dao.MessageDao;
import com.linestore.service.CusAddressService;
import com.linestore.service.MessageService;
import com.linestore.util.Page;
import com.linestore.vo.CusAddress;
import com.linestore.vo.Message;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MessageServiceImpl implements MessageService {
	// 业务层注入DAO的类
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

	@Override
	public void del(Message message) {
		messageDao.del(message);
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public List<Message> SelectAll(Page page) {
		// TODO Auto-generated method stub
		List<Message> list = this.messageDao.SelectAll(page);
		return list;
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		this.messageDao.del(id);

	}

	@Override
	public int queryAll() {
		// TODO Auto-generated method stub
		return this.messageDao.queryAll();
	}

	@Override
	public List<Message> search(int type) {
		// TODO Auto-generated method stub
		
		return this.messageDao.search(type);
	}

}
