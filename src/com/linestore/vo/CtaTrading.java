package com.linestore.vo;

import java.sql.Timestamp;

/**
 * CtaTrading entity. @author MyEclipse Persistence Tools
 */

public class CtaTrading implements java.io.Serializable {

	// Fields

	private String ctaId;
	private Customer customer;
	private Integer ctaType;
	private Float ctaMoney;
	private Timestamp ctaTime;

	// Constructors

	/** default constructor */
	public CtaTrading() {
	}

	/** minimal constructor */
	public CtaTrading(String ctaId) {
		this.ctaId = ctaId;
	}

	/** full constructor */
	public CtaTrading(String ctaId, Customer customer, Integer ctaType, Float ctaMoney, Timestamp ctaTime) {
		this.ctaId = ctaId;
		this.customer = customer;
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

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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