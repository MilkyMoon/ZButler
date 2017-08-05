package com.linestore.service;

import java.util.List;

import com.linestore.vo.ThinkUser;

public interface ThinkUserService {
	public void queryFormat(List<ThinkUser> list, int pid, int level);
	public void add(ThinkUser thinkUser);
	public void delete(int thuId);
	public ThinkUser selectById(ThinkUser thinkUser);
	public List<ThinkUser> select(ThinkUser thinkUser);
	public void status(ThinkUser thinkUser);
	public void update(String hql);
	
	public ThinkUser checkThinkUser(ThinkUser thinkUser);
	
	public ThinkUser queryById(int thuId);
}
