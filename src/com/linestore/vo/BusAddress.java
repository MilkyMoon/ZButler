package com.linestore.vo;

/**
 * BusAddress entity. @author MyEclipse Persistence Tools
 */

public class BusAddress implements java.io.Serializable {

	// Fields

	private Integer baId;
	private Integer baBusId;
	private String baCountry;
	private String baProvince;
	private String baCity;
	private String baCounty;
	private String baAddress;
	private Float baLongitude;
	private Float baLatitude;

	// Constructors

	/** default constructor */
	public BusAddress() {
	}

	/** minimal constructor */
	public BusAddress(Integer baBusId) {
		this.baBusId = baBusId;
	}

	/** full constructor */
	public BusAddress(Integer baBusId, String baCountry, String baProvince, String baCity, String baCounty,
			String baAddress, Float baLongitude, Float baLatitude) {
		this.baBusId = baBusId;
		this.baCountry = baCountry;
		this.baProvince = baProvince;
		this.baCity = baCity;
		this.baCounty = baCounty;
		this.baAddress = baAddress;
		this.baLongitude = baLongitude;
		this.baLatitude = baLatitude;
	}

	// Property accessors

	public Integer getBaId() {
		return this.baId;
	}

	public void setBaId(Integer baId) {
		this.baId = baId;
	}

	public Integer getBaBusId() {
		return this.baBusId;
	}

	public void setBaBusId(Integer baBusId) {
		this.baBusId = baBusId;
	}

	public String getBaCountry() {
		return this.baCountry;
	}

	public void setBaCountry(String baCountry) {
		this.baCountry = baCountry;
	}

	public String getBaProvince() {
		return this.baProvince;
	}

	public void setBaProvince(String baProvince) {
		this.baProvince = baProvince;
	}

	public String getBaCity() {
		return this.baCity;
	}

	public void setBaCity(String baCity) {
		this.baCity = baCity;
	}

	public String getBaCounty() {
		return this.baCounty;
	}

	public void setBaCounty(String baCounty) {
		this.baCounty = baCounty;
	}

	public String getBaAddress() {
		return this.baAddress;
	}

	public void setBaAddress(String baAddress) {
		this.baAddress = baAddress;
	}

	public Float getBaLongitude() {
		return this.baLongitude;
	}

	public void setBaLongitude(Float baLongitude) {
		this.baLongitude = baLongitude;
	}

	public Float getBaLatitude() {
		return this.baLatitude;
	}

	public void setBaLatitude(Float baLatitude) {
		this.baLatitude = baLatitude;
	}

}