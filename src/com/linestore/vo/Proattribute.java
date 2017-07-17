package com.linestore.vo;

import java.sql.Timestamp;

/**
 * Proattribute entity. @author MyEclipse Persistence Tools
 */

public class Proattribute implements java.io.Serializable {

	// Fields

	private Integer patId;
	private Sku sku;
	private Attribute attribute;
	private AttValue attValue;
	private Goods goods;
	private Boolean patIssku;
	private Timestamp patCreateDate;

	// Constructors

	/** default constructor */
	public Proattribute() {
	}

	/** full constructor */
	public Proattribute(Sku sku, Attribute attribute, AttValue attValue, Goods goods, Boolean patIssku,
			Timestamp patCreateDate) {
		this.sku = sku;
		this.attribute = attribute;
		this.attValue = attValue;
		this.goods = goods;
		this.patIssku = patIssku;
		this.patCreateDate = patCreateDate;
	}

	// Property accessors

	public Integer getPatId() {
		return this.patId;
	}

	public void setPatId(Integer patId) {
		this.patId = patId;
	}

	public Sku getSku() {
		return this.sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public AttValue getAttValue() {
		return this.attValue;
	}

	public void setAttValue(AttValue attValue) {
		this.attValue = attValue;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Boolean getPatIssku() {
		return this.patIssku;
	}

	public void setPatIssku(Boolean patIssku) {
		this.patIssku = patIssku;
	}

	public Timestamp getPatCreateDate() {
		return this.patCreateDate;
	}

	public void setPatCreateDate(Timestamp patCreateDate) {
		this.patCreateDate = patCreateDate;
	}

}