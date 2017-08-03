package com.linestore.vo;

import java.sql.Timestamp;

/**
 * Bill entity. @author MyEclipse Persistence Tools
 */

public class Bill implements java.io.Serializable {

	// Fields

	private Integer bilId;
	private Business business;
	private ThinkUser thinkUserByThuProvinceId;
	private ThinkUser thinkUserByThuCityId;
	private Customer customer;
	private ThinkUser thinkUserByThuCountyId;
	private ThinkUser thinkUserByThuPropertyId;
	private Float bilCusMoney;
	private Float bilBusMoney;
	private Float bilPropertyMoney;
	private Float bilCountyMoney;
	private Float bilCityMoney;
	private Float bilProvinceMoney;
	private Timestamp bilDate;
	private Float bilZongMoney;

	// Constructors

	/** default constructor */
	public Bill() {
	}

	/** full constructor */
	public Bill(Business business, ThinkUser thinkUserByThuProvinceId, ThinkUser thinkUserByThuCityId,
			Customer customer, ThinkUser thinkUserByThuCountyId, ThinkUser thinkUserByThuPropertyId, Float bilCusMoney,
			Float bilBusMoney, Float bilPropertyMoney, Float bilCountyMoney, Float bilCityMoney, Float bilProvinceMoney,
			Timestamp bilDate, Float bilZongMoney) {
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

	public Float getBilCusMoney() {
		return this.bilCusMoney;
	}

	public void setBilCusMoney(Float bilCusMoney) {
		this.bilCusMoney = bilCusMoney;
	}

	public Float getBilBusMoney() {
		return this.bilBusMoney;
	}

	public void setBilBusMoney(Float bilBusMoney) {
		this.bilBusMoney = bilBusMoney;
	}

	public Float getBilPropertyMoney() {
		return this.bilPropertyMoney;
	}

	public void setBilPropertyMoney(Float bilPropertyMoney) {
		this.bilPropertyMoney = bilPropertyMoney;
	}

	public Float getBilCountyMoney() {
		return this.bilCountyMoney;
	}

	public void setBilCountyMoney(Float bilCountyMoney) {
		this.bilCountyMoney = bilCountyMoney;
	}

	public Float getBilCityMoney() {
		return this.bilCityMoney;
	}

	public void setBilCityMoney(Float bilCityMoney) {
		this.bilCityMoney = bilCityMoney;
	}

	public Float getBilProvinceMoney() {
		return this.bilProvinceMoney;
	}

	public void setBilProvinceMoney(Float bilProvinceMoney) {
		this.bilProvinceMoney = bilProvinceMoney;
	}

	public Timestamp getBilDate() {
		return this.bilDate;
	}

	public void setBilDate(Timestamp bilDate) {
		this.bilDate = bilDate;
	}

	public Float getBilZongMoney() {
		return this.bilZongMoney;
	}

	public void setBilZongMoney(Float bilZongMoney) {
		this.bilZongMoney = bilZongMoney;
	}

}