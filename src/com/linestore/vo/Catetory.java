package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Catetory entity. @author MyEclipse Persistence Tools
 */

public class Catetory implements java.io.Serializable {

	// Fields

	private Integer cateId;
	private Integer catePid;
	private String cateName;
	private Integer cateStatus;
	private String cateChild;
	private Set attValues = new HashSet(0);
	private Set brands = new HashSet(0);
	private Set goodses = new HashSet(0);
	private Set suppliers = new HashSet(0);
	private Set businesses = new HashSet(0);
	private Set attributes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Catetory() {
	}
	
	public Catetory(Integer catePid, String cateName) {
		this.catePid = catePid;
		this.cateName = cateName;
	}

	/** full constructor */
	public Catetory(Integer catePid, String cateName, Integer cateCount, String cateChild, Set attValues, Set brands,
			Set goodses, Set suppliers, Set businesses, Set attributes) {
		this.catePid = catePid;
		this.cateName = cateName;
		this.cateStatus = cateCount;
		this.cateChild = cateChild;
		this.attValues = attValues;
		this.brands = brands;
		this.goodses = goodses;
		this.suppliers = suppliers;
		this.businesses = businesses;
		this.attributes = attributes;
	}

	// Property accessors

	public Integer getCateId() {
		return this.cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public Integer getCatePid() {
		return this.catePid;
	}

	public void setCatePid(Integer catePid) {
		this.catePid = catePid;
	}

	public String getCateName() {
		return this.cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Integer getCateStatus() {
		return cateStatus;
	}

	public void setCateStatus(Integer cateStatus) {
		this.cateStatus = cateStatus;
	}

	public String getCateChild() {
		return this.cateChild;
	}

	public void setCateChild(String cateChild) {
		this.cateChild = cateChild;
	}

	public Set getAttValues() {
		return this.attValues;
	}

	public void setAttValues(Set attValues) {
		this.attValues = attValues;
	}

	public Set getBrands() {
		return this.brands;
	}

	public void setBrands(Set brands) {
		this.brands = brands;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

	public Set getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(Set suppliers) {
		this.suppliers = suppliers;
	}

	public Set getBusinesses() {
		return this.businesses;
	}

	public void setBusinesses(Set businesses) {
		this.businesses = businesses;
	}

	public Set getAttributes() {
		return this.attributes;
	}

	public void setAttributes(Set attributes) {
		this.attributes = attributes;
	}

}