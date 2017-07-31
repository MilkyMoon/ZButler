package com.linestore.service;

import com.linestore.vo.CusAccount;

public interface CusAccountService {
	
	public CusAccount findByCusId(int cusId);
	
	public void addCusAccount(CusAccount cusAccount);
	
	public void updateCusAccount(CusAccount cusAccount);
	
	public void updateField(String field, String value, int id);
	
	public void delete(int cusId);
}
