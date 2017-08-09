package com.linestore.vo;

/**
 * SiteConfig entity. @author MyEclipse Persistence Tools
 */

public class SiteConfig implements java.io.Serializable {

	// Fields

	private Integer id;
	private String configName;
	private String configKey;
	private String configValue;

	// Constructors

	/** default constructor */
	public SiteConfig() {
	}

	/** full constructor */
	public SiteConfig(String configName, String configKey, String configValue) {
		this.configName = configName;
		this.configKey = configKey;
		this.configValue = configValue;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfigName() {
		return this.configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigKey() {
		return this.configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return this.configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

}