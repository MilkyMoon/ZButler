package com.linestore.service;

import java.util.List;

import com.linestore.vo.Area;

public interface AreaService {
	
public void addArea(Area area);
	
	public void delArea(int areaId);
	
	public void updateArea(Area area);
	
	public void upadteArea(String hql);
	
	public void queryArea(List<Area> list, int pid, int level);
	
	public List<Area> queryByPid(int pid);
	
	public Area queryById(int id);

}
