package com.linestore.dao;

import java.util.List;

import com.linestore.vo.BusinessTmp;

public interface BusinessTmpDao {
	
	public void addBusinessTmp(BusinessTmp businessTmp);
	
	public void delBusinessTmp(int busTid);
	
	public BusinessTmp queryById(int bustId);
	
	public List<BusinessTmp> selectAll();
	
	public void save(BusinessTmp businessTmp);
	
	public void delete(BusinessTmp busT);

}
