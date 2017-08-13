package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BusinessTmpDao;
import com.linestore.service.BusinessTmpService;
import com.linestore.vo.BusinessTmp;

@Transactional
public class BusinessTmpServiceImpl implements BusinessTmpService  {
	
	private BusinessTmpDao businessTmpDao;

	@Override
	public void addBusinessTmp(BusinessTmp businessTmp) {
		businessTmpDao.addBusinessTmp(businessTmp);
	}

	@Override
	public void delBusinessTmp(int busTid) {
		businessTmpDao.delBusinessTmp(busTid);
	}

	@Override
	public BusinessTmp queryById(int bustId) {
		return businessTmpDao.queryById(bustId);
	}
	
	public BusinessTmpDao getBusinessTmpDao() {
		return businessTmpDao;
	}

	public void setBusinessTmpDao(BusinessTmpDao businessTmpDao) {
		this.businessTmpDao = businessTmpDao;
	}

	@Override
	public List<BusinessTmp> selectAll() {
		// TODO Auto-generated method stub
		return businessTmpDao.selectAll();
	}

	@Override
	public void save(BusinessTmp businessTmp) {
		// TODO Auto-generated method stub
		businessTmpDao.save(businessTmp);
	}

	@Override
	public void delete(BusinessTmp busT) {
		businessTmpDao.delete(busT);
	}

}
