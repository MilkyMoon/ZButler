package com.linestore.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer gooId;
	private Brand brand;
	private Supplier supplier;
	private Catetory catetory;
	private String gooTitle;
	private String gooNum;
	private Integer gooCondi;
	private String gooDescribe;
	private Integer gooType;
	private Integer gooStatus;
	private Integer gooFreight;
	private String gooKeyWord;
	private Integer gooWeight;
	private Timestamp gooCreateDate;
	private Set proattributes = new HashSet(0);
	private Set skus = new HashSet(0);
	private Set histories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(Brand brand, Supplier supplier, Catetory catetory, String gooTitle, String gooNum, Integer gooCondi,
			String gooDescribe, Integer gooType, Integer gooStatus, Integer gooFreight, String gooKeyWord,
			Integer gooWeight, Timestamp gooCreateDate, Set proattributes, Set skus, Set histories) {
		this.brand = brand;
		this.supplier = supplier;
		this.catetory = catetory;
		this.gooTitle = gooTitle;
		this.gooNum = gooNum;
		this.gooCondi = gooCondi;
		this.gooDescribe = gooDescribe;
		this.gooType = gooType;
		this.gooStatus = gooStatus;
		this.gooFreight = gooFreight;
		this.gooKeyWord = gooKeyWord;
		this.gooWeight = gooWeight;
		this.gooCreateDate = gooCreateDate;
		this.proattributes = proattributes;
		this.skus = skus;
		this.histories = histories;
	}

	// Property accessors

	public Integer getGooId() {
		return this.gooId;
	}

	public void setGooId(Integer gooId) {
		this.gooId = gooId;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Catetory getCatetory() {
		return this.catetory;
	}

	public void setCatetory(Catetory catetory) {
		this.catetory = catetory;
	}

	public String getGooTitle() {
		return this.gooTitle;
	}

	public void setGooTitle(String gooTitle) {
		this.gooTitle = gooTitle;
	}

	public String getGooNum() {
		return this.gooNum;
	}

	public void setGooNum(String gooNum) {
		this.gooNum = gooNum;
	}

	public Integer getGooCondi() {
		return this.gooCondi;
	}

	public void setGooCondi(Integer gooCondi) {
		this.gooCondi = gooCondi;
	}

	public String getGooDescribe() {
		return this.gooDescribe;
	}

	public void setGooDescribe(String gooDescribe) {
		this.gooDescribe = gooDescribe;
	}


	public Integer getGooType() {
		return gooType;
	}

	public void setGooType(Integer gooType) {
		this.gooType = gooType;
	}

	public Integer getGooStatus() {
		return gooStatus;
	}

	public void setGooStatus(Integer gooStatus) {
		this.gooStatus = gooStatus;
	}

	public Integer getGooFreight() {
		return gooFreight;
	}

	public void setGooFreight(Integer gooFreight) {
		this.gooFreight = gooFreight;
	}

	public String getGooKeyWord() {
		return this.gooKeyWord;
	}

	public void setGooKeyWord(String gooKeyWord) {
		this.gooKeyWord = gooKeyWord;
	}

	public Integer getGooWeight() {
		return this.gooWeight;
	}

	public void setGooWeight(Integer gooWeight) {
		this.gooWeight = gooWeight;
	}

	public Timestamp getGooCreateDate() {
		return this.gooCreateDate;
	}

	public void setGooCreateDate(Timestamp gooCreateDate) {
		this.gooCreateDate = gooCreateDate;
	}

	public Set getProattributes() {
		return this.proattributes;
	}

	public void setProattributes(Set proattributes) {
		this.proattributes = proattributes;
	}

	public Set getSkus() {
		return this.skus;
	}

	public void setSkus(Set skus) {
		this.skus = skus;
	}

	public Set getHistories() {
		return this.histories;
	}

	public void setHistories(Set histories) {
		this.histories = histories;
	}

}