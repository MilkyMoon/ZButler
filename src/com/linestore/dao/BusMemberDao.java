package com.linestore.dao;

import java.util.List;

import com.linestore.vo.BusMember;

public interface BusMemberDao {
	
	public List<BusMember> queryByOpenId(String openId);
	
	public void addBusMember(BusMember busMember);
}
