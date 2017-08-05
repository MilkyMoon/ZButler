package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BusTradingDao;
import com.linestore.service.BusTradingService;
import com.linestore.util.Page;
import com.linestore.vo.BusTrading;

@Transactional
public class BusTradingServiceImpl implements BusTradingService {
	
	private BusTradingDao busTradingDao;

	@Override
	public List queryHot(String city) {
		return busTradingDao.queryHot(city);
	}

	@Override
	public void addBusTrading(BusTrading busTrading) {
		busTradingDao.addBusTrading(busTrading);
	}

	@Override
	public List<BusTrading> queryIncome(int busId) {
		return busTradingDao.queryIncome(busId);
	}

	@Override
	public List<BusTrading> queryWithdraw(int busId) {
		return busTradingDao.queryWithdraw(busId);
	}
	
	public BusTradingDao getBusTradingDao() {
		return busTradingDao;
	}

	public void setBusTradingDao(BusTradingDao busTradingDao) {
		this.busTradingDao = busTradingDao;
	}

	@Override
	public BusTrading queryById(String btaId) {
		
		return busTradingDao.queryById(btaId);
	}

	@Override
	public List<BusTrading> selectAll(Page page) {
		// TODO Auto-generated method stub
		return busTradingDao.selectAll(page);
	}

	@Override
	public int queryAll() {
		// TODO Auto-generated method stub
		return busTradingDao.queryAll();
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		busTradingDao.update(hql);
	}
	

}
