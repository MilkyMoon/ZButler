package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.ThinkUserDao;
import com.linestore.service.ThinkUserService;
import com.linestore.util.Page;
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

	@Override
	public ThinkUser queryById(int thuId) {
		return thinkUserDao.queryById(thuId);
	}

	@Override
	public List<ThinkUser> selectAllByArea(Page page, Integer[] list) {
		// TODO Auto-generated method stub
		return thinkUserDao.selectAllByArea(page, list);
	}

	@Override
	public int selectAllByAreaCount(Integer[] list) {
		// TODO Auto-generated method stub
		return thinkUserDao.selectAllByAreaCount(list);
	}

	@Override
	public List<ThinkUser> selectAllByKey(Page page, String keywords) {
		// TODO Auto-generated method stub
		return thinkUserDao.selectAllByKey(page, keywords);
	}

	@Override
	public int selectAllByKeyCount(String keywords) {
		// TODO Auto-generated method stub
		return thinkUserDao.selectAllByKeyCount(keywords);
	}

	@Override
	public List<ThinkUser> selectAllByKey(String keywords) {
		// TODO Auto-generated method stub
		return thinkUserDao.selectAllByKey(keywords);
	}

}
