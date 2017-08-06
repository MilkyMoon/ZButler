package com.linestore.dao;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.BusTrading;

public interface BusTradingDao {
	
	public List queryHot(String city);
	
	public void addBusTrading(BusTrading busTrading);
	
	public List<BusTrading> queryIncome(int busId);
	
	public List<BusTrading> queryWithdraw(int busId);
	
	public BusTrading queryById(String btaId);
	
	public List<BusTrading> selectAll(Page page);
	
	public int queryAll();
	
	public void update(String hql);
	
	public List<BusTrading> searchAll(String keywords);
	
	public List<BusTrading> search(String keywords, String area);
	
	public List<BusTrading> selectByArea(Page page, String area);
	
	public int queryByAreaAll(String area);

}
