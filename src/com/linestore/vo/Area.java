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
	private Float areaScale;
	private Float areaScaleTwo;
	private Integer areaWay;
	private Set thinkUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}
	
	public Area(Area areas) {
		this.pid = areas.getId();
		this.area = areas.getArea();
		this.desc = areas.getDesc();
		this.status = areas.getStatus();
		this.areaScale = areas.getAreaScale();
		this.areaScaleTwo = areas.getAreaScaleTwo();
		this.areaWay = areas.getAreaWay();
		this.thinkUsers = areas.getThinkUsers();
	}

	/** full constructor */
	public Area(Integer pid, String area, String desc, Integer status, Float areaScale, Float areaScaleTwo,
			Integer areaWay, Set thinkUsers) {
		this.pid = pid;
		this.area = area;
		this.desc = desc;
		this.status = status;
		this.areaScale = areaScale;
		this.areaScaleTwo = areaScaleTwo;
		this.areaWay = areaWay;
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

	public Float getAreaScale() {
		return this.areaScale;
	}

	public void setAreaScale(Float areaScale) {
		this.areaScale = areaScale;
	}

	public Float getAreaScaleTwo() {
		return this.areaScaleTwo;
	}

	public void setAreaScaleTwo(Float areaScaleTwo) {
		this.areaScaleTwo = areaScaleTwo;
	}

	public Integer getAreaWay() {
		return this.areaWay;
	}

	public void setAreaWay(Integer areaWay) {
		this.areaWay = areaWay;
	}

	public Set getThinkUsers() {
		return this.thinkUsers;
	}

	public void setThinkUsers(Set thinkUsers) {
		this.thinkUsers = thinkUsers;
	}

}