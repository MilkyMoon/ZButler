package com.linestore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.util.Page;
import com.linestore.vo.Customer;
import com.linestore.vo.Message;

@Transactional
public interface MessageService {
	// 为用户增加一个留言
	void add(Message cusAddress);

	// 获取用户全部留言
	List<Message> selectAll(Message cusAddress);

	// 删除用户指定留言
	void del(Message message);

	List<Message> SelectAll(Page page);
	
	public List<Message> search(int type);

	void del(int id);
	
	int queryAll();
}
