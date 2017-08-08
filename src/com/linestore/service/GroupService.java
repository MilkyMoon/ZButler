package com.linestore.service;

import java.util.List;

import com.linestore.vo.Group;

public interface GroupService {

	public void addGroup(Group group);

	public void delGroup(int groId);

	public void updateGroup(Group group);

	public List<Group> queryAll();

}