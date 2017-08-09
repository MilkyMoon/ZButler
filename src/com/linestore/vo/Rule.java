package com.linestore.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Rule entity. @author MyEclipse Persistence Tools
 */

public class Rule implements java.io.Serializable {

	// Fields

	private Integer rulId;
	private String rules;
	private String title;
	private Integer type;
	private Integer status;
	private String condition;
	private Set ruleGroups = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rule() {
	}

	/** minimal constructor */
	public Rule(String rules, String title, Integer type, Integer status, String condition) {
		this.rules = rules;
		this.title = title;
		this.type = type;
		this.status = status;
		this.condition = condition;
	}

	/** full constructor */
	public Rule(String rules, String title, Integer type, Integer status, String condition,
			Set ruleGroups) {
		this.rules = rules;
		this.title = title;
		this.type = type;
		this.status = status;
		this.condition = condition;
		this.ruleGroups = ruleGroups;
	}

	// Property accessors

	public Integer getRulId() {
		return this.rulId;
	}

	public void setRulId(Integer rulId) {
		this.rulId = rulId;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}


	public Set getRuleGroups() {
		return this.ruleGroups;
	}

	public void setRuleGroups(Set ruleGroups) {
		this.ruleGroups = ruleGroups;
	}

}