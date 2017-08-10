package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CtaTradingDao;
import com.linestore.service.CtaTradingService;
import com.linestore.util.Page;
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

	@Override
	public List<CtaTrading> queryByCusid(int cusId) {
		return ctaTradingDao.queryByCusid(cusId);
	}

	@Override
	public List<CtaTrading> queryPoint(int cusId) {
		return ctaTradingDao.queryPoint(cusId);
	}

	@Override
	public CtaTrading queryById(String btaId) {
		// TODO Auto-generated method stub
		return ctaTradingDao.queryById(btaId);
	}

	@Override
	public List<CtaTrading> selectAll(Page page) {
		// TODO Auto-generated method stub
		return ctaTradingDao.selectAll(page);
	}

	@Override
	public int queryAll() {
		// TODO Auto-generated method stub
		return ctaTradingDao.queryAll();
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		ctaTradingDao.update(hql);
	}

	

	@Override
	public int queryAllType(int type) {
		// TODO Auto-generated method stub
		return ctaTradingDao.queryAllType(type);
	}

	@Override
	public List<CtaTrading> selectAllType(Page page, int type) {
		// TODO Auto-generated method stub
		return ctaTradingDao.selectAllType(page, type);
	}

	@Override
	public List<CtaTrading> search(String keywords, int type) {
		// TODO Auto-generated method stub
		return ctaTradingDao.search(keywords, type);
	}
	
}
