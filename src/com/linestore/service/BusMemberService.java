package com.linestore.service;

import java.util.List;

import com.linestore.vo.BusMember;

public interface BusMemberService {
	
	public List<BusMember> queryByOpenId(String openId);
	
	public void addBusMember(BusMember busMember);	

}
