package com.linestore.service;

import com.linestore.vo.BusinessTmp;

public interface BusinessTmpService {
	
	public void addBusinessTmp(BusinessTmp businessTmp);
	
	public void delBusinessTmp(int busTid);
	
	public BusinessTmp queryById(int bustId);

}
