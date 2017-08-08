package com.linestore.vo;

/**
 * BusinessTmp entity. @author MyEclipse Persistence Tools
 */

public class BusinessTmp implements java.io.Serializable {

	// Fields

	private Integer busId;
	private String busShopName;
	private String busOwnerName;
	private String busDesc;
	private String busLicenseUrl;
	private String busTaxUrl;
	private String busOrgUrl;
	private Integer busDistrict;
	private Integer busSmallCate;
	private Integer busStatus;
	private Integer busAreaId;
	private Float busScale;
	private Float busScalePoints;
	private Integer busLevel;
	private Integer busCusId;
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
	private Integer busCalId;
	private String busIdcardUrl;
	private String busPhone;
	private String busTdCode;
	private String busShareUrl;
	private Float busChange;
	private String busEphone;

	// Constructors

	/** default constructor */
	public BusinessTmp() {
	}
	
	public BusinessTmp(Business bus) {
		this.busShopName = bus.getBusShopName();
		this.busOwnerName = bus.getBusOwnerName();
		this.busDesc = bus.getBusDesc();
		this.busLicenseUrl = bus.getBusLicenseUrl();
		this.busTaxUrl = bus.getBusTaxUrl();
		this.busOrgUrl = bus.getBusOrgUrl();
		this.busDistrict = bus.getBusDistrict();
		this.busSmallCate = bus.getBusSmallCate();
		this.busStatus = bus.getBusStatus();
		this.busAreaId = bus.getArea().getId();
		this.busScale = bus.getBusScale();
		this.busScalePoints = bus.getBusScalePoints();
		this.busLevel = bus.getBusLevel();
		this.busCusId = bus.getCustomer().getCusId();
		this.baCountry = bus.getBaCountry();
		this.baProvince = bus.getBaProvince();
		this.baCity = bus.getBaCity();
		this.baCounty = bus.getBaCounty();
		this.baAddress = bus.getBaAddress();
		this.baLatitude = bus.getBaLatitude();
		this.baLongitude = bus.getBaLongitude();
		this.bbBankCard = bus.getBbBankCard();
		this.bbBank = bus.getBbBank();
		this.bbBankPerson = bus.getBbBankPerson();
		this.busCalId = bus.getCateLine().getCalId();
		this.busIdcardUrl = bus.getBusIdcardUrl();
		this.busPhone = bus.getBusPhone();
		this.busTdCode = bus.getBusTdCode();
		this.busShareUrl = bus.getBusShareUrl();
		this.busChange = bus.getBusChange();
		this.busEphone = bus.getBusEphone();
	}

	/** full constructor */
	public BusinessTmp(String busShopName, String busOwnerName, String busDesc, String busLicenseUrl, String busTaxUrl,
			String busOrgUrl, Integer busDistrict, Integer busSmallCate, Integer busStatus, Integer busAreaId,
			Float busScale, Float busScalePoints, Integer busLevel, Integer busCusId, String baCountry,
			String baProvince, String baCity, String baCounty, String baAddress, Float baLatitude, Float baLongitude,
			String bbBankCard, String bbBank, String bbBankPerson, Integer busCalId, String busIdcardUrl,
			String busPhone, String busTdCode, String busShareUrl, Float busChange, String busEphone) {
		this.busShopName = busShopName;
		this.busOwnerName = busOwnerName;
		this.busDesc = busDesc;
		this.busLicenseUrl = busLicenseUrl;
		this.busTaxUrl = busTaxUrl;
		this.busOrgUrl = busOrgUrl;
		this.busDistrict = busDistrict;
		this.busSmallCate = busSmallCate;
		this.busStatus = busStatus;
		this.busAreaId = busAreaId;
		this.busScale = busScale;
		this.busScalePoints = busScalePoints;
		this.busLevel = busLevel;
		this.busCusId = busCusId;
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
		this.busCalId = busCalId;
		this.busIdcardUrl = busIdcardUrl;
		this.busPhone = busPhone;
		this.busTdCode = busTdCode;
		this.busShareUrl = busShareUrl;
		this.busChange = busChange;
		this.busEphone = busEphone;
	}

	// Property accessors

	public Integer getBusId() {
		return this.busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
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

	public Integer getBusAreaId() {
		return busAreaId;
	}

	public void setBusAreaId(Integer busAreaId) {
		this.busAreaId = busAreaId;
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

	public Integer getBusCusId() {
		return this.busCusId;
	}

	public void setBusCusId(Integer busCusId) {
		this.busCusId = busCusId;
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

	public Integer getBusCalId() {
		return this.busCalId;
	}

	public void setBusCalId(Integer busCalId) {
		this.busCalId = busCalId;
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

}