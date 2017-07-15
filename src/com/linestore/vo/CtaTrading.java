package com.linestore.vo;

/**
 * CtaTrading entity. @author MyEclipse Persistence Tools
 */

public class CtaTrading implements java.io.Serializable {

	// Fields

	private Integer ctaId;
	private Customer customer;
	private Boolean ctaType;
	private Float ctaMoney;

	// Constructors

	/** default constructor */
	public CtaTrading() {
	}

	/** full constructor */
	public CtaTrading(Customer customer, Boolean ctaType, Float ctaMoney) {
		this.customer = customer;
		this.ctaType = ctaType;
		this.ctaMoney = ctaMoney;
	}

	// Property accessors

	public Integer getCtaId() {
		return this.ctaId;
	}

	public void setCtaId(Integer ctaId) {
		this.ctaId = ctaId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Boolean getCtaType() {
		return this.ctaType;
	}

	public void setCtaType(Boolean ctaType) {
		this.ctaType = ctaType;
	}

	public Float getCtaMoney() {
		return this.ctaMoney;
	}

	public void setCtaMoney(Float ctaMoney) {
		this.ctaMoney = ctaMoney;
	}

}