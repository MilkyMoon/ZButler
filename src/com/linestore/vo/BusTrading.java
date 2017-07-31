package com.linestore.vo;

import java.sql.Timestamp;

/**
 * BusTrading entity. @author MyEclipse Persistence Tools
 */

public class BusTrading implements java.io.Serializable {

	// Fields

	private String ctaId;
	private Business business;
	private Integer ctaType;
	private Float ctaMoney;
	private Timestamp ctaTime;

	// Constructors

	/** default constructor */
	public BusTrading() {
	}

	/** minimal constructor */
	public BusTrading(String ctaId) {
		this.ctaId = ctaId;
	}

	/** full constructor */
	public BusTrading(String ctaId, Business business, Integer ctaType, Float ctaMoney, Timestamp ctaTime) {
		this.ctaId = ctaId;
		this.business = business;
		this.ctaType = ctaType;
		this.ctaMoney = ctaMoney;
		this.ctaTime = ctaTime;
	}

	// Property accessors

	public String getCtaId() {
		return this.ctaId;
	}

	public void setCtaId(String ctaId) {
		this.ctaId = ctaId;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Integer getCtaType() {
		return this.ctaType;
	}

	public void setCtaType(Integer ctaType) {
		this.ctaType = ctaType;
	}

	public Float getCtaMoney() {
		return this.ctaMoney;
	}

	public void setCtaMoney(Float ctaMoney) {
		this.ctaMoney = ctaMoney;
	}

	public Timestamp getCtaTime() {
		return this.ctaTime;
	}

	public void setCtaTime(Timestamp ctaTime) {
		this.ctaTime = ctaTime;
	}

}