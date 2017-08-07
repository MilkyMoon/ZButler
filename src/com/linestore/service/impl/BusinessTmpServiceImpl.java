package com.linestore.service.impl;

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

	public BusinessTmpDao getBusinessTmpDao() {
		return businessTmpDao;
	}

	public void setBusinessTmpDao(BusinessTmpDao businessTmpDao) {
		this.businessTmpDao = businessTmpDao;
	}

	

}
