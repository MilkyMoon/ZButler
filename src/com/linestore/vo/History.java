package com.linestore.vo;

import java.sql.Timestamp;

/**
 * History entity. @author MyEclipse Persistence Tools
 */

public class History implements java.io.Serializable {

	// Fields

	private Integer hisId;
	private Goods goods;
	private Customer customer;
	private Timestamp hisTime;

	// Constructors

	/** default constructor */
	public History() {
	}

	/** full constructor */
	public History(Goods goods, Customer customer, Timestamp hisTime) {
		this.goods = goods;
		this.customer = customer;
		this.hisTime = hisTime;
	}

	// Property accessors

	public Integer getHisId() {
		return this.hisId;
	}

	public void setHisId(Integer hisId) {
		this.hisId = hisId;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Timestamp getHisTime() {
		return this.hisTime;
	}

	public void setHisTime(Timestamp hisTime) {
		this.hisTime = hisTime;
	}

}