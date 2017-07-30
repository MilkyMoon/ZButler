package com.linestore.dao;

import com.linestore.vo.CusAccount;

public interface CusAccountDao {
	
	public CusAccount findByCusId(int cusId);
	
	public void addCusAccount(CusAccount cusAccount);
	
	public void updateCusAccount(CusAccount cusAccount);
	
	public void updateField(String field, String value, int id);

}
