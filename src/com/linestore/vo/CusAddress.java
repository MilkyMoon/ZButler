package com.linestore.vo;

/**
 * CusAddress entity. @author MyEclipse Persistence Tools
 */

public class CusAddress implements java.io.Serializable {

	// Fields

	private Integer caId;
	private Customer customer;
	private String caCountry;
	private String caProvince;
	private String caCity;
	private String caAddress;
	private String caName;
	private String caPhone;
	private Integer cusId;

	// Constructors

	/** default constructor */
	public CusAddress() {
	}

	/** full constructor */
	public CusAddress(Customer customer, String caCountry, String caProvince, String caCity, String caAddress,
			String caName, String caPhone, Integer cusId) {
		this.customer = customer;
		this.caCountry = caCountry;
		this.caProvince = caProvince;
		this.caCity = caCity;
		this.caAddress = caAddress;
		this.caName = caName;
		this.caPhone = caPhone;
		this.cusId = cusId;
	}

	// Property accessors

	public Integer getCaId() {
		return this.caId;
	}

	public void setCaId(Integer caId) {
		this.caId = caId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCaCountry() {
		return this.caCountry;
	}

	public void setCaCountry(String caCountry) {
		this.caCountry = caCountry;
	}

	public String getCaProvince() {
		return this.caProvince;
	}

	public void setCaProvince(String caProvince) {
		this.caProvince = caProvince;
	}

	public String getCaCity() {
		return this.caCity;
	}

	public void setCaCity(String caCity) {
		this.caCity = caCity;
	}

	public String getCaAddress() {
		return this.caAddress;
	}

	public void setCaAddress(String caAddress) {
		this.caAddress = caAddress;
	}

	public String getCaName() {
		return this.caName;
	}

	public void setCaName(String caName) {
		this.caName = caName;
	}

	public String getCaPhone() {
		return this.caPhone;
	}

	public void setCaPhone(String caPhone) {
		this.caPhone = caPhone;
	}

	public Integer getCusId() {
		return this.cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

}