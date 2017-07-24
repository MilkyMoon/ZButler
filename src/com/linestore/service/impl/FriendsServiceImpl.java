package com.linestore.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CustomerDao;
import com.linestore.dao.FriendsDao;
import com.linestore.service.CustomerService;
import com.linestore.service.FriendsService;
import com.linestore.util.QrCodeUtil;
import com.linestore.util.QrExistsUtil;
import com.linestore.vo.Customer;
import com.linestore.vo.Friends;

@Transactional
public class FriendsServiceImpl implements FriendsService {
	// 业务层注入DAO的类
	private FriendsDao friendsDao;

	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}

	@Override
	public void save(Friends friends) {
		friendsDao.save(friends);
	}

	@Override
	public List<Friends> selectAll(Customer customer) {
		return friendsDao.selectAll(customer);
	}

	@Override
	public Friends select(Friends friends) {
		return null;
	}

	@Override
	public List<Friends> selectType(Friends friends) {
		return friendsDao.selectType(friends);
	}

}
