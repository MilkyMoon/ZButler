package com.linestore.vo;

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
	private Float thuScale;
	private String thuOpenid;
	private String thuBill;
	private Integer thuWay;
	private Float thuScaleTwo;
	private String thuBankCard;

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
		this.thuScale = thu.getThuScale();
		this.thuScaleTwo = thu.getThuScaleTwo();
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
			String thuEmail, String thuPhone, String thuName, Float thuScale, String thuOpenid, String thuBill,
			Integer thuWay, Float thuScaleTwo, String thuBankCard) {
		this.group = group;
		this.area = area;
		this.thuUsername = thuUsername;
		this.thuPassword = thuPassword;
		this.thuStatus = thuStatus;
		this.thuDesc = thuDesc;
		this.thuEmail = thuEmail;
		this.thuPhone = thuPhone;
		this.thuName = thuName;
		this.thuScale = thuScale;
		this.thuOpenid = thuOpenid;
		this.thuBill = thuBill;
		this.thuWay = thuWay;
		this.thuScaleTwo = thuScaleTwo;
		this.thuBankCard = thuBankCard;
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

	public Float getThuScale() {
		return this.thuScale;
	}

	public void setThuScale(Float thuScale) {
		this.thuScale = thuScale;
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

	public Integer getThuWay() {
		return this.thuWay;
	}

	public void setThuWay(Integer thuWay) {
		this.thuWay = thuWay;
	}

	public Float getThuScaleTwo() {
		return this.thuScaleTwo;
	}

	public void setThuScaleTwo(Float thuScaleTwo) {
		this.thuScaleTwo = thuScaleTwo;
	}

	public String getThuBankCard() {
		return this.thuBankCard;
	}

	public void setThuBankCard(String thuBankCard) {
		this.thuBankCard = thuBankCard;
	}

}