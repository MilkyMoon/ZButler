package com.linestore.vo;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer grpId;
	private String grpTitle;
	private String grpStatus;
	private String grpRules;
	private String grpDesc;

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** full constructor */
	public Group(String grpTitle, String grpStatus, String grpRules, String grpDesc) {
		this.grpTitle = grpTitle;
		this.grpStatus = grpStatus;
		this.grpRules = grpRules;
		this.grpDesc = grpDesc;
	}

	// Property accessors

	public Integer getGrpId() {
		return this.grpId;
	}

	public void setGrpId(Integer grpId) {
		this.grpId = grpId;
	}

	public String getGrpTitle() {
		return this.grpTitle;
	}

	public void setGrpTitle(String grpTitle) {
		this.grpTitle = grpTitle;
	}

	public String getGrpStatus() {
		return this.grpStatus;
	}

	public void setGrpStatus(String grpStatus) {
		this.grpStatus = grpStatus;
	}

	public String getGrpRules() {
		return this.grpRules;
	}

	public void setGrpRules(String grpRules) {
		this.grpRules = grpRules;
	}

	public String getGrpDesc() {
		return this.grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

}