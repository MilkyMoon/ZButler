package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BillDao;
import com.linestore.service.BillService;
import com.linestore.util.Page;
import com.linestore.vo.Bill;

@Transactional
public class BillServiceImpl implements BillService {
	private BillDao billDao;

	@Override
	public List<Bill> select(Page page, Integer id) {
		// TODO Auto-generated method stub
		
		return billDao.select(page, id);
	}

	@Override
	public List<Bill> selectAll(Page page) {
		// TODO Auto-generated method stub
		return billDao.selectAll(page);
	}

	@Override
	public List<Bill> search(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBillDao(BillDao billDao) {
		this.billDao = billDao;
	}

	@Override
	public int queryAll(String hql) {
		return billDao.queryAll(hql);
	}

	@Override
	public String mkData() {
		return billDao.mkData();
    }
    
	public void addBill(Bill bill) {
		billDao.addBill(bill);
	}

	@Override
	public Bill selectById(Integer id) {
		return billDao.selectById(id);
	}

	@Override
	public List<Bill> queryByCusId(int cusId) {
		return billDao.queryByCusId(cusId);
	}

	@Override
	public List<Bill> queryByArea(int areaId) {
		return billDao.queryByArea(areaId);
	}
}
