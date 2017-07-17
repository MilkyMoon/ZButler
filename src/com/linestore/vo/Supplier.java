package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Supplier entity. @author MyEclipse Persistence Tools
 */

public class Supplier implements java.io.Serializable {

	// Fields

	private Integer supId;
	private Catetory catetory;
	private String supName;
	private String supLogoUrl;
	private String supPhone;
	private String supTime;
	private String supAbstract;
	private String supLicenseUrl;
	private String supTaxUrl;
	private String supOrgUrl;
	private String supBankPermit;
	private String supBrandLetter;
	private String supOther;
	private Boolean supStatus;
	private Set masters = new HashSet(0);
	private Set goodses = new HashSet(0);
	private Set corporations = new HashSet(0);
	private Set businesses = new HashSet(0);
	private Set contacts = new HashSet(0);
	private Set supAddresses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** full constructor */
	public Supplier(Catetory catetory, String supName, String supLogoUrl, String supPhone, String supTime,
			String supAbstract, String supLicenseUrl, String supTaxUrl, String supOrgUrl, String supBankPermit,
			String supBrandLetter, String supOther, Boolean supStatus, Set masters, Set goodses, Set corporations,
			Set businesses, Set contacts, Set supAddresses) {
		this.catetory = catetory;
		this.supName = supName;
		this.supLogoUrl = supLogoUrl;
		this.supPhone = supPhone;
		this.supTime = supTime;
		this.supAbstract = supAbstract;
		this.supLicenseUrl = supLicenseUrl;
		this.supTaxUrl = supTaxUrl;
		this.supOrgUrl = supOrgUrl;
		this.supBankPermit = supBankPermit;
		this.supBrandLetter = supBrandLetter;
		this.supOther = supOther;
		this.supStatus = supStatus;
		this.masters = masters;
		this.goodses = goodses;
		this.corporations = corporations;
		this.businesses = businesses;
		this.contacts = contacts;
		this.supAddresses = supAddresses;
	}

	// Property accessors

	public Integer getSupId() {
		return this.supId;
	}

	public void setSupId(Integer supId) {
		this.supId = supId;
	}

	public Catetory getCatetory() {
		return this.catetory;
	}

	public void setCatetory(Catetory catetory) {
		this.catetory = catetory;
	}

	public String getSupName() {
		return this.supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupLogoUrl() {
		return this.supLogoUrl;
	}

	public void setSupLogoUrl(String supLogoUrl) {
		this.supLogoUrl = supLogoUrl;
	}

	public String getSupPhone() {
		return this.supPhone;
	}

	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}

	public String getSupTime() {
		return this.supTime;
	}

	public void setSupTime(String supTime) {
		this.supTime = supTime;
	}

	public String getSupAbstract() {
		return this.supAbstract;
	}

	public void setSupAbstract(String supAbstract) {
		this.supAbstract = supAbstract;
	}

	public String getSupLicenseUrl() {
		return this.supLicenseUrl;
	}

	public void setSupLicenseUrl(String supLicenseUrl) {
		this.supLicenseUrl = supLicenseUrl;
	}

	public String getSupTaxUrl() {
		return this.supTaxUrl;
	}

	public void setSupTaxUrl(String supTaxUrl) {
		this.supTaxUrl = supTaxUrl;
	}

	public String getSupOrgUrl() {
		return this.supOrgUrl;
	}

	public void setSupOrgUrl(String supOrgUrl) {
		this.supOrgUrl = supOrgUrl;
	}

	public String getSupBankPermit() {
		return this.supBankPermit;
	}

	public void setSupBankPermit(String supBankPermit) {
		this.supBankPermit = supBankPermit;
	}

	public String getSupBrandLetter() {
		return this.supBrandLetter;
	}

	public void setSupBrandLetter(String supBrandLetter) {
		this.supBrandLetter = supBrandLetter;
	}

	public String getSupOther() {
		return this.supOther;
	}

	public void setSupOther(String supOther) {
		this.supOther = supOther;
	}

	public Boolean getSupStatus() {
		return this.supStatus;
	}

	public void setSupStatus(Boolean supStatus) {
		this.supStatus = supStatus;
	}

	public Set getMasters() {
		return this.masters;
	}

	public void setMasters(Set masters) {
		this.masters = masters;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

	public Set getCorporations() {
		return this.corporations;
	}

	public void setCorporations(Set corporations) {
		this.corporations = corporations;
	}

	public Set getBusinesses() {
		return this.businesses;
	}

	public void setBusinesses(Set businesses) {
		this.businesses = businesses;
	}

	public Set getContacts() {
		return this.contacts;
	}

	public void setContacts(Set contacts) {
		this.contacts = contacts;
	}

	public Set getSupAddresses() {
		return this.supAddresses;
	}

	public void setSupAddresses(Set supAddresses) {
		this.supAddresses = supAddresses;
	}

}