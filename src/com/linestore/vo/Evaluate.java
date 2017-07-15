package com.linestore.vo;

import java.sql.Timestamp;

/**
 * Evaluate entity. @author MyEclipse Persistence Tools
 */

public class Evaluate implements java.io.Serializable {

	// Fields

	private Integer evaId;
	private Order order;
	private Customer customer;
	private String evaContent;
	private Timestamp evaTime;
	private String evaThree;

	// Constructors

	/** default constructor */
	public Evaluate() {
	}

	/** full constructor */
	public Evaluate(Order order, Customer customer, String evaContent, Timestamp evaTime, String evaThree) {
		this.order = order;
		this.customer = customer;
		this.evaContent = evaContent;
		this.evaTime = evaTime;
		this.evaThree = evaThree;
	}

	// Property accessors

	public Integer getEvaId() {
		return this.evaId;
	}

	public void setEvaId(Integer evaId) {
		this.evaId = evaId;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getEvaContent() {
		return this.evaContent;
	}

	public void setEvaContent(String evaContent) {
		this.evaContent = evaContent;
	}

	public Timestamp getEvaTime() {
		return this.evaTime;
	}

	public void setEvaTime(Timestamp evaTime) {
		this.evaTime = evaTime;
	}

	public String getEvaThree() {
		return this.evaThree;
	}

	public void setEvaThree(String evaThree) {
		this.evaThree = evaThree;
	}

}