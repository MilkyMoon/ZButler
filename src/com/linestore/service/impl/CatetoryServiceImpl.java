package com.linestore.service.impl;

import java.util.List;
import java.util.Map;

import com.linestore.dao.CatetoryDao;
import com.linestore.service.CatetoryService;
import com.linestore.vo.Catetory;

public class CatetoryServiceImpl implements CatetoryService {
	
	private CatetoryDao catetoryDao;

	@Override
	public void addCatetory(Catetory catetory) {
		catetoryDao.addCatetory(catetory);
	}

	@Override
	public void delCatetory(Catetory catetory) {
		catetoryDao.delCatetory(catetory);
	}

	@Override
	public void updateCatetoey(Catetory catetory) {
		catetoryDao.updateCatetoey(catetory);
	}

	@Override
	public List<Catetory> queryByPid(int pid) {
		return catetoryDao.queryByPid(pid);
	}

	@Override
	public List<Catetory> queryAll() {
		return catetoryDao.queryAll();
	}

	public CatetoryDao getCatetoryDao() {
		return catetoryDao;
	}

	public void setCatetoryDao(CatetoryDao catetoryDao) {
		this.catetoryDao = catetoryDao;
	}
	
	public void queryFormat(List<Catetory> list, int pid) {
		catetoryDao.queryFormat(list, pid, 0);
	}

}
