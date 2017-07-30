package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CateLineDao;
import com.linestore.service.CateLineService;
import com.linestore.vo.CateLine;

@Transactional
public class CateLineServiceImpl implements CateLineService{
	private CateLineDao cateLineDao;

	public void setCateLineDao(CateLineDao cateLineDao) {
		this.cateLineDao = cateLineDao;
	}

	@Override
	public List<CateLine> selectAll() {
		// TODO Auto-generated method stub
		return cateLineDao.selectAll();
	}
	
}
