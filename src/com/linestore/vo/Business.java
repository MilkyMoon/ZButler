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
	private CateLine cateLine;
	private Customer customer;
	private String busShopName;
	private String busOwnerName;
	private String busDesc;
	private String busLicenseUrl;
	private String busTaxUrl;
	private String busOrgUrl;
	private Integer busDistrict;
	private Integer busSmallCate;
	private Integer busStatus;
	private Integer busThuId;
	private Integer busLevel;
	private String baCountry;
	private String baProvince;
	private String baCity;
	private String baCounty;
	private String baAddress;
	private Float baLatitude;
	private Float baLongitude;
	private Float busChange;
	private String bbBankCard;
	private String bbBank;
	private String bbBankPerson;
	private String busIdcardUrl;
	private String busPhone;
	private String busTdCode;
	private String busShareUrl;
	private String busEphone;
	private Set busCoupons = new HashSet(0);
	private Set bills = new HashSet(0);

	// Constructors

	/** default constructor */
	public Business() {
	}

	/** full constructor */
	

	// Property accessors

	public Integer getBusId() {
		return this.busId;
	}

	public Business(Integer busId, Supplier supplier, CateLine cateLine, Customer customer, String busShopName,
			String busOwnerName, String busDesc, String busLicenseUrl, String busTaxUrl, String busOrgUrl,
			Integer busDistrict, Integer busSmallCate, Integer busStatus, Integer busThuId, Integer busLevel,
			String baCountry, String baProvince, String baCity, String baCounty, String baAddress, Float baLatitude,
			Float baLongitude, Float busChange, String bbBankCard, String bbBank, String bbBankPerson,
			String busIdcardUrl, String busPhone, String busTdCode, String busShareUrl, Set busCoupons, Set bills, String busEphone) {
		super();
		this.busId = busId;
		this.supplier = supplier;
		this.cateLine = cateLine;
		this.customer = customer;
		this.busShopName = busShopName;
		this.busOwnerName = busOwnerName;
		this.busDesc = busDesc;
		this.busLicenseUrl = busLicenseUrl;
		this.busTaxUrl = busTaxUrl;
		this.busOrgUrl = busOrgUrl;
		this.busDistrict = busDistrict;
		this.busSmallCate = busSmallCate;
		this.busStatus = busStatus;
		this.busThuId = busThuId;
		this.busLevel = busLevel;
		this.baCountry = baCountry;
		this.baProvince = baProvince;
		this.baCity = baCity;
		this.baCounty = baCounty;
		this.baAddress = baAddress;
		this.baLatitude = baLatitude;
		this.baLongitude = baLongitude;
		this.busChange = busChange;
		this.bbBankCard = bbBankCard;
		this.bbBank = bbBank;
		this.bbBankPerson = bbBankPerson;
		this.busIdcardUrl = busIdcardUrl;
		this.busPhone = busPhone;
		this.busTdCode = busTdCode;
		this.busShareUrl = busShareUrl;
		this.busCoupons = busCoupons;
		this.bills = bills;
		this.busEphone = busEphone;
	}
	
	
	

	public String getBusEphone() {
		return busEphone;
	}

	public void setBusEphone(String busEphone) {
		this.busEphone = busEphone;
	}

	public Float getBusChange() {
		return busChange;
	}

	public void setBusChange(Float busChange) {
		this.busChange = busChange;
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

	public CateLine getCateLine() {
		return this.cateLine;
	}

	public void setCateLine(CateLine cateLine) {
		this.cateLine = cateLine;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBusShopName() {
		return this.busShopName;
	}

	public void setBusShopName(String busShopName) {
		this.busShopName = busShopName;
	}

	public String getBusOwnerName() {
		return this.busOwnerName;
	}

	public void setBusOwnerName(String busOwnerName) {
		this.busOwnerName = busOwnerName;
	}

	public String getBusDesc() {
		return this.busDesc;
	}

	public void setBusDesc(String busDesc) {
		this.busDesc = busDesc;
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

	public Integer getBusDistrict() {
		return this.busDistrict;
	}

	public void setBusDistrict(Integer busDistrict) {
		this.busDistrict = busDistrict;
	}

	public Integer getBusSmallCate() {
		return this.busSmallCate;
	}

	public void setBusSmallCate(Integer busSmallCate) {
		this.busSmallCate = busSmallCate;
	}

	public Integer getBusStatus() {
		return this.busStatus;
	}

	public void setBusStatus(Integer busStatus) {
		this.busStatus = busStatus;
	}

	public Integer getBusThuId() {
		return this.busThuId;
	}

	public void setBusThuId(Integer busThuId) {
		this.busThuId = busThuId;
	}

	public Integer getBusLevel() {
		return this.busLevel;
	}

	public void setBusLevel(Integer busLevel) {
		this.busLevel = busLevel;
	}

	public String getBaCountry() {
		return this.baCountry;
	}

	public void setBaCountry(String baCountry) {
		this.baCountry = baCountry;
	}

	public String getBaProvince() {
		return this.baProvince;
	}

	public void setBaProvince(String baProvince) {
		this.baProvince = baProvince;
	}

	public String getBaCity() {
		return this.baCity;
	}

	public void setBaCity(String baCity) {
		this.baCity = baCity;
	}

	public String getBaCounty() {
		return this.baCounty;
	}

	public void setBaCounty(String baCounty) {
		this.baCounty = baCounty;
	}

	public String getBaAddress() {
		return this.baAddress;
	}

	public void setBaAddress(String baAddress) {
		this.baAddress = baAddress;
	}

	public Float getBaLatitude() {
		return this.baLatitude;
	}

	public void setBaLatitude(Float baLatitude) {
		this.baLatitude = baLatitude;
	}

	public Float getBaLongitude() {
		return this.baLongitude;
	}

	public void setBaLongitude(Float baLongitude) {
		this.baLongitude = baLongitude;
	}

	public String getBbBankCard() {
		return this.bbBankCard;
	}

	public void setBbBankCard(String bbBankCard) {
		this.bbBankCard = bbBankCard;
	}

	public String getBbBank() {
		return this.bbBank;
	}

	public void setBbBank(String bbBank) {
		this.bbBank = bbBank;
	}

	public String getBbBankPerson() {
		return this.bbBankPerson;
	}

	public void setBbBankPerson(String bbBankPerson) {
		this.bbBankPerson = bbBankPerson;
	}

	public String getBusIdcardUrl() {
		return this.busIdcardUrl;
	}

	public void setBusIdcardUrl(String busIdcardUrl) {
		this.busIdcardUrl = busIdcardUrl;
	}

	public String getBusPhone() {
		return this.busPhone;
	}

	public void setBusPhone(String busPhone) {
		this.busPhone = busPhone;
	}

	public String getBusTdCode() {
		return this.busTdCode;
	}

	public void setBusTdCode(String busTdCode) {
		this.busTdCode = busTdCode;
	}

	public String getBusShareUrl() {
		return this.busShareUrl;
	}

	public void setBusShareUrl(String busShareUrl) {
		this.busShareUrl = busShareUrl;
	}

	public Set getBusCoupons() {
		return this.busCoupons;
	}

	public void setBusCoupons(Set busCoupons) {
		this.busCoupons = busCoupons;
	}

	public Set getBills() {
		return this.bills;
	}

	public void setBills(Set bills) {
		this.bills = bills;
	}

}