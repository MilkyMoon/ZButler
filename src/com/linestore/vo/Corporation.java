package com.linestore.vo;

/**
 * Corporation entity. @author MyEclipse Persistence Tools
 */

public class Corporation implements java.io.Serializable {

	// Fields

	private Integer corId;
	private Supplier supplier;
	private String corFname;
	private String corLname;
	private String corNum;
	private String corIdcard;

	// Constructors

	/** default constructor */
	public Corporation() {
	}

	/** full constructor */
	public Corporation(Supplier supplier, String corFname, String corLname, String corNum, String corIdcard) {
		this.supplier = supplier;
		this.corFname = corFname;
		this.corLname = corLname;
		this.corNum = corNum;
		this.corIdcard = corIdcard;
	}

	// Property accessors

	public Integer getCorId() {
		return this.corId;
	}

	public void setCorId(Integer corId) {
		this.corId = corId;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getCorFname() {
		return this.corFname;
	}

	public void setCorFname(String corFname) {
		this.corFname = corFname;
	}

	public String getCorLname() {
		return this.corLname;
	}

	public void setCorLname(String corLname) {
		this.corLname = corLname;
	}

	public String getCorNum() {
		return this.corNum;
	}

	public void setCorNum(String corNum) {
		this.corNum = corNum;
	}

	public String getCorIdcard() {
		return this.corIdcard;
	}

	public void setCorIdcard(String corIdcard) {
		this.corIdcard = corIdcard;
	}

}