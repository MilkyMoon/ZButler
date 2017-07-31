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

	public void queryFormat(List<ThinkUser> list, int pid, int level) {
		thinkUserDao.queryFormat(list, pid, level);
	}
	
	public void add(ThinkUser thinkUser){
		thinkUserDao.add(thinkUser);
	}
	
	public void delete(int thuId){
		thinkUserDao.delete(thuId);
	}

	@Override
	public ThinkUser selectById(ThinkUser thinkUser) {
		return thinkUserDao.selectById(thinkUser);
	}

	@Override
	public List<ThinkUser> select(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		return thinkUserDao.select(thinkUser);
	}

	@Override
	public void status(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		thinkUserDao.status(thinkUser);
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		thinkUserDao.update(hql);
	}

	@Override
	public ThinkUser checkThinkUser(ThinkUser thinkUser) {
		return thinkUserDao.checkThinkUser(thinkUser);
	}
}
