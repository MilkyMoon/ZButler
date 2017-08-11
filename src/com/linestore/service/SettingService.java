package com.linestore.service;

import com.linestore.vo.Setting;

public interface SettingService {
	
	public Setting queryById(int setId);
	
	public void update(String hql);

}
