package com.linestore.vo;

/**
 * CusCoupon entity. @author MyEclipse Persistence Tools
 */

public class CusCoupon implements java.io.Serializable {

	// Fields

	private Integer ccId;
	private BusCoupon busCoupon;
	private Customer customer;
	private Boolean ccStatus;

	// Constructors

	/** default constructor */
	public CusCoupon() {
	}

	/** full constructor */
	public CusCoupon(BusCoupon busCoupon, Customer customer, Boolean ccStatus) {
		this.busCoupon = busCoupon;
		this.customer = customer;
		this.ccStatus = ccStatus;
	}

	// Property accessors

	public Integer getCcId() {
		return this.ccId;
	}

	public void setCcId(Integer ccId) {
		this.ccId = ccId;
	}

	public BusCoupon getBusCoupon() {
		return this.busCoupon;
	}

	public void setBusCoupon(BusCoupon busCoupon) {
		this.busCoupon = busCoupon;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Boolean getCcStatus() {
		return this.ccStatus;
	}

	public void setCcStatus(Boolean ccStatus) {
		this.ccStatus = ccStatus;
	}

}