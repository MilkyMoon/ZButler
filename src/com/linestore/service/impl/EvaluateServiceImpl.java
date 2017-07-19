package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.EvaluateDao;
import com.linestore.service.EvaluateService;
import com.linestore.util.Page;
import com.linestore.vo.Evaluate;

@Transactional
public class EvaluateServiceImpl implements EvaluateService  {
	
	private EvaluateDao evaluateDao;

	public EvaluateDao getEvaluateDao() {
		return evaluateDao;
	}

	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}

	@Override
	public void addEvaluate(Evaluate evaluate) {
		evaluateDao.addEvaluate(evaluate);
	}

	@Override
	public void delEvaluate(int evaId) {
		evaluateDao.delEvaluate(evaId);
	}

	@Override
	public int allLength() {
		return evaluateDao.queryAll().size();
	}

	@Override
	public List<Evaluate> queryAll() {
		return evaluateDao.queryAll();
	}

	@Override
	public List<Evaluate> queryAll(Page page) {
		return evaluateDao.queryAll(page);
	}

}
