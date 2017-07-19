package com.linestore.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BusCoupon entity. @author MyEclipse Persistence Tools
 */

public class BusCoupon implements java.io.Serializable {

	// Fields

	private Integer bcId;
	private Business business;
	private Date bcStartDate;
	private Date bcEndDate;
	private Integer bcStatus;
	private Integer bcCondition;
	private Integer bcRebate;
	private Integer bcCount;
	private Integer bcUserCount;
	private Set cusCoupons = new HashSet(0);

	// Constructors

	/** default constructor */
	public BusCoupon() {
	}

	/** full constructor */
	public BusCoupon(Business business, Date bcStartDate, Date bcEndDate, Integer bcStatus, Integer bcCondition,
			Integer bcRebate, Integer bcCount, Integer bcUserCount, Set cusCoupons) {
		this.business = business;
		this.bcStartDate = bcStartDate;
		this.bcEndDate = bcEndDate;
		this.bcStatus = bcStatus;
		this.bcCondition = bcCondition;
		this.bcRebate = bcRebate;
		this.bcCount = bcCount;
		this.bcUserCount = bcUserCount;
		this.cusCoupons = cusCoupons;
	}

	// Property accessors

	public Integer getBcId() {
		return this.bcId;
	}

	public void setBcId(Integer bcId) {
		this.bcId = bcId;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Date getBcStartDate() {
		return this.bcStartDate;
	}

	public void setBcStartDate(Date bcStartDate) {
		this.bcStartDate = bcStartDate;
	}

	public Date getBcEndDate() {
		return this.bcEndDate;
	}

	public void setBcEndDate(Date bcEndDate) {
		this.bcEndDate = bcEndDate;
	}

	public Integer getBcStatus() {
		return this.bcStatus;
	}

	public void setBcStatus(Integer bcStatus) {
		this.bcStatus = bcStatus;
	}

	public Integer getBcCondition() {
		return this.bcCondition;
	}

	public void setBcCondition(Integer bcCondition) {
		this.bcCondition = bcCondition;
	}

	public Integer getBcRebate() {
		return this.bcRebate;
	}

	public void setBcRebate(Integer bcRebate) {
		this.bcRebate = bcRebate;
	}

	public Integer getBcCount() {
		return this.bcCount;
	}

	public void setBcCount(Integer bcCount) {
		this.bcCount = bcCount;
	}

	public Integer getBcUserCount() {
		return this.bcUserCount;
	}

	public void setBcUserCount(Integer bcUserCount) {
		this.bcUserCount = bcUserCount;
	}

	public Set getCusCoupons() {
		return this.cusCoupons;
	}

	public void setCusCoupons(Set cusCoupons) {
		this.cusCoupons = cusCoupons;
	}

}