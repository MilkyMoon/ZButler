package com.linestore.vo;

/**
 * Contact entity. @author MyEclipse Persistence Tools
 */

public class Contact implements java.io.Serializable {

	// Fields

	private Integer conId;
	private Supplier supplier;
	private String conFname;
	private String conLname;
	private String conPhone;
	private String conEmail;

	// Constructors

	/** default constructor */
	public Contact() {
	}

	/** full constructor */
	public Contact(Supplier supplier, String conFname, String conLname, String conPhone, String conEmail) {
		this.supplier = supplier;
		this.conFname = conFname;
		this.conLname = conLname;
		this.conPhone = conPhone;
		this.conEmail = conEmail;
	}

	// Property accessors

	public Integer getConId() {
		return this.conId;
	}

	public void setConId(Integer conId) {
		this.conId = conId;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getConFname() {
		return this.conFname;
	}

	public void setConFname(String conFname) {
		this.conFname = conFname;
	}

	public String getConLname() {
		return this.conLname;
	}

	public void setConLname(String conLname) {
		this.conLname = conLname;
	}

	public String getConPhone() {
		return this.conPhone;
	}

	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}

	public String getConEmail() {
		return this.conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

}