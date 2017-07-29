package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.ThinkUserDao;
import com.linestore.service.ThinkUserService;
import com.linestore.vo.ThinkUser;

@Transactional
public class ThinkUserServiceImpl implements ThinkUserService{
	private ThinkUserDao thinkUserDao;
	
	public void setThinkUserDao(ThinkUserDao thinkUserDao) {
		this.thinkUserDao = thinkUserDao;
	}

	public void queryFormat(List<ThinkUser> list, int pid) {
		thinkUserDao.queryFormat(list, pid, 0);
	}
}
