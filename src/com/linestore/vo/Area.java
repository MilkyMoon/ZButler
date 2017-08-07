package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer pid;
	private String area;
	private String desc;
	private Integer status;
	private Set thinkUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** full constructor */
	public Area(Integer pid, String area, String desc, Integer status, Set thinkUsers) {
		this.pid = pid;
		this.area = area;
		this.desc = desc;
		this.status = status;
		this.thinkUsers = thinkUsers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getThinkUsers() {
		return this.thinkUsers;
	}

	public void setThinkUsers(Set thinkUsers) {
		this.thinkUsers = thinkUsers;
	}

}