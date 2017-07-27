package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CusBankDao;
import com.linestore.service.CusBankService;
import com.linestore.vo.CusBank;

@Transactional
public class CusBankServiceImpl implements CusBankService {

	
	private CusBankDao cusBankDao;
	@Override
	public void addCusBank(CusBank cusBank) {
		cusBankDao.addCusBank(cusBank);
	}

	@Override
	public void delCusBank(CusBank cusBank) {
		cusBankDao.delCusBank(cusBank);
	}

	@Override
	public List<CusBank> queryAll() {
		return cusBankDao.queryAll();
	}

	public CusBankDao getCusBankDao() {
		return cusBankDao;
	}

	public void setCusBankDao(CusBankDao cusBankDao) {
		this.cusBankDao = cusBankDao;
	}

	@Override
	public List<CusBank> queryByCusId(int cusId) {
		return cusBankDao.queryByCusId(cusId);
	}
	
}
