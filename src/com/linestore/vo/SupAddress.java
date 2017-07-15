package com.linestore.vo;

/**
 * SupAddress entity. @author MyEclipse Persistence Tools
 */

public class SupAddress implements java.io.Serializable {

	// Fields

	private Integer saId;
	private Supplier supplier;
	private String saCountry;
	private String saProvince;
	private String saCity;
	private String saAddress;

	// Constructors

	/** default constructor */
	public SupAddress() {
	}

	/** full constructor */
	public SupAddress(Supplier supplier, String saCountry, String saProvince, String saCity, String saAddress) {
		this.supplier = supplier;
		this.saCountry = saCountry;
		this.saProvince = saProvince;
		this.saCity = saCity;
		this.saAddress = saAddress;
	}

	// Property accessors

	public Integer getSaId() {
		return this.saId;
	}

	public void setSaId(Integer saId) {
		this.saId = saId;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getSaCountry() {
		return this.saCountry;
	}

	public void setSaCountry(String saCountry) {
		this.saCountry = saCountry;
	}

	public String getSaProvince() {
		return this.saProvince;
	}

	public void setSaProvince(String saProvince) {
		this.saProvince = saProvince;
	}

	public String getSaCity() {
		return this.saCity;
	}

	public void setSaCity(String saCity) {
		this.saCity = saCity;
	}

	public String getSaAddress() {
		return this.saAddress;
	}

	public void setSaAddress(String saAddress) {
		this.saAddress = saAddress;
	}

}