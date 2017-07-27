package com.linestore.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CtaTradingDao;
import com.linestore.service.CtaTradingService;
import com.linestore.vo.CtaTrading;

@Transactional
public class CtaTradingServiceImpl implements CtaTradingService {
	
	private CtaTradingDao ctaTradingDao;

	@Override
	public void addCtaTrading(CtaTrading ctaTrading) {
		ctaTradingDao.addCtaTrading(ctaTrading);
	}

	public CtaTradingDao getCtaTradingDao() {
		return ctaTradingDao;
	}

	public void setCtaTradingDao(CtaTradingDao ctaTradingDao) {
		this.ctaTradingDao = ctaTradingDao;
	}
	

}
