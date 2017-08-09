package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer grpId;
	private String grpTitle;
	private Integer grpStatus;
	private Integer grpAdmin;
	private String grpDesc;
	private Set thinkUsers = new HashSet(0);
	private Set ruleGroups = new HashSet(0);

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** full constructor */
	

	// Property accessors

	public Integer getGrpId() {
		return this.grpId;
	}

	public Group(Integer grpId, String grpTitle, Integer grpStatus, Integer grpAdmin, String grpDesc, Set thinkUsers,
			Set ruleGroups) {
		super();
		this.grpId = grpId;
		this.grpTitle = grpTitle;
		this.grpStatus = grpStatus;
		this.grpAdmin = grpAdmin;
		this.grpDesc = grpDesc;
		this.thinkUsers = thinkUsers;
		this.ruleGroups = ruleGroups;
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

	public Integer getGrpStatus() {
		return grpStatus;
	}

	public void setGrpStatus(Integer grpStatus) {
		this.grpStatus = grpStatus;
	}

	public Integer getGrpAdmin() {
		return grpAdmin;
	}

	public void setGrpAdmin(Integer grpAdmin) {
		this.grpAdmin = grpAdmin;
	}

	public String getGrpDesc() {
		return this.grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public Set getThinkUsers() {
		return this.thinkUsers;
	}

	public void setThinkUsers(Set thinkUsers) {
		this.thinkUsers = thinkUsers;
	}

	public Set getRuleGroups() {
		return this.ruleGroups;
	}

	public void setRuleGroups(Set ruleGroups) {
		this.ruleGroups = ruleGroups;
	}

}