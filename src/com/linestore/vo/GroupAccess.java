package com.linestore.vo;
// default package

/**
 * GroupAccess entity. @author MyEclipse Persistence Tools
 */

public class GroupAccess implements java.io.Serializable {

	// Fields

	private Integer id;
	private ThinkUser thinkUser;
	private Integer groupid;

	// Constructors

	/** default constructor */
	public GroupAccess() {
	}

	/** full constructor */
	public GroupAccess(ThinkUser thinkUser, Integer groupid) {
		this.thinkUser = thinkUser;
		this.groupid = groupid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ThinkUser getThinkUser() {
		return this.thinkUser;
	}

	public void setThinkUser(ThinkUser thinkUser) {
		this.thinkUser = thinkUser;
	}

	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

}