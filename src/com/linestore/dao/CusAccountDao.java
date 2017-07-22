package com.linestore.dao;

import com.linestore.vo.CusAccount;

public interface CusAccountDao {
	
	public void addCusAccount(CusAccount cusAccount);
	
	public void updateField(String field, String value, int id);

}
