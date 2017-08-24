package com.linestore.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Bill entity. @author MyEclipse Persistence Tools
 */

public class Bill implements java.io.Serializable {

	// Fields

	private Integer bilId;
	private Area areaByThuPropertyId;
	private Business business;
	private Area areaByThuCountyId;
	private Customer customer;
	private Area areaByThuCityId;
	private Area areaByThuProvinceId;
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
	public Bill(Area areaByThuPropertyId, Business business, Area areaByThuCountyId, Customer customer,
			Area areaByThuCityId, Area areaByThuProvinceId, BigDecimal bilCusMoney, BigDecimal bilBusMoney,
			BigDecimal bilPropertyMoney, BigDecimal bilCountyMoney, BigDecimal bilCityMoney,
			BigDecimal bilProvinceMoney, Timestamp bilDate, BigDecimal bilZongMoney) {
		this.areaByThuPropertyId = areaByThuPropertyId;
		this.business = business;
		this.areaByThuCountyId = areaByThuCountyId;
		this.customer = customer;
		this.areaByThuCityId = areaByThuCityId;
		this.areaByThuProvinceId = areaByThuProvinceId;
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

	public Area getAreaByThuPropertyId() {
		return this.areaByThuPropertyId;
	}

	public void setAreaByThuPropertyId(Area areaByThuPropertyId) {
		this.areaByThuPropertyId = areaByThuPropertyId;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Area getAreaByThuCountyId() {
		return this.areaByThuCountyId;
	}

	public void setAreaByThuCountyId(Area areaByThuCountyId) {
		this.areaByThuCountyId = areaByThuCountyId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Area getAreaByThuCityId() {
		return this.areaByThuCityId;
	}

	public void setAreaByThuCityId(Area areaByThuCityId) {
		this.areaByThuCityId = areaByThuCityId;
	}

	public Area getAreaByThuProvinceId() {
		return this.areaByThuProvinceId;
	}

	public void setAreaByThuProvinceId(Area areaByThuProvinceId) {
		this.areaByThuProvinceId = areaByThuProvinceId;
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