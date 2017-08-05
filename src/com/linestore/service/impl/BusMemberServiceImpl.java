package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BusMemberDao;
import com.linestore.service.BusMemberService;
import com.linestore.vo.BusMember;

@Transactional
public class BusMemberServiceImpl implements BusMemberService {
	
	private BusMemberDao busMemberDao;

	@Override
	public List<BusMember> queryByOpenId(String openId) {
		return busMemberDao.queryByOpenId(openId);
	}

	@Override
	public void addBusMember(BusMember busMember) {
		busMemberDao.addBusMember(busMember);
	}

	public BusMemberDao getBusMemberDao() {
		return busMemberDao;
	}

	public void setBusMemberDao(BusMemberDao busMemberDao) {
		this.busMemberDao = busMemberDao;
	}
	
	
	
	

}
