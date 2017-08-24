package com.linestore.service.impl;

import java.math.BigDecimal;
import java.util.Date;
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
	public List<Bill> selectByTime(Page page, Integer id, String timeMin, String timeMax, BigDecimal amountMin,
			BigDecimal amountMax) {
		// TODO Auto-generated method stub
		return billDao.selectByTime(page, id, timeMin, timeMax, amountMin, amountMax);
	}

	@Override
	public List<Bill> selectAllByTime(Page page, String timeMin, String timeMax, BigDecimal amountMin, BigDecimal amountMax) {
		// TODO Auto-generated method stub
		return billDao.selectAllByTime(page, timeMin, timeMax, amountMin, amountMax);
    }
    
	public List<Bill> queryByCusId(int cusId) {
		return billDao.queryByCusId(cusId);
	}

	@Override
	public List<Bill> queryByArea(int areaId) {
		return billDao.queryByArea(areaId);
	}

	@Override
	public BigDecimal todayMoney() {
		return billDao.todayMoney();
	}

	@Override
	public BigDecimal monthMoney() {
		return billDao.monthMoney();
	}

	@Override
	public BigDecimal yearMoney() {
		return billDao.yearMoney();
	}

	@Override
	public List<Bill> queryToDate(Date dateOne, Date dateTwo) {
		return billDao.queryToDate(dateOne, dateTwo);
	}

	@Override
	public BigDecimal totalMoney() {
		return billDao.totalMoney();
	}

	@Override
	public List<Bill> selectByExcel() {
		// TODO Auto-generated method stub
		return billDao.selectByExcel();
	}
}
