package com.linestore.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CusAccountDao;
import com.linestore.service.CusAccountService;
import com.linestore.vo.CusAccount;

@Transactional
public class CusAccountServiceImpl implements CusAccountService {
	
	private CusAccountDao cusAccountDao;

	public CusAccountDao getCusAccountDao() {
		return cusAccountDao;
	}

	public void setCusAccountDao(CusAccountDao cusAccountDao) {
		this.cusAccountDao = cusAccountDao;
	}

	@Override
	public void addCusAccount(CusAccount cusAccount) {
		cusAccountDao.addCusAccount(cusAccount);
	}

	@Override
	public void updateField(String field, String value, int id) {
		cusAccountDao.updateField(field, value, id);
	}

	@Override
	public CusAccount findByCusId(int cusId) {
		return cusAccountDao.findByCusId(cusId);
	}

	@Override
	public void updateCusAccount(CusAccount cusAccount) {
		cusAccountDao.updateCusAccount(cusAccount);
		
	}

}
