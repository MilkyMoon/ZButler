package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * ThinkUser entity. @author MyEclipse Persistence Tools
 */

public class ThinkUser implements java.io.Serializable {

	// Fields

	private Integer thuId;
	private Group group;
	private Area area;
	private String thuUsername;
	private String thuPassword;
	private Integer thuStatus;
	private String thuDesc;
	private String thuEmail;
	private String thuPhone;
	private String thuName;
	private String thuOpenid;
	private String thuBill;
	private String thuBankCard;
	private Set billsForThuCountyId = new HashSet(0);
	private Set billsForThuProvinceId = new HashSet(0);
	private Set groupAccesses = new HashSet(0);
	private Set billsForThuPropertyId = new HashSet(0);
	private Set billsForThuCityId = new HashSet(0);

	// Constructors

	/** default constructor */
	public ThinkUser() {
	}
	
	public ThinkUser(ThinkUser thu) {
		this.thuId = thu.getThuId();
		this.thuUsername = thu.getThuUsername();
		this.thuPassword = thu.getThuPassword();
		this.thuStatus = thu.getThuStatus();
		this.area = thu.getArea();
		this.thuDesc = thu.getThuDesc();
		this.thuEmail = thu.getThuEmail();
		this.thuPhone = thu.getThuPhone();
		this.thuName = thu.getThuName();
		this.thuBankCard = thu.getThuBankCard();
		this.group = thu.getGroup();
	}

	/** minimal constructor */
	public ThinkUser(String thuUsername, String thuPassword) {
		this.thuUsername = thuUsername;
		this.thuPassword = thuPassword;
	}

	/** full constructor */
	public ThinkUser(Group group, Area area, String thuUsername, String thuPassword, Integer thuStatus, String thuDesc,
			String thuEmail, String thuPhone, String thuName, String thuOpenid, String thuBill, String thuBankCard,
			Set billsForThuCountyId, Set billsForThuProvinceId, Set groupAccesses, Set billsForThuPropertyId,
			Set billsForThuCityId) {
		this.group = group;
		this.area = area;
		this.thuUsername = thuUsername;
		this.thuPassword = thuPassword;
		this.thuStatus = thuStatus;
		this.thuDesc = thuDesc;
		this.thuEmail = thuEmail;
		this.thuPhone = thuPhone;
		this.thuName = thuName;
		this.thuOpenid = thuOpenid;
		this.thuBill = thuBill;
		this.thuBankCard = thuBankCard;
		this.billsForThuCountyId = billsForThuCountyId;
		this.billsForThuProvinceId = billsForThuProvinceId;
		this.groupAccesses = groupAccesses;
		this.billsForThuPropertyId = billsForThuPropertyId;
		this.billsForThuCityId = billsForThuCityId;
	}

	// Property accessors

	public Integer getThuId() {
		return this.thuId;
	}

	public void setThuId(Integer thuId) {
		this.thuId = thuId;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getThuUsername() {
		return this.thuUsername;
	}

	public void setThuUsername(String thuUsername) {
		this.thuUsername = thuUsername;
	}

	public String getThuPassword() {
		return this.thuPassword;
	}

	public void setThuPassword(String thuPassword) {
		this.thuPassword = thuPassword;
	}

	public Integer getThuStatus() {
		return this.thuStatus;
	}

	public void setThuStatus(Integer thuStatus) {
		this.thuStatus = thuStatus;
	}

	public String getThuDesc() {
		return this.thuDesc;
	}

	public void setThuDesc(String thuDesc) {
		this.thuDesc = thuDesc;
	}

	public String getThuEmail() {
		return this.thuEmail;
	}

	public void setThuEmail(String thuEmail) {
		this.thuEmail = thuEmail;
	}

	public String getThuPhone() {
		return this.thuPhone;
	}

	public void setThuPhone(String thuPhone) {
		this.thuPhone = thuPhone;
	}

	public String getThuName() {
		return this.thuName;
	}

	public void setThuName(String thuName) {
		this.thuName = thuName;
	}

	public String getThuOpenid() {
		return this.thuOpenid;
	}

	public void setThuOpenid(String thuOpenid) {
		this.thuOpenid = thuOpenid;
	}

	public String getThuBill() {
		return this.thuBill;
	}

	public void setThuBill(String thuBill) {
		this.thuBill = thuBill;
	}

	public String getThuBankCard() {
		return this.thuBankCard;
	}

	public void setThuBankCard(String thuBankCard) {
		this.thuBankCard = thuBankCard;
	}

	public Set getBillsForThuCountyId() {
		return this.billsForThuCountyId;
	}

	public void setBillsForThuCountyId(Set billsForThuCountyId) {
		this.billsForThuCountyId = billsForThuCountyId;
	}

	public Set getBillsForThuProvinceId() {
		return this.billsForThuProvinceId;
	}

	public void setBillsForThuProvinceId(Set billsForThuProvinceId) {
		this.billsForThuProvinceId = billsForThuProvinceId;
	}

	public Set getGroupAccesses() {
		return this.groupAccesses;
	}

	public void setGroupAccesses(Set groupAccesses) {
		this.groupAccesses = groupAccesses;
	}

	public Set getBillsForThuPropertyId() {
		return this.billsForThuPropertyId;
	}

	public void setBillsForThuPropertyId(Set billsForThuPropertyId) {
		this.billsForThuPropertyId = billsForThuPropertyId;
	}

	public Set getBillsForThuCityId() {
		return this.billsForThuCityId;
	}

	public void setBillsForThuCityId(Set billsForThuCityId) {
		this.billsForThuCityId = billsForThuCityId;
	}

}