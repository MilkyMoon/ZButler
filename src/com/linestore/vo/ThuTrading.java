package com.linestore.vo;

import java.sql.Timestamp;

/**
 * ThuTrading entity. @author MyEclipse Persistence Tools
 */

public class ThuTrading implements java.io.Serializable {

	// Fields

	private String thtId;
	private Integer thuId;
	private Integer areId;
	private Float thuMoney;
	private Timestamp thtTime;
	private Integer thtStatus;

	// Constructors

	/** default constructor */
	public ThuTrading() {
	}

	/** full constructor */
	public ThuTrading(Integer thuId, Integer areId, Float thuMoney, Timestamp thtTime, Integer thtStatus) {
		this.thuId = thuId;
		this.areId = areId;
		this.thuMoney = thuMoney;
		this.thtTime = thtTime;
		this.thtStatus = thtStatus;
	}

	// Property accessors

	public String getThtId() {
		return this.thtId;
	}

	public void setThtId(String thtId) {
		this.thtId = thtId;
	}

	public Integer getThuId() {
		return this.thuId;
	}

	public void setThuId(Integer thuId) {
		this.thuId = thuId;
	}

	public Integer getAreId() {
		return this.areId;
	}

	public void setAreId(Integer areId) {
		this.areId = areId;
	}

	public Float getThuMoney() {
		return this.thuMoney;
	}

	public void setThuMoney(Float thuMoney) {
		this.thuMoney = thuMoney;
	}

	public Timestamp getThtTime() {
		return this.thtTime;
	}

	public void setThtTime(Timestamp thtTime) {
		this.thtTime = thtTime;
	}

	public Integer getThtStatus() {
		return this.thtStatus;
	}

	public void setThtStatus(Integer thtStatus) {
		this.thtStatus = thtStatus;
	}

}