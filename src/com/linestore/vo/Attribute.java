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
	private Integer attIscolor;
	private Integer attIsenum;
	private Integer attIsinput;
	private Integer attIskey;
	private Integer attIssell;
	private Integer attIsmust;
	private Integer attIsmore;
	private Integer attStatus;
	private Set attValues = new HashSet(0);
	private Set proattributes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Attribute() {
	}

	/** full constructor */
	public Attribute(Catetory catetory, String attName, Integer attIscolor, Integer attIsenum, Integer attIsinput,
			Integer attIskey, Integer attIssell, Integer attIsmust, Integer attIsmore, Integer attStatus, Set attValues,
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


	public Integer getAttIscolor() {
		return attIscolor;
	}

	public void setAttIscolor(Integer attIscolor) {
		this.attIscolor = attIscolor;
	}

	public Integer getAttIsenum() {
		return attIsenum;
	}

	public void setAttIsenum(Integer attIsenum) {
		this.attIsenum = attIsenum;
	}

	public Integer getAttIsinput() {
		return attIsinput;
	}

	public void setAttIsinput(Integer attIsinput) {
		this.attIsinput = attIsinput;
	}

	public Integer getAttIskey() {
		return attIskey;
	}

	public void setAttIskey(Integer attIskey) {
		this.attIskey = attIskey;
	}

	public Integer getAttIssell() {
		return attIssell;
	}

	public void setAttIssell(Integer attIssell) {
		this.attIssell = attIssell;
	}

	public Integer getAttIsmust() {
		return attIsmust;
	}

	public void setAttIsmust(Integer attIsmust) {
		this.attIsmust = attIsmust;
	}

	public Integer getAttIsmore() {
		return attIsmore;
	}

	public void setAttIsmore(Integer attIsmore) {
		this.attIsmore = attIsmore;
	}

	public Integer getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(Integer attStatus) {
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