package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Business entity. @author MyEclipse Persistence Tools
 */

public class Business implements java.io.Serializable {

	// Fields

	private Integer busId;
	private CateLine cateLine;
	private Customer customer;
	private Area area;
	private String busShopName;
	private String busOwnerName;
	private String busDesc;
	private String busLicenseUrl;
	private String busTaxUrl;
	private String busOrgUrl;
	private Integer busDistrict;
	private Integer busSmallCate;
	private Integer busStatus;
	private Float busScale;
	private Float busScalePoints;
	private Integer busLevel;
	private String baCountry;
	private String baProvince;
	private String baCity;
	private String baCounty;
	private String baAddress;
	private Float baLatitude;
	private Float baLongitude;
	private String bbBankCard;
	private String bbBank;
	private String bbBankPerson;
	private String busIdcardUrl;
	private String busPhone;
	private String busTdCode;
	private String busShareUrl;
	private Float busChange;
	private String busEphone;
	private Set busMembers = new HashSet(0);
	private Set busCoupons = new HashSet(0);
	private Set busTradings = new HashSet(0);
	private Set bills = new HashSet(0);

	// Constructors
	/** default constructor */
	public Business() {
	}
	
	public Business(BusinessTmp bust) {
		this.busId = bust.getBusId();
		this.cateLine.setCalId(bust.getBusCalId());
		this.customer.setCusId(bust.getBusCusId());
		this.area.setId(bust.getBusAreaId());
		this.busShopName = bust.getBusShopName();
		this.busOwnerName = bust.getBusOwnerName();
		this.busDesc = bust.getBusDesc();
		this.busLicenseUrl = bust.getBusLicenseUrl();
		this.busTaxUrl = bust.getBusTaxUrl();
		this.busOrgUrl = bust.getBusOrgUrl();
		this.busDistrict = bust.getBusDistrict();
		this.busSmallCate = bust.getBusSmallCate();
		this.busStatus = bust.getBusStatus();
		this.busScale = bust.getBusScale();
		this.busScalePoints = bust.getBusScalePoints();
		this.busLevel = bust.getBusLevel();
		this.baCountry = bust.getBaCountry();
		this.baProvince = bust.getBaProvince();
		this.baCity = bust.getBaCity();
		this.baCounty = bust.getBaCounty();
		this.baAddress = bust.getBaAddress();
		this.baLatitude = bust.getBaLatitude();
		this.baLongitude = bust.getBaLongitude();
		this.bbBankCard = bust.getBbBankCard();
		this.bbBank = bust.getBbBank();
		this.bbBankPerson = bust.getBbBankPerson();
		this.busIdcardUrl = bust.getBusIdcardUrl();
		this.busPhone = bust.getBusPhone();
		this.busTdCode = bust.getBusTdCode();
		this.busShareUrl = bust.getBusShareUrl();
		this.busChange = bust.getBusChange();
		this.busEphone = bust.getBusEphone();
	}

	/** full constructor */
	public Business(CateLine cateLine, Customer customer, Area area, String busShopName, String busOwnerName,
			String busDesc, String busLicenseUrl, String busTaxUrl, String busOrgUrl, Integer busDistrict,
			Integer busSmallCate, Integer busStatus, Float busScale, Float busScalePoints, Integer busLevel,
			String baCountry, String baProvince, String baCity, String baCounty, String baAddress, Float baLatitude,
			Float baLongitude, String bbBankCard, String bbBank, String bbBankPerson, String busIdcardUrl,
			String busPhone, String busTdCode, String busShareUrl, Float busChange, String busEphone, Set busMembers,
			Set busCoupons, Set busTradings, Set bills) {
		this.cateLine = cateLine;
		this.customer = customer;
		this.area = area;
		this.busShopName = busShopName;
		this.busOwnerName = busOwnerName;
		this.busDesc = busDesc;
		this.busLicenseUrl = busLicenseUrl;
		this.busTaxUrl = busTaxUrl;
		this.busOrgUrl = busOrgUrl;
		this.busDistrict = busDistrict;
		this.busSmallCate = busSmallCate;
		this.busStatus = busStatus;
		this.busScale = busScale;
		this.busScalePoints = busScalePoints;
		this.busLevel = busLevel;
		this.baCountry = baCountry;
		this.baProvince = baProvince;
		this.baCity = baCity;
		this.baCounty = baCounty;
		this.baAddress = baAddress;
		this.baLatitude = baLatitude;
		this.baLongitude = baLongitude;
		this.bbBankCard = bbBankCard;
		this.bbBank = bbBank;
		this.bbBankPerson = bbBankPerson;
		this.busIdcardUrl = busIdcardUrl;
		this.busPhone = busPhone;
		this.busTdCode = busTdCode;
		this.busShareUrl = busShareUrl;
		this.busChange = busChange;
		this.busEphone = busEphone;
		this.busMembers = busMembers;
		this.busCoupons = busCoupons;
		this.busTradings = busTradings;
		this.bills = bills;
	}

	// Property accessors

	public Integer getBusId() {
		return this.busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
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

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
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

	public Float getBusScale() {
		return this.busScale;
	}

	public void setBusScale(Float busScale) {
		this.busScale = busScale;
	}

	public Float getBusScalePoints() {
		return this.busScalePoints;
	}

	public void setBusScalePoints(Float busScalePoints) {
		this.busScalePoints = busScalePoints;
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

	public Float getBusChange() {
		return this.busChange;
	}

	public void setBusChange(Float busChange) {
		this.busChange = busChange;
	}

	public String getBusEphone() {
		return this.busEphone;
	}

	public void setBusEphone(String busEphone) {
		this.busEphone = busEphone;
	}

	public Set getBusMembers() {
		return this.busMembers;
	}

	public void setBusMembers(Set busMembers) {
		this.busMembers = busMembers;
	}

	public Set getBusCoupons() {
		return this.busCoupons;
	}

	public void setBusCoupons(Set busCoupons) {
		this.busCoupons = busCoupons;
	}

	public Set getBusTradings() {
		return this.busTradings;
	}

	public void setBusTradings(Set busTradings) {
		this.busTradings = busTradings;
	}

	public Set getBills() {
		return this.bills;
	}

	public void setBills(Set bills) {
		this.bills = bills;
	}

}