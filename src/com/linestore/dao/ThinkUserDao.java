package com.linestore.dao;

import java.util.List;

import com.linestore.vo.ThinkUser;

public interface ThinkUserDao {
	public List<ThinkUser> queryFormat(List<ThinkUser> list, int pid, int level);
}
