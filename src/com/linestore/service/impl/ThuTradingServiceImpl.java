package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.ThuTradingDao;
import com.linestore.service.ThuTradingService;
import com.linestore.util.Page;
import com.linestore.vo.ThuTrading;

@Transactional
public class ThuTradingServiceImpl implements ThuTradingService {
	private ThuTradingDao thuTradingDao;
	
	public ThuTradingDao getThuTradingDao() {
		return thuTradingDao;
	}

	public void setThuTradingDao(ThuTradingDao thuTradingDao) {
		this.thuTradingDao = thuTradingDao;
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return thuTradingDao.selectCount();
	}

	@Override
	public List<ThuTrading> select(Page page) {
		// TODO Auto-generated method stub
		return thuTradingDao.select(page);
	}

	@Override
	public void save(ThuTrading thuTrading) {
		// TODO Auto-generated method stub
		thuTradingDao.save(thuTrading);
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		thuTradingDao.update(hql);
	}

	@Override
	public int selectByKeyCount(Integer[] thuList,Integer[] areList) {
		// TODO Auto-generated method stub
		return thuTradingDao.selectByKeyCount(thuList, areList);
	}

	@Override
	public List<ThuTrading> selectByKey(Page page, Integer[] thuList,Integer[] areList) {
		// TODO Auto-generated method stub
		return thuTradingDao.selectByKey(page, thuList, areList);
	}

	@Override
	public ThuTrading selectById(String id) {
		// TODO Auto-generated method stub
		return thuTradingDao.selectById(id);
	}

	@Override
	public void update(ThuTrading thuTrading) {
		// TODO Auto-generated method stub
		thuTradingDao.update(thuTrading);
	}

	@Override
	public ThuTrading selectByAreaId(int id) {
		// TODO Auto-generated method stub
		return thuTradingDao.selectByAreaId(id);
	}

	@Override
	public List<ThuTrading> selectByKeytoThu(Page page, Integer[] thuList) {
		// TODO Auto-generated method stub
		return thuTradingDao.selectByKeytoThu(page, thuList);
	}

	@Override
	public List<ThuTrading> selectByKeytoAre(Page page, Integer[] areList) {
		// TODO Auto-generated method stub
		return thuTradingDao.selectByKeytoAre(page, areList);
	}

	@Override
	public int selectByKeyCountToThu(Integer[] thuList) {
		// TODO Auto-generated method stub
		return thuTradingDao.selectByKeyCountToThu(thuList);
	}

	@Override
	public int selectByKeyCountToAre(Integer[] areList) {
		// TODO Auto-generated method stub
		return thuTradingDao.selectByKeyCountToAre(areList);
	}

}
