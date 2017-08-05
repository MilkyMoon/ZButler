package com.linestore.vo;

import java.sql.Timestamp;

/**
 * BusMember entity. @author MyEclipse Persistence Tools
 */

public class BusMember implements java.io.Serializable {

	// Fields

	private Integer bmeId;
	private Business business;
	private String bmeOpenId;
	private Timestamp bmeDate;
	private Integer bmeType;

	// Constructors

	/** default constructor */
	public BusMember() {
	}

	/** full constructor */
	public BusMember(Business business, String bmeOpenId, Timestamp bmeDate, Integer bmeType) {
		this.business = business;
		this.bmeOpenId = bmeOpenId;
		this.bmeDate = bmeDate;
		this.bmeType = bmeType;
	}

	// Property accessors

	public Integer getBmeId() {
		return this.bmeId;
	}

	public void setBmeId(Integer bmeId) {
		this.bmeId = bmeId;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public String getBmeOpenId() {
		return this.bmeOpenId;
	}

	public void setBmeOpenId(String bmeOpenId) {
		this.bmeOpenId = bmeOpenId;
	}

	public Timestamp getBmeDate() {
		return this.bmeDate;
	}

	public void setBmeDate(Timestamp bmeDate) {
		this.bmeDate = bmeDate;
	}

	public Integer getBmeType() {
		return this.bmeType;
	}

	public void setBmeType(Integer bmeType) {
		this.bmeType = bmeType;
	}

}