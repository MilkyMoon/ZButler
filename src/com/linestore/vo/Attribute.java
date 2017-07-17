package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Attribute entity. @author MyEclipse Persistence Tools
 */

public class Attribute implements java.io.Serializable {

	// Fields

	private Integer attId;
	private Catetory catetory;
	private String attName;
	private Boolean attIscolor;
	private Boolean attIsenum;
	private Boolean attIsinput;
	private Boolean attIskey;
	private Boolean attIssell;
	private Boolean attIsmust;
	private Boolean attIsmore;
	private Boolean attStatus;
	private Set attValues = new HashSet(0);
	private Set proattributes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Attribute() {
	}

	/** full constructor */
	public Attribute(Catetory catetory, String attName, Boolean attIscolor, Boolean attIsenum, Boolean attIsinput,
			Boolean attIskey, Boolean attIssell, Boolean attIsmust, Boolean attIsmore, Boolean attStatus, Set attValues,
			Set proattributes) {
		this.catetory = catetory;
		this.attName = attName;
		this.attIscolor = attIscolor;
		this.attIsenum = attIsenum;
		this.attIsinput = attIsinput;
		this.attIskey = attIskey;
		this.attIssell = attIssell;
		this.attIsmust = attIsmust;
		this.attIsmore = attIsmore;
		this.attStatus = attStatus;
		this.attValues = attValues;
		this.proattributes = proattributes;
	}

	// Property accessors

	public Integer getAttId() {
		return this.attId;
	}

	public void setAttId(Integer attId) {
		this.attId = attId;
	}

	public Catetory getCatetory() {
		return this.catetory;
	}

	public void setCatetory(Catetory catetory) {
		this.catetory = catetory;
	}

	public String getAttName() {
		return this.attName;
	}

	public void setAttName(String attName) {
		this.attName = attName;
	}

	public Boolean getAttIscolor() {
		return this.attIscolor;
	}

	public void setAttIscolor(Boolean attIscolor) {
		this.attIscolor = attIscolor;
	}

	public Boolean getAttIsenum() {
		return this.attIsenum;
	}

	public void setAttIsenum(Boolean attIsenum) {
		this.attIsenum = attIsenum;
	}

	public Boolean getAttIsinput() {
		return this.attIsinput;
	}

	public void setAttIsinput(Boolean attIsinput) {
		this.attIsinput = attIsinput;
	}

	public Boolean getAttIskey() {
		return this.attIskey;
	}

	public void setAttIskey(Boolean attIskey) {
		this.attIskey = attIskey;
	}

	public Boolean getAttIssell() {
		return this.attIssell;
	}

	public void setAttIssell(Boolean attIssell) {
		this.attIssell = attIssell;
	}

	public Boolean getAttIsmust() {
		return this.attIsmust;
	}

	public void setAttIsmust(Boolean attIsmust) {
		this.attIsmust = attIsmust;
	}

	public Boolean getAttIsmore() {
		return this.attIsmore;
	}

	public void setAttIsmore(Boolean attIsmore) {
		this.attIsmore = attIsmore;
	}

	public Boolean getAttStatus() {
		return this.attStatus;
	}

	public void setAttStatus(Boolean attStatus) {
		this.attStatus = attStatus;
	}

	public Set getAttValues() {
		return this.attValues;
	}

	public void setAttValues(Set attValues) {
		this.attValues = attValues;
	}

	public Set getProattributes() {
		return this.proattributes;
	}

	public void setProattributes(Set proattributes) {
		this.proattributes = proattributes;
	}

}