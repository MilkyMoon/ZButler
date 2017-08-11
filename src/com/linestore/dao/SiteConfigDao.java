package com.linestore.dao;

import java.util.List;

import com.linestore.vo.SiteConfig;

public interface SiteConfigDao {
	public List<SiteConfig> selectByConfigName(String configName);

	public void delConfig(int id);

	public void updateConfig(SiteConfig sc);

	public void addConfig(SiteConfig config);
	
	public SiteConfig selectById(int id);

}
