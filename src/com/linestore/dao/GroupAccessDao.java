package com.linestore.dao;

import java.util.List;

import com.linestore.vo.GroupAccess;

public interface GroupAccessDao {
	
	public void addGroupAccess(GroupAccess ga);
	
	public void delGroupAccess(int gaId);
	
	public void updateGroupAccess(GroupAccess ga);
	
	public GroupAccess queryById(int gaId);
	
	public List<GroupAccess> queryAll();

}
