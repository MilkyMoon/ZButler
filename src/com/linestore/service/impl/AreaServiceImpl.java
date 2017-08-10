package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.AreaDao;
import com.linestore.service.AreaService;
import com.linestore.vo.Area;

@Transactional
public class AreaServiceImpl implements AreaService {
	
	private AreaDao areaDao;

	@Override
	public void addArea(Area area) {
		areaDao.addArea(area);
	}

	@Override
	public void delArea(int areaId) {
		areaDao.delArea(areaId);
	}

	@Override
	public void updateArea(Area area) {
		areaDao.updateArea(area);
	}

	@Override
	public void upadteArea(String hql) {
		areaDao.upadteArea(hql);
	}

	@Override
	public List<Area> queryByPid(int pid) {
		return areaDao.queryByPid(pid);
	}
	
	@Override
	public void queryArea(List<Area> list, int pid, int level) {
		areaDao.queryArea(list, pid, level);
	}

	@Override
	public Area queryById(int id) {
		return areaDao.queryById(id);
	}
	
	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	@Override
	public List<Area> selectByKey(String keywords) {
		// TODO Auto-generated method stub
		return areaDao.selectByKey(keywords);
	}

	@Override
	public void updateMoney(String money, int id) {
		areaDao.updateMoney(money, id);
	}

}
