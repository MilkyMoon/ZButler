package com.linestore.vo;

/**
 * Pictures entity. @author MyEclipse Persistence Tools
 */

public class Pictures implements java.io.Serializable {

	// Fields

	private Integer picId;
	private String picUrl;
	private Integer picOtherId;
	private Boolean picType;
	private String picMd5;
	private Integer picShareUrl;

	// Constructors

	/** default constructor */
	public Pictures() {
	}

	/** full constructor */
	public Pictures(String picUrl, Integer picOtherId, Boolean picType, String picMd5, Integer picShareUrl) {
		this.picUrl = picUrl;
		this.picOtherId = picOtherId;
		this.picType = picType;
		this.picMd5 = picMd5;
		this.picShareUrl = picShareUrl;
	}

	// Property accessors

	public Integer getPicId() {
		return this.picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getPicOtherId() {
		return this.picOtherId;
	}

	public void setPicOtherId(Integer picOtherId) {
		this.picOtherId = picOtherId;
	}

	public Boolean getPicType() {
		return this.picType;
	}

	public void setPicType(Boolean picType) {
		this.picType = picType;
	}

	public String getPicMd5() {
		return this.picMd5;
	}

	public void setPicMd5(String picMd5) {
		this.picMd5 = picMd5;
	}

	public Integer getPicShareUrl() {
		return this.picShareUrl;
	}

	public void setPicShareUrl(Integer picShareUrl) {
		this.picShareUrl = picShareUrl;
	}

}