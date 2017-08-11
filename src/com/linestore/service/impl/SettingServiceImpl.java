package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.SettingDao;
import com.linestore.service.SettingService;
import com.linestore.vo.Setting;

@Transactional
public class SettingServiceImpl implements SettingService {
	private SettingDao settingDao;

	@Override
	public Setting queryById(int setId) {
		return settingDao.queryById(setId);
	}

	public void update(String hql) {
		settingDao.update(hql);
	}
	
	public SettingDao getSettingDao() {
		return settingDao;
	}

	public void setSettingDao(SettingDao settingDao) {
		this.settingDao = settingDao;
	}

	@Override
	public List<Setting> queryAll() {
		return settingDao.queryAll();
	}
}
