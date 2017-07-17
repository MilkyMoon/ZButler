package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Sku entity. @author MyEclipse Persistence Tools
 */

public class Sku implements java.io.Serializable {

	// Fields

	private Integer skuId;
	private Goods goods;
	private Integer skuNum;
	private Float skuPrice;
	private Boolean skuStatus;
	private String skuName;
	private String skuProperties;
	private Set ordDetailses = new HashSet(0);
	private Set proattributes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sku() {
	}

	/** full constructor */
	public Sku(Goods goods, Integer skuNum, Float skuPrice, Boolean skuStatus, String skuName, String skuProperties,
			Set ordDetailses, Set proattributes) {
		this.goods = goods;
		this.skuNum = skuNum;
		this.skuPrice = skuPrice;
		this.skuStatus = skuStatus;
		this.skuName = skuName;
		this.skuProperties = skuProperties;
		this.ordDetailses = ordDetailses;
		this.proattributes = proattributes;
	}

	// Property accessors

	public Integer getSkuId() {
		return this.skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getSkuNum() {
		return this.skuNum;
	}

	public void setSkuNum(Integer skuNum) {
		this.skuNum = skuNum;
	}

	public Float getSkuPrice() {
		return this.skuPrice;
	}

	public void setSkuPrice(Float skuPrice) {
		this.skuPrice = skuPrice;
	}

	public Boolean getSkuStatus() {
		return this.skuStatus;
	}

	public void setSkuStatus(Boolean skuStatus) {
		this.skuStatus = skuStatus;
	}

	public String getSkuName() {
		return this.skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuProperties() {
		return this.skuProperties;
	}

	public void setSkuProperties(String skuProperties) {
		this.skuProperties = skuProperties;
	}

	public Set getOrdDetailses() {
		return this.ordDetailses;
	}

	public void setOrdDetailses(Set ordDetailses) {
		this.ordDetailses = ordDetailses;
	}

	public Set getProattributes() {
		return this.proattributes;
	}

	public void setProattributes(Set proattributes) {
		this.proattributes = proattributes;
	}

}