package com.linestore.vo;

// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ThinkUser entity. @author MyEclipse Persistence Tools
 */

public class ThinkUser implements java.io.Serializable {

	// Fields

	private Integer thuId;
	private String thuUsername;
	private String thuPassword;
	private String thuStatus;
	private Integer thuPid;
	private String thuArea;
	private String thuEmail;
	private String thuPhone;
	private String thuName;
	private Set groupAccesses = new HashSet(0);

	// Constructors

	/** default constructor */
	public ThinkUser() {
	}

	public ThinkUser(ThinkUser thu) {
		this.thuId = thu.getThuId();
		this.thuUsername = thu.getThuUsername();
		this.thuPassword = thu.getThuPassword();
		this.thuStatus = thu.getThuStatus();
		this.thuPid = thu.getThuPid();
		this.thuArea = thu.getThuArea();
		this.thuEmail = thu.getThuEmail();
		this.thuPhone = thu.getThuPhone();
		this.thuName = thu.getThuName();
	}

	/** minimal constructor */
	public ThinkUser(String thuName, String thuPassword, String thuStatus) {
		this.thuName = thuName;
		this.thuPassword = thuPassword;
		this.thuStatus = thuStatus;
	}

	/** full constructor */
	public ThinkUser(String thuUsername, String thuPassword, String thuStatus, Timestamp thuCreateTime,
			Timestamp thuUpdateTime, Integer thuPid, String thuArea, String thuEmail, String thuPhone,
			Set groupAccesses,String thuName) {
		this.thuUsername = thuUsername;
		this.thuPassword = thuPassword;
		this.thuStatus = thuStatus;
		this.thuPid = thuPid;
		this.thuArea = thuArea;
		this.thuEmail = thuEmail;
		this.thuPhone = thuPhone;
		this.groupAccesses = groupAccesses;
		this.thuName = thuName;
	}

	// Property accessors

	public Integer getThuId() {
		return this.thuId;
	}

	public void setThuId(Integer thuId) {
		this.thuId = thuId;
	}
	
	public String getThuUsername() {
		return this.thuUsername;
	}

	public void setThuUsername(String thuUsername) {
		this.thuUsername = thuUsername;
	}

	public String getThuName() {
		return this.thuName;
	}

	public void setThuName(String thuName) {
		this.thuName = thuName;
	}

	public String getThuPassword() {
		return this.thuPassword;
	}

	public void setThuPassword(String thuPassword) {
		this.thuPassword = thuPassword;
	}

	public String getThuStatus() {
		return this.thuStatus;
	}

	public void setThuStatus(String thuStatus) {
		this.thuStatus = thuStatus;
	}

	public Integer getThuPid() {
		return this.thuPid;
	}

	public void setThuPid(Integer thuPid) {
		this.thuPid = thuPid;
	}

	public String getThuArea() {
		return this.thuArea;
	}

	public void setThuArea(String thuArea) {
		this.thuArea = thuArea;
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

	public Set getGroupAccesses() {
		return this.groupAccesses;
	}

	public void setGroupAccesses(Set groupAccesses) {
		this.groupAccesses = groupAccesses;
	}

}