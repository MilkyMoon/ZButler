package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.TransferDao;
import com.linestore.service.TransferService;
import com.linestore.util.Page;
import com.linestore.vo.Transfer;

@Transactional
public class TransferServiceImpl implements TransferService {
	private TransferDao transferDao;
	
	public TransferDao getTransferDao() {
		return transferDao;
	}

	public void setTransferDao(TransferDao transferDao) {
		this.transferDao = transferDao;
	}

	@Override
	public void save(Transfer transfer) {
		// TODO Auto-generated method stub
		transferDao.save(transfer);
	}

	@Override
	public int selectAllCount() {
		// TODO Auto-generated method stub
		return transferDao.selectAllCount();
	}

	@Override
	public List<Transfer> selectAll(Page page) {
		// TODO Auto-generated method stub
		return transferDao.selectAll(page);
	}

	@Override
	public Transfer selectById(int id) {
		// TODO Auto-generated method stub
		return transferDao.selectById(id);
	}

	@Override
	public int selectByTimeCount(String timeMin, String timeMax, Float amountMin, Float amountMax, String keywords) {
		// TODO Auto-generated method stub
		return transferDao.selectByTimeCount(timeMin, timeMax, amountMin, amountMax, keywords);
	}

	@Override
	public List<Transfer> selectByTime(Page page, String timeMin, String timeMax, Float amountMin, Float amountMax, String keywords) {
		// TODO Auto-generated method stub
		return transferDao.selectByTime(page, timeMin, timeMax, amountMin, amountMax, keywords);
	}

}
