package com.linestore.vo;

/**
 * CateLine entity. @author MyEclipse Persistence Tools
 */

public class CateLine implements java.io.Serializable {

	// Fields

	private Integer calId;
	private String calName;
	private String calImg;
	private Integer calStatus;
	private Integer calAuth;

	// Constructors

	/** default constructor */
	public CateLine() {
	}

	/** full constructor */
	public CateLine(String calName, String calImg, Integer calStatus, Integer calAuth) {
		this.calName = calName;
		this.calImg = calImg;
		this.calStatus = calStatus;
		this.calAuth = calAuth;
	}

	// Property accessors

	public Integer getCalId() {
		return this.calId;
	}

	public void setCalId(Integer calId) {
		this.calId = calId;
	}

	public String getCalName() {
		return this.calName;
	}

	public void setCalName(String calName) {
		this.calName = calName;
	}

	public String getCalImg() {
		return this.calImg;
	}

	public void setCalImg(String calImg) {
		this.calImg = calImg;
	}

	public Integer getCalStatus() {
		return this.calStatus;
	}

	public void setCalStatus(Integer calStatus) {
		this.calStatus = calStatus;
	}

	public Integer getCalAuth() {
		return this.calAuth;
	}

	public void setCalAuth(Integer calAuth) {
		this.calAuth = calAuth;
	}

}