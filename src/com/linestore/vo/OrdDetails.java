package com.linestore.vo;

/**
 * OrdDetails entity. @author MyEclipse Persistence Tools
 */

public class OrdDetails implements java.io.Serializable {

	// Fields

	private Integer odeId;
	private Order order;
	private Sku sku;
	private Integer odeTotalMoney;
	private Float odePrice;
	private Integer odeNum;
	private Float odeMoney;

	// Constructors

	/** default constructor */
	public OrdDetails() {
	}

	/** full constructor */
	public OrdDetails(Order order, Sku sku, Integer odeTotalMoney, Float odePrice, Integer odeNum, Float odeMoney) {
		this.order = order;
		this.sku = sku;
		this.odeTotalMoney = odeTotalMoney;
		this.odePrice = odePrice;
		this.odeNum = odeNum;
		this.odeMoney = odeMoney;
	}

	// Property accessors

	public Integer getOdeId() {
		return this.odeId;
	}

	public void setOdeId(Integer odeId) {
		this.odeId = odeId;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Sku getSku() {
		return this.sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public Integer getOdeTotalMoney() {
		return this.odeTotalMoney;
	}

	public void setOdeTotalMoney(Integer odeTotalMoney) {
		this.odeTotalMoney = odeTotalMoney;
	}

	public Float getOdePrice() {
		return this.odePrice;
	}

	public void setOdePrice(Float odePrice) {
		this.odePrice = odePrice;
	}

	public Integer getOdeNum() {
		return this.odeNum;
	}

	public void setOdeNum(Integer odeNum) {
		this.odeNum = odeNum;
	}

	public Float getOdeMoney() {
		return this.odeMoney;
	}

	public void setOdeMoney(Float odeMoney) {
		this.odeMoney = odeMoney;
	}

}