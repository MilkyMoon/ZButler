package com.linestore.service;

import java.util.List;

import com.linestore.vo.CusBank;

public interface CusBankService {
	
public void addCusBank(CusBank cusBank);
	
	public void delCusBank(CusBank cusBank);
	
	public List<CusBank> queryAll();
	
	public List<CusBank> queryByCusId(int cusId);

}
