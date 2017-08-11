package com.linestore.service;

import java.util.List;

import com.linestore.vo.Setting;

public interface SettingService {
	
	public Setting queryById(int setId);
	
	public void update(String hql);
	
	public List<Setting> queryAll();

}
