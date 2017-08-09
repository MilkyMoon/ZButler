package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.GroupAccessDao;
import com.linestore.service.GroupAccessService;
import com.linestore.vo.GroupAccess;

@Transactional
public class GroupAccessServiceImpl implements GroupAccessService {
	
	private GroupAccessDao groupAccessDao;

	@Override
	public void addGroupAccess(GroupAccess ga) {
		groupAccessDao.addGroupAccess(ga);
	}

	@Override
	public void delGroupAccess(int gaId) {
		groupAccessDao.delGroupAccess(gaId);
	}

	@Override
	public void updateGroupAccess(GroupAccess ga) {
		groupAccessDao.updateGroupAccess(ga);
	}

	@Override
	public GroupAccess queryById(int gaId) {
		return groupAccessDao.queryById(gaId);
	}

	@Override
	public List<GroupAccess> queryAll() {
		return groupAccessDao.queryAll();
	}

	public GroupAccessDao getGroupAccessDao() {
		return groupAccessDao;
	}

	public void setGroupAccessDao(GroupAccessDao groupAccessDao) {
		this.groupAccessDao = groupAccessDao;
	}

	
	

}
