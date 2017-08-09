package com.linestore.service;

import java.util.List;

import com.linestore.vo.GroupAccess;

public interface GroupAccessService {

	public void addGroupAccess(GroupAccess ga);

	public void delGroupAccess(int gaId);

	public void updateGroupAccess(GroupAccess ga);

	public GroupAccess queryById(int gaId);

	public List<GroupAccess> queryAll();

}
