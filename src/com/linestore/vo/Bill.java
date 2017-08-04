package com.linestore.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Bill entity. @author MyEclipse Persistence Tools
 */

import java.math.BigDecimal;

public class Bill implements java.io.Serializable {

	// Fields

	private Integer bilId;
	private Business business;
	private ThinkUser thinkUserByThuProvinceId;
	private ThinkUser thinkUserByThuCityId;
	private Customer customer;
	private ThinkUser thinkUserByThuCountyId;
	private ThinkUser thinkUserByThuPropertyId;
	private BigDecimal bilCusMoney;
	private BigDecimal bilBusMoney;
	private BigDecimal bilPropertyMoney;
	private BigDecimal bilCountyMoney;
	private BigDecimal bilCityMoney;
	private BigDecimal bilProvinceMoney;
	private Timestamp bilDate;
	private BigDecimal bilZongMoney;

	// Constructors

	/** default constructor */
	public Bill() {
	}

	/** full constructor */
	public Bill(Business business, ThinkUser thinkUserByThuProvinceId, ThinkUser thinkUserByThuCityId,
			Customer customer, ThinkUser thinkUserByThuCountyId, ThinkUser thinkUserByThuPropertyId, BigDecimal bilCusMoney,
			BigDecimal bilBusMoney, BigDecimal bilPropertyMoney, BigDecimal bilCountyMoney, BigDecimal bilCityMoney,
			BigDecimal bilProvinceMoney, Timestamp bilDate, BigDecimal bilZongMoney) {
		this.business = business;
		this.thinkUserByThuProvinceId = thinkUserByThuProvinceId;
		this.thinkUserByThuCityId = thinkUserByThuCityId;
		this.customer = customer;
		this.thinkUserByThuCountyId = thinkUserByThuCountyId;
		this.thinkUserByThuPropertyId = thinkUserByThuPropertyId;
		this.bilCusMoney = bilCusMoney;
		this.bilBusMoney = bilBusMoney;
		this.bilPropertyMoney = bilPropertyMoney;
		this.bilCountyMoney = bilCountyMoney;
		this.bilCityMoney = bilCityMoney;
		this.bilProvinceMoney = bilProvinceMoney;
		this.bilDate = bilDate;
		this.bilZongMoney = bilZongMoney;
	}

	// Property accessors

	public Integer getBilId() {
		return this.bilId;
	}

	public void setBilId(Integer bilId) {
		this.bilId = bilId;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public ThinkUser getThinkUserByThuProvinceId() {
		return this.thinkUserByThuProvinceId;
	}

	public void setThinkUserByThuProvinceId(ThinkUser thinkUserByThuProvinceId) {
		this.thinkUserByThuProvinceId = thinkUserByThuProvinceId;
	}

	public ThinkUser getThinkUserByThuCityId() {
		return this.thinkUserByThuCityId;
	}

	public void setThinkUserByThuCityId(ThinkUser thinkUserByThuCityId) {
		this.thinkUserByThuCityId = thinkUserByThuCityId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ThinkUser getThinkUserByThuCountyId() {
		return this.thinkUserByThuCountyId;
	}

	public void setThinkUserByThuCountyId(ThinkUser thinkUserByThuCountyId) {
		this.thinkUserByThuCountyId = thinkUserByThuCountyId;
	}

	public ThinkUser getThinkUserByThuPropertyId() {
		return this.thinkUserByThuPropertyId;
	}

	public void setThinkUserByThuPropertyId(ThinkUser thinkUserByThuPropertyId) {
		this.thinkUserByThuPropertyId = thinkUserByThuPropertyId;
	}

	public BigDecimal getBilCusMoney() {
		return this.bilCusMoney;
	}

	public void setBilCusMoney(BigDecimal bilCusMoney) {
		this.bilCusMoney = bilCusMoney;
	}

	public BigDecimal getBilBusMoney() {
		return this.bilBusMoney;
	}

	public void setBilBusMoney(BigDecimal bilBusMoney) {
		this.bilBusMoney = bilBusMoney;
	}

	public BigDecimal getBilPropertyMoney() {
		return this.bilPropertyMoney;
	}

	public void setBilPropertyMoney(BigDecimal bilPropertyMoney) {
		this.bilPropertyMoney = bilPropertyMoney;
	}

	public BigDecimal getBilCountyMoney() {
		return this.bilCountyMoney;
	}

	public void setBilCountyMoney(BigDecimal bilCountyMoney) {
		this.bilCountyMoney = bilCountyMoney;
	}

	public BigDecimal getBilCityMoney() {
		return this.bilCityMoney;
	}

	public void setBilCityMoney(BigDecimal bilCityMoney) {
		this.bilCityMoney = bilCityMoney;
	}

	public BigDecimal getBilProvinceMoney() {
		return this.bilProvinceMoney;
	}

	public void setBilProvinceMoney(BigDecimal bilProvinceMoney) {
		this.bilProvinceMoney = bilProvinceMoney;
	}

	public Timestamp getBilDate() {
		return this.bilDate;
	}

	public void setBilDate(Timestamp bilDate) {
		this.bilDate = bilDate;
	}

	public BigDecimal getBilZongMoney() {
		return this.bilZongMoney;
	}

	public void setBilZongMoney(BigDecimal bilZongMoney) {
		this.bilZongMoney = bilZongMoney;
	}

}