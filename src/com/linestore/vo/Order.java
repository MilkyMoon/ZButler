package com.linestore.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer ordId;
	private Customer customer;
	private Boolean ordStatus;
	private Timestamp ordPayTime;
	private Timestamp ordStartTime;
	private Integer ordStaging;
	private Boolean ordType;
	private Float ordTotal;
	private Float ordMoney;
	private Boolean ordComfire;
	private Set ordDetailses = new HashSet(0);
	private Set evaluates = new HashSet(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Customer customer, Boolean ordStatus, Timestamp ordPayTime, Timestamp ordStartTime, Integer ordStaging,
			Boolean ordType, Float ordTotal, Float ordMoney, Boolean ordComfire, Set ordDetailses, Set evaluates) {
		this.customer = customer;
		this.ordStatus = ordStatus;
		this.ordPayTime = ordPayTime;
		this.ordStartTime = ordStartTime;
		this.ordStaging = ordStaging;
		this.ordType = ordType;
		this.ordTotal = ordTotal;
		this.ordMoney = ordMoney;
		this.ordComfire = ordComfire;
		this.ordDetailses = ordDetailses;
		this.evaluates = evaluates;
	}

	// Property accessors

	public Integer getOrdId() {
		return this.ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Boolean getOrdStatus() {
		return this.ordStatus;
	}

	public void setOrdStatus(Boolean ordStatus) {
		this.ordStatus = ordStatus;
	}

	public Timestamp getOrdPayTime() {
		return this.ordPayTime;
	}

	public void setOrdPayTime(Timestamp ordPayTime) {
		this.ordPayTime = ordPayTime;
	}

	public Timestamp getOrdStartTime() {
		return this.ordStartTime;
	}

	public void setOrdStartTime(Timestamp ordStartTime) {
		this.ordStartTime = ordStartTime;
	}

	public Integer getOrdStaging() {
		return this.ordStaging;
	}

	public void setOrdStaging(Integer ordStaging) {
		this.ordStaging = ordStaging;
	}

	public Boolean getOrdType() {
		return this.ordType;
	}

	public void setOrdType(Boolean ordType) {
		this.ordType = ordType;
	}

	public Float getOrdTotal() {
		return this.ordTotal;
	}

	public void setOrdTotal(Float ordTotal) {
		this.ordTotal = ordTotal;
	}

	public Float getOrdMoney() {
		return this.ordMoney;
	}

	public void setOrdMoney(Float ordMoney) {
		this.ordMoney = ordMoney;
	}

	public Boolean getOrdComfire() {
		return this.ordComfire;
	}

	public void setOrdComfire(Boolean ordComfire) {
		this.ordComfire = ordComfire;
	}

	public Set getOrdDetailses() {
		return this.ordDetailses;
	}

	public void setOrdDetailses(Set ordDetailses) {
		this.ordDetailses = ordDetailses;
	}

	public Set getEvaluates() {
		return this.evaluates;
	}

	public void setEvaluates(Set evaluates) {
		this.evaluates = evaluates;
	}

}