package com.linestore.vo;

/**
 * RuleGroup entity. @author MyEclipse Persistence Tools
 */

public class RuleGroup implements java.io.Serializable {

	// Fields

	private Integer rgId;
	private Group group;
	private Rule rule;

	// Constructors

	/** default constructor */
	public RuleGroup() {
	}

	/** full constructor */
	public RuleGroup(Group group, Rule rule) {
		this.group = group;
		this.rule = rule;
	}

	// Property accessors

	public Integer getRgId() {
		return this.rgId;
	}

	public void setRgId(Integer rgId) {
		this.rgId = rgId;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Rule getRule() {
		return this.rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

}