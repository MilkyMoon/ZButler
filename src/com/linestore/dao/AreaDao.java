package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Area;

public interface AreaDao {
	
	public void addArea(Area area);
	
	public void delArea(int areaId);
	
	public void updateArea(Area area);
	
	public void upadteArea(String hql);
	
	public List<Area> queryArea(List<Area> list, int pid, int level);
	
	public List<Area> queryByPid(int pid);
	
	public Area queryById(int id);

	public List<Area> selectByKey(String keywords);
	
	public void updateMoney(String money, int id);
}
