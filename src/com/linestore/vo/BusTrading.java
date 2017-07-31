package com.linestore.vo;

import java.sql.Timestamp;

/**
 * BusTrading entity. @author MyEclipse Persistence Tools
 */

public class BusTrading implements java.io.Serializable {

	// Fields

	private String btaId;
	private Business business;
	private Integer btaType;
	private Float btaMoney;
	private Timestamp btaTime;
	private String btaAddress;
	// Constructors

	/** default constructor */
	public BusTrading() {
	}

	/** minimal constructor */
	public BusTrading(String btaId) {
		this.btaId = btaId;
	}

	/** full constructor */
	public BusTrading(String btaId, Business business, Integer btaType, Float btaMoney, Timestamp btaTime) {
		this.btaId = btaId;
		this.business = business;
		this.btaType = btaType;
		this.btaMoney = btaMoney;
		this.btaTime = btaTime;
	}

	// Property accessors

	public String getBtaId() {
		return this.btaId;
	}

	public void setBtaId(String btaId) {
		this.btaId = btaId;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Integer getBtaType() {
		return this.btaType;
	}

	public void setBtaType(Integer btaType) {
		this.btaType = btaType;
	}

	public Float getBtaMoney() {
		return this.btaMoney;
	}

	public void setBtaMoney(Float btaMoney) {
		this.btaMoney = btaMoney;
	}

	public Timestamp getBtaTime() {
		return this.btaTime;
	}

	public void setBtaTime(Timestamp btaTime) {
		this.btaTime = btaTime;
	}

	public String getBtaAddress() {
		return btaAddress;
	}

	public void setBtaAddress(String btaAddress) {
		this.btaAddress = btaAddress;
	}
	
	
}