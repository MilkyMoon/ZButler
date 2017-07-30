package com.linestore.vo;

import java.sql.Timestamp;

/**
 * Rule entity. @author MyEclipse Persistence Tools
 */

public class Rule implements java.io.Serializable {

	// Fields

	private Short id;
	private String rules;
	private String title;
	private Boolean type;
	private Boolean status;
	private String condition;
	private Timestamp createTime;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public Rule() {
	}

	/** full constructor */
	public Rule(String rules, String title, Boolean type, Boolean status, String condition, Timestamp createTime,
			Timestamp updateTime) {
		this.rules = rules;
		this.title = title;
		this.type = type;
		this.status = status;
		this.condition = condition;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getRules() {
		return this.rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getType() {
		return this.type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}