package com.linestore.vo;

/**
 * Setting entity. @author MyEclipse Persistence Tools
 */

public class Setting implements java.io.Serializable {

	// Fields

	private Integer setId;
	private String setField;
	private String setValue;

	// Constructors

	/** default constructor */
	public Setting() {
	}

	/** full constructor */
	public Setting(String setField, String setValue) {
		this.setField = setField;
		this.setValue = setValue;
	}

	// Property accessors

	public Integer getSetId() {
		return this.setId;
	}

	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	public String getSetField() {
		return this.setField;
	}

	public void setSetField(String setField) {
		this.setField = setField;
	}

	public String getSetValue() {
		return this.setValue;
	}

	public void setSetValue(String setValue) {
		this.setValue = setValue;
	}

}