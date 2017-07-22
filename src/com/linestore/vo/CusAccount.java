package com.linestore.vo;

/**
 * CusAccount entity. @author MyEclipse Persistence Tools
 */

public class CusAccount implements java.io.Serializable {

	// Fields

	private Integer cacId;
	private Customer customer;
	private Float cacChange;
	private Float cacPoints;
	private Float cacBonus;

	// Constructors

	public Float getCacBonus() {
		return cacBonus;
	}

	public void setCacBonus(Float cacBonus) {
		this.cacBonus = cacBonus;
	}

	/** default constructor */
	public CusAccount() {
	}

	/** full constructor */
	public CusAccount(Customer customer, Float cacChange, Float cacPoints, Float cacBonus) {
		this.customer = customer;
		this.cacChange = cacChange;
		this.cacPoints = cacPoints;
		this.cacBonus = cacBonus;
	}

	// Property accessors

	public Integer getCacId() {
		return this.cacId;
	}

	public void setCacId(Integer cacId) {
		this.cacId = cacId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Float getCacChange() {
		return this.cacChange;
	}

	public void setCacChange(Float cacChange) {
		this.cacChange = cacChange;
	}

	public Float getCacPoints() {
		return this.cacPoints;
	}

	public void setCacPoints(Float d) {
		this.cacPoints =  d;
	}

}