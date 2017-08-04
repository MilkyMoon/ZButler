package com.linestore.service;

import java.util.List;

import com.linestore.vo.BusTrading;

public interface BusTradingService {

	public List queryHot(String city);

	public void addBusTrading(BusTrading busTrading);

	public List<BusTrading> queryIncome(int busId);

	public List<BusTrading> queryWithdraw(int busId);
	
	public BusTrading queryById(String btaId);

}
