package com.linestore.vo;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer mesId;
	private Customer customer;
	private String mesTitle;
	private Boolean mesType;
	private String mesContent;
	private Timestamp mesTime;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Customer customer, String mesTitle, Boolean mesType, String mesContent, Timestamp mesTime) {
		this.customer = customer;
		this.mesTitle = mesTitle;
		this.mesType = mesType;
		this.mesContent = mesContent;
		this.mesTime = mesTime;
	}

	// Property accessors

	public Integer getMesId() {
		return this.mesId;
	}

	public void setMesId(Integer mesId) {
		this.mesId = mesId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getMesTitle() {
		return this.mesTitle;
	}

	public void setMesTitle(String mesTitle) {
		this.mesTitle = mesTitle;
	}

	public Boolean getMesType() {
		return this.mesType;
	}

	public void setMesType(Boolean mesType) {
		this.mesType = mesType;
	}

	public String getMesContent() {
		return this.mesContent;
	}

	public void setMesContent(String mesContent) {
		this.mesContent = mesContent;
	}

	public Timestamp getMesTime() {
		return this.mesTime;
	}

	public void setMesTime(Timestamp mesTime) {
		this.mesTime = mesTime;
	}

}