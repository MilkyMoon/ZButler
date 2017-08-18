package com.linestore.vo;

import java.sql.Timestamp;

/**
 * Transfer entity. @author MyEclipse Persistence Tools
 */

public class Transfer implements java.io.Serializable {

	// Fields

	private Integer traId;
	private Business business;
	private ThinkUser thinkUser;
	private Timestamp traDate;
	private Float traMoney;

	// Constructors

	/** default constructor */
	public Transfer() {
	}

	/** full constructor */
	public Transfer(Business business, ThinkUser thinkUser, Timestamp traDate, Float traMoney) {
		this.business = business;
		this.thinkUser = thinkUser;
		this.traDate = traDate;
		this.traMoney = traMoney;
	}

	// Property accessors

	public Integer getTraId() {
		return this.traId;
	}

	public void setTraId(Integer traId) {
		this.traId = traId;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public ThinkUser getThinkUser() {
		return this.thinkUser;
	}

	public void setThinkUser(ThinkUser thinkUser) {
		this.thinkUser = thinkUser;
	}

	public Timestamp getTraDate() {
		return this.traDate;
	}

	public void setTraDate(Timestamp traDate) {
		this.traDate = traDate;
	}

	public Float getTraMoney() {
		return this.traMoney;
	}

	public void setTraMoney(Float traMoney) {
		this.traMoney = traMoney;
	}

}