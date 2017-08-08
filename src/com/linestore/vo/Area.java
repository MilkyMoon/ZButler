package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer areId;
	private Integer pid;
	private String area;
	private String desction;
	private Integer status;
	private Float areaScale;
	private Float areaScaleTwo;
	private Integer areaWay;
	private Set billsForThuCountyId = new HashSet(0);
	private Set thinkUsers = new HashSet(0);
	private Set billsForThuProvinceId = new HashSet(0);
	private Set billsForThuPropertyId = new HashSet(0);
	private Set businesses = new HashSet(0);
	private Set billsForThuCityId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}
	
	public Area(Area are) {
		this.areId = are.getAreId();
		this.pid = are.getPid();
		this.area = are.getArea();
		this.desction = are.getDesction();
		this.status = are.getStatus();
		this.areaScale = are.getAreaScale();
		this.areaScaleTwo = are.getAreaScaleTwo();
		this.areaWay = are.getAreaWay();
		this.thinkUsers = are.getThinkUsers();
		this.businesses = are.getBusinesses();
		this.billsForThuCountyId = are.getBillsForThuCountyId();
		this.billsForThuProvinceId = are.getBillsForThuProvinceId();
		this.billsForThuPropertyId = are.getBillsForThuPropertyId();
		this.billsForThuCityId = are.getBillsForThuCityId();
	}

	/** full constructor */
	public Area(Integer pid, String area, String desction, Integer status, Float areaScale, Float areaScaleTwo,
			Integer areaWay, Set billsForThuCountyId, Set thinkUsers, Set billsForThuProvinceId,
			Set billsForThuPropertyId, Set businesses, Set billsForThuCityId) {
		this.pid = pid;
		this.area = area;
		this.desction = desction;
		this.status = status;
		this.areaScale = areaScale;
		this.areaScaleTwo = areaScaleTwo;
		this.areaWay = areaWay;
		this.billsForThuCountyId = billsForThuCountyId;
		this.thinkUsers = thinkUsers;
		this.billsForThuProvinceId = billsForThuProvinceId;
		this.billsForThuPropertyId = billsForThuPropertyId;
		this.businesses = businesses;
		this.billsForThuCityId = billsForThuCityId;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public Integer getAreId() {
		return areId;
	}

	public void setAreId(Integer areId) {
		this.areId = areId;
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

	public String getDesction() {
		return this.desction;
	}

	public void setDesction(String desction) {
		this.desction = desction;
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

	public Set getBillsForThuCountyId() {
		return this.billsForThuCountyId;
	}

	public void setBillsForThuCountyId(Set billsForThuCountyId) {
		this.billsForThuCountyId = billsForThuCountyId;
	}

	public Set getThinkUsers() {
		return this.thinkUsers;
	}

	public void setThinkUsers(Set thinkUsers) {
		this.thinkUsers = thinkUsers;
	}

	public Set getBillsForThuProvinceId() {
		return this.billsForThuProvinceId;
	}

	public void setBillsForThuProvinceId(Set billsForThuProvinceId) {
		this.billsForThuProvinceId = billsForThuProvinceId;
	}

	public Set getBillsForThuPropertyId() {
		return this.billsForThuPropertyId;
	}

	public void setBillsForThuPropertyId(Set billsForThuPropertyId) {
		this.billsForThuPropertyId = billsForThuPropertyId;
	}

	public Set getBusinesses() {
		return this.businesses;
	}

	public void setBusinesses(Set businesses) {
		this.businesses = businesses;
	}

	public Set getBillsForThuCityId() {
		return this.billsForThuCityId;
	}

	public void setBillsForThuCityId(Set billsForThuCityId) {
		this.billsForThuCityId = billsForThuCityId;
	}

}