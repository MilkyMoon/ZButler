package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * AttValue entity. @author MyEclipse Persistence Tools
 */

public class AttValue implements java.io.Serializable {

	// Fields

	private Integer avaId;
	private Catetory catetory;
	private Attribute attribute;
	private String avaName;
	private Boolean avaStatus;
	private Set proattributes = new HashSet(0);

	// Constructors

	/** default constructor */
	public AttValue() {
	}

	/** full constructor */
	public AttValue(Catetory catetory, Attribute attribute, String avaName, Boolean avaStatus, Set proattributes) {
		this.catetory = catetory;
		this.attribute = attribute;
		this.avaName = avaName;
		this.avaStatus = avaStatus;
		this.proattributes = proattributes;
	}

	// Property accessors

	public Integer getAvaId() {
		return this.avaId;
	}

	public void setAvaId(Integer avaId) {
		this.avaId = avaId;
	}

	public Catetory getCatetory() {
		return this.catetory;
	}

	public void setCatetory(Catetory catetory) {
		this.catetory = catetory;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public String getAvaName() {
		return this.avaName;
	}

	public void setAvaName(String avaName) {
		this.avaName = avaName;
	}

	public Boolean getAvaStatus() {
		return this.avaStatus;
	}

	public void setAvaStatus(Boolean avaStatus) {
		this.avaStatus = avaStatus;
	}

	public Set getProattributes() {
		return this.proattributes;
	}

	public void setProattributes(Set proattributes) {
		this.proattributes = proattributes;
	}

}