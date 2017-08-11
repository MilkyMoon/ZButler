package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Setting;

public interface SettingDao {
	
	public Setting queryById(int setId);
	
	public void update(String hql);
	
	public List<Setting> queryAll();

}
