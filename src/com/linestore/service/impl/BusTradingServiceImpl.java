package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BusTradingDao;
import com.linestore.service.BusTradingService;

@Transactional
public class BusTradingServiceImpl implements BusTradingService {
	
	private BusTradingDao busTradingDao;

	@Override
	public List queryHot() {
		return busTradingDao.queryHot();
	}

	public BusTradingDao getBusTradingDao() {
		return busTradingDao;
	}

	public void setBusTradingDao(BusTradingDao busTradingDao) {
		this.busTradingDao = busTradingDao;
	}
	

}
