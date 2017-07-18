package com.linestore.vo;

import java.sql.Timestamp;

/**
 * Friends entity. @author MyEclipse Persistence Tools
 */

public class Friends implements java.io.Serializable {

	// Fields

	private Integer friId;
	private Customer customer;
	private Integer friType;
	private String friPhone;
	private Timestamp friDate;

	// Constructors

	/** default constructor */
	public Friends() {
	}

	/** full constructor */
	public Friends(Customer customer, Integer friType, String friPhone, Timestamp friDate) {
		this.customer = customer;
		this.friType = friType;
		this.friPhone = friPhone;
		this.friDate = friDate;
	}

	// Property accessors

	public Integer getFriId() {
		return this.friId;
	}

	public void setFriId(Integer friId) {
		this.friId = friId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public Integer getFriType() {
		return friType;
	}

	public void setFriType(Integer friType) {
		this.friType = friType;
	}

	public String getFriPhone() {
		return this.friPhone;
	}

	public void setFriPhone(String friPhone) {
		this.friPhone = friPhone;
	}

	public Timestamp getFriDate() {
		return this.friDate;
	}

	public void setFriDate(Timestamp friDate) {
		this.friDate = friDate;
	}

}