package com.linestore.service;

import com.linestore.vo.CusAccount;

public interface CusAccountService {
	
	public void addCusAccount(CusAccount cusAccount);
	
	public void updateField(String field, String value, int id);
}
