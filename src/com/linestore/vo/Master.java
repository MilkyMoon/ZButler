package com.linestore.vo;

/**
 * Master entity. @author MyEclipse Persistence Tools
 */

public class Master implements java.io.Serializable {

	// Fields

	private Integer masId;
	private Supplier supplier;
	private String masFname;
	private String masLname;
	private String masPhone;
	private String masEmail;

	// Constructors

	/** default constructor */
	public Master() {
	}

	/** full constructor */
	public Master(Supplier supplier, String masFname, String masLname, String masPhone, String masEmail) {
		this.supplier = supplier;
		this.masFname = masFname;
		this.masLname = masLname;
		this.masPhone = masPhone;
		this.masEmail = masEmail;
	}

	// Property accessors

	public Integer getMasId() {
		return this.masId;
	}

	public void setMasId(Integer masId) {
		this.masId = masId;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getMasFname() {
		return this.masFname;
	}

	public void setMasFname(String masFname) {
		this.masFname = masFname;
	}

	public String getMasLname() {
		return this.masLname;
	}

	public void setMasLname(String masLname) {
		this.masLname = masLname;
	}

	public String getMasPhone() {
		return this.masPhone;
	}

	public void setMasPhone(String masPhone) {
		this.masPhone = masPhone;
	}

	public String getMasEmail() {
		return this.masEmail;
	}

	public void setMasEmail(String masEmail) {
		this.masEmail = masEmail;
	}

}