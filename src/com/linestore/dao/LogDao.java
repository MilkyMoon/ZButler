package com.linestore.dao;

import java.util.Date;
import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Log;

public interface LogDao {
	
	public void addLog(Log log);
	
	public List<Log> queryByArea(int areaId, Page page);
	
	public int queryByAreaCount(int areaId);
	
	public List<Log> queryByThu(int thuId, Page page);
	
	public int queryByThuCount(int thuId);
	
	public List<Log> queryByDate(Date beginTime, Date endTime, Page page);
	
	public int queryByDateCount(Date beginTime, Date endTime);
	
	public List<Log> queryByDateAndThu(Date beginTime, Date endTime, int thuId, Page page);
	
	public int queryByDateAndThu(Date beginTime, Date endTime, int thuId);
	
	public List<Log> queryByDateAndArea(Date beginTime, Date endTime, int areId, Page page);
	
	public int queryByDateAndArea(Date beginTime, Date endTime, int areId);

}
