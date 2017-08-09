package com.linestore.service;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Bill;

public interface BillService {
	public List<Bill> select(Page page, Integer id);
	public List<Bill> selectAll(Page page);
	public List<Bill> selectAllByTime(Page page,String timeMin, String timeMax,Float amountMin, Float amountMax);
	public List<Bill> search(String keywords);
	public int queryAll(String hql);
	public String mkData();
	public void addBill(Bill bill);
	public Bill selectById(Integer id);
	public List<Bill> selectByTime(Page page,Integer id,String timeMin, String timeMax,Float amountMin, Float amountMax);
	
	public List<Bill> queryByCusId(int cusId);
}
