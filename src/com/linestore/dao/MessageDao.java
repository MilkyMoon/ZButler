package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Message;

public interface MessageDao {
	// 获取用户全部留言
	List<Message> selectAll(Message message);

	// 为用户增加一个留言
	void add(Message message);
	
	//删除用户指定留言
	void del(Message message);

}
