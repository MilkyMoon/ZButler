package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Business entity. @author MyEclipse Persistence Tools
 */

public class Business implements java.io.Serializable {

	// Fields

	private Integer busId;
	private Supplier supplier;
	private Catetory catetory;
	private String busShopName;
	private String busOwnerFname;
	private String busOwnerLname;
	private String busIdcardUrl;
	private String busLicenseUrl;
	private String busTaxUrl;
	private String busOrgUrl;
	private Integer busDistrict;
	private Integer busSmallCate;
	private Integer busStatus;
	private Integer busLevel;
	private Set busCoupons = new HashSet(0);
	private Set busBanks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Business() {
	}

	/** full constructor */
	public Business(Supplier supplier, Catetory catetory, String busShopName, String busOwnerFname,
			String busOwnerLname, String busIdcardUrl, String busLicenseUrl, String busTaxUrl, String busOrgUrl,
			Integer busDistrict, Integer busSmallCate, Integer busStatus, Integer busLevel, Set busCoupons,
			Set busBanks) {
		this.supplier = supplier;
		this.catetory = catetory;
		this.busShopName = busShopName;
		this.busOwnerFname = busOwnerFname;
		this.busOwnerLname = busOwnerLname;
		this.busIdcardUrl = busIdcardUrl;
		this.busLicenseUrl = busLicenseUrl;
		this.busTaxUrl = busTaxUrl;
		this.busOrgUrl = busOrgUrl;
		this.busDistrict = busDistrict;
		this.busSmallCate = busSmallCate;
		this.busStatus = busStatus;
		this.busLevel = busLevel;
		this.busCoupons = busCoupons;
		this.busBanks = busBanks;
	}

	// Property accessors

	public Integer getBusId() {
		return this.busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
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

	public String getBusShopName() {
		return this.busShopName;
	}

	public void setBusShopName(String busShopName) {
		this.busShopName = busShopName;
	}

	public String getBusOwnerFname() {
		return this.busOwnerFname;
	}

	public void setBusOwnerFname(String busOwnerFname) {
		this.busOwnerFname = busOwnerFname;
	}

	public String getBusOwnerLname() {
		return this.busOwnerLname;
	}

	public void setBusOwnerLname(String busOwnerLname) {
		this.busOwnerLname = busOwnerLname;
	}

	public String getBusIdcardUrl() {
		return this.busIdcardUrl;
	}

	public void setBusIdcardUrl(String busIdcardUrl) {
		this.busIdcardUrl = busIdcardUrl;
	}

	public String getBusLicenseUrl() {
		return this.busLicenseUrl;
	}

	public void setBusLicenseUrl(String busLicenseUrl) {
		this.busLicenseUrl = busLicenseUrl;
	}

	public String getBusTaxUrl() {
		return this.busTaxUrl;
	}

	public void setBusTaxUrl(String busTaxUrl) {
		this.busTaxUrl = busTaxUrl;
	}

	public String getBusOrgUrl() {
		return this.busOrgUrl;
	}

	public void setBusOrgUrl(String busOrgUrl) {
		this.busOrgUrl = busOrgUrl;
	}

	public Integer getBusSmallCate() {
		return this.busSmallCate;
	}

	public void setBusSmallCate(Integer busSmallCate) {
		this.busSmallCate = busSmallCate;
	}

	

	public Integer getBusDistrict() {
		return busDistrict;
	}

	public void setBusDistrict(Integer busDistrict) {
		this.busDistrict = busDistrict;
	}

	public Integer getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(Integer busStatus) {
		this.busStatus = busStatus;
	}

	public Integer getBusLevel() {
		return busLevel;
	}

	public void setBusLevel(Integer busLevel) {
		this.busLevel = busLevel;
	}

	public Set getBusCoupons() {
		return this.busCoupons;
	}

	public void setBusCoupons(Set busCoupons) {
		this.busCoupons = busCoupons;
	}

	public Set getBusBanks() {
		return this.busBanks;
	}

	public void setBusBanks(Set busBanks) {
		this.busBanks = busBanks;
	}

}