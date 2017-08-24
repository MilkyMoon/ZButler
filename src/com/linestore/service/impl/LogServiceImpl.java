package com.linestore.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.LogDao;
import com.linestore.service.LogService;
import com.linestore.util.Page;
import com.linestore.vo.Log;

@Transactional
public class LogServiceImpl implements LogService {
	
	private LogDao logDao;

	@Override
	public void addLog(Log log) {
		logDao.addLog(log);
	}

	@Override
	public List<Log> queryByArea(int areaId, Page page) {
		return logDao.queryByArea(areaId, page);
	}

	@Override
	public int queryByAreaCount(int areaId) {
		return logDao.queryByAreaCount(areaId);
	}

	@Override
	public List<Log> queryByThu(int thuId, Page page) {
		return logDao.queryByThu(thuId, page);
	}

	@Override
	public int queryByThuCount(int thuId) {
		return logDao.queryByThuCount(thuId);
	}

	@Override
	public List<Log> queryByDate(Date beginTime, Date endTime, Page page) {
		return logDao.queryByDate(beginTime, endTime, page);
	}

	@Override
	public int queryByDateCount(Date beginTime, Date endTime) {
		return logDao.queryByDateCount(beginTime, endTime);
	}

	@Override
	public List<Log> queryByDateAndThu(Date beginTime, Date endTime, int thuId, Page page) {
		return logDao.queryByDateAndThu(beginTime, endTime, thuId, page);
	}

	@Override
	public int queryByDateAndThu(Date beginTime, Date endTime, int thuId) {
		return logDao.queryByDateAndThu(beginTime, endTime, thuId);
	}

	@Override
	public List<Log> queryByDateAndArea(Date beginTime, Date endTime, int areId, Page page) {
		return logDao.queryByDateAndArea(beginTime, endTime, areId, page);
	}

	@Override
	public int queryByDateAndArea(Date beginTime, Date endTime, int areId) {
		return logDao.queryByDateAndArea(beginTime, endTime, areId);
	}

	public LogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	@Override
	public int qureyAll() {
		// TODO Auto-generated method stub
		return logDao.qureyAll();
	}

	@Override
	public List<Log> selectAll() {
		// TODO Auto-generated method stub
		return logDao.selectAll();
	}
	
	

}
