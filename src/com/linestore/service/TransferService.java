package com.linestore.service;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Transfer;

public interface TransferService {
	public void save(Transfer transfer);
	public int selectAllCount();
	public List<Transfer> selectAll(Page page);
	public Transfer selectById(int id);
	public int selectByTimeCount(String timeMin, String timeMax,Float amountMin, Float amountMax, String keywords);
	public List<Transfer> selectByTime(Page page,String timeMin, String timeMax,Float amountMin, Float amountMax, String keywords);
}
