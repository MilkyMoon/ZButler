package com.linestore.dao;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Group;

public interface GroupDao {
	
	public void addGroup(Group group);
	
	public void delGroup(int groId);
	
	public void updateGroup(Group group);
	
	public List<Group> queryAll();
	
	public List<Group> queryAll(Page page);

}
