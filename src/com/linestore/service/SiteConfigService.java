package com.linestore.service;

import java.util.List;

import com.linestore.vo.SiteConfig;

public interface SiteConfigService {
	public List<SiteConfig> selectCusConfig(String configName);

	public void selectAdvConfig(String configName);

	public void delCusConfig(int id);

	public void updateCusConfig(SiteConfig sc);

	public void addCusConfig(SiteConfig siteConfig);
	
	public SiteConfig selectById(int id);
}
