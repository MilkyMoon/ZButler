package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.GroupDao;
import com.linestore.service.GroupService;
import com.linestore.util.Page;
import com.linestore.vo.Group;

@Transactional
public class GroupServiceImpl implements GroupService {
	
	private GroupDao groupDao;

	@Override
	public void addGroup(Group group) {
		groupDao.addGroup(group);
	}

	@Override
	public void delGroup(int groId) {
		groupDao.delGroup(groId);
	}

	@Override
	public void updateGroup(Group group) {
		groupDao.updateGroup(group);
	}

	@Override
	public List<Group> queryAll(int id) {
		return groupDao.queryAll(id);
	}
	
	@Override
	public List<Group> queryAll(Page page, int id) {
		return groupDao.queryAll(page, id);
	}

	@Override
	public Group queryById(int id) {
		return groupDao.queryById(id);
	}

	@Override
	public List<Group> queryByTitle(String title, int id) {
		return groupDao.queryByTitle(title, id);
	}
	
	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public List<Group> queryByTitle(Page page, String title, int id) {
		
		return groupDao.queryByTitle(page, title, id);
	}
	

}
