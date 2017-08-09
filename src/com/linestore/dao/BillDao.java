package com.linestore.dao;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Bill;

public interface BillDao {
	public List<Bill> select(Page page,Integer id);
	public List<Bill> selectAll(Page page);
	public List<Bill> search(String keywords);
	public int queryAll(String hql);
	public String mkData();
	public void addBill(Bill bill);
	public Bill selectById(Integer id);
	
	public List<Bill> queryByCusId(int cusId);
	
	public List<Bill> queryByArea(int areaId);
}
