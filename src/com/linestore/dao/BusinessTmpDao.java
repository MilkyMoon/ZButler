package com.linestore.dao;

import com.linestore.vo.BusinessTmp;

public interface BusinessTmpDao {
	
	public void addBusinessTmp(BusinessTmp businessTmp);
	
	public void delBusinessTmp(int busTid);
	
	public BusinessTmp queryById(int bustId);

}
