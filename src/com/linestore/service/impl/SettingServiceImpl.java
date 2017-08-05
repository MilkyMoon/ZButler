package com.linestore.service.impl;

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

	public SettingDao getSettingDao() {
		return settingDao;
	}

	public void setSettingDao(SettingDao settingDao) {
		this.settingDao = settingDao;
	}
	
	
}