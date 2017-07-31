package com.linestore.vo;

import java.util.Date;

/**
 * Bill entity. @author MyEclipse Persistence Tools
 */

public class Bill implements java.io.Serializable {

	// Fields

	private Integer bilId;
	private Integer cusId;
	private Float bilCusMoney;
	private Integer busId;
	private Float bilBusMoney;
	private Integer thuPropertyId;
	private Float bilPropertyMoney;
	private Integer thuCountyId;
	private Float bilCountyMoney;
	private Integer thuCityId;
	private Float bilCityMoney;
	private Integer thuProvinceId;
	private Float bilProvinceMoney;
	private Date bilDate;
	private Float bilZongMoney;

	// Constructors

	/** default constructor */
	public Bill() {
	}

	/** full constructor */
	public Bill(Integer cusId, Float bilCusMoney, Integer busId, Float bilBusMoney, Integer thuPropertyId,
			Float bilPropertyMoney, Integer thuCountyId, Float bilCountyMoney, Integer thuCityId, Float bilCityMoney,
			Integer thuProvinceId, Float bilProvinceMoney, Date bilDate, Float bilZongMoney) {
		this.cusId = cusId;
		this.bilCusMoney = bilCusMoney;
		this.busId = busId;
		this.bilBusMoney = bilBusMoney;
		this.thuPropertyId = thuPropertyId;
		this.bilPropertyMoney = bilPropertyMoney;
		this.thuCountyId = thuCountyId;
		this.bilCountyMoney = bilCountyMoney;
		this.thuCityId = thuCityId;
		this.bilCityMoney = bilCityMoney;
		this.thuProvinceId = thuProvinceId;
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

	public Integer getCusId() {
		return this.cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Float getBilCusMoney() {
		return this.bilCusMoney;
	}

	public void setBilCusMoney(Float bilCusMoney) {
		this.bilCusMoney = bilCusMoney;
	}

	public Integer getBusId() {
		return this.busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public Float getBilBusMoney() {
		return this.bilBusMoney;
	}

	public void setBilBusMoney(Float bilBusMoney) {
		this.bilBusMoney = bilBusMoney;
	}

	public Integer getThuPropertyId() {
		return this.thuPropertyId;
	}

	public void setThuPropertyId(Integer thuPropertyId) {
		this.thuPropertyId = thuPropertyId;
	}

	public Float getBilPropertyMoney() {
		return this.bilPropertyMoney;
	}

	public void setBilPropertyMoney(Float bilPropertyMoney) {
		this.bilPropertyMoney = bilPropertyMoney;
	}

	public Integer getThuCountyId() {
		return this.thuCountyId;
	}

	public void setThuCountyId(Integer thuCountyId) {
		this.thuCountyId = thuCountyId;
	}

	public Float getBilCountyMoney() {
		return this.bilCountyMoney;
	}

	public void setBilCountyMoney(Float bilCountyMoney) {
		this.bilCountyMoney = bilCountyMoney;
	}

	public Integer getThuCityId() {
		return this.thuCityId;
	}

	public void setThuCityId(Integer thuCityId) {
		this.thuCityId = thuCityId;
	}

	public Float getBilCityMoney() {
		return this.bilCityMoney;
	}

	public void setBilCityMoney(Float bilCityMoney) {
		this.bilCityMoney = bilCityMoney;
	}

	public Integer getThuProvinceId() {
		return this.thuProvinceId;
	}

	public void setThuProvinceId(Integer thuProvinceId) {
		this.thuProvinceId = thuProvinceId;
	}

	public Float getBilProvinceMoney() {
		return this.bilProvinceMoney;
	}

	public void setBilProvinceMoney(Float bilProvinceMoney) {
		this.bilProvinceMoney = bilProvinceMoney;
	}

	public Date getBilDate() {
		return this.bilDate;
	}

	public void setBilDate(Date bilDate) {
		this.bilDate = bilDate;
	}

	public Float getBilZongMoney() {
		return this.bilZongMoney;
	}

	public void setBilZongMoney(Float bilZongMoney) {
		this.bilZongMoney = bilZongMoney;
	}

}