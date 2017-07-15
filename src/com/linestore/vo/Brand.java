package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Brand entity. @author MyEclipse Persistence Tools
 */

public class Brand implements java.io.Serializable {

	// Fields

	private Integer braId;
	private Catetory catetory;
	private String braName;
	private Integer braFirstChar;
	private String braLogoUrl;
	private String braUrl;
	private Set goodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** full constructor */
	public Brand(Catetory catetory, String braName, Integer braFirstChar, String braLogoUrl, String braUrl,
			Set goodses) {
		this.catetory = catetory;
		this.braName = braName;
		this.braFirstChar = braFirstChar;
		this.braLogoUrl = braLogoUrl;
		this.braUrl = braUrl;
		this.goodses = goodses;
	}

	// Property accessors

	public Integer getBraId() {
		return this.braId;
	}

	public void setBraId(Integer braId) {
		this.braId = braId;
	}

	public Catetory getCatetory() {
		return this.catetory;
	}

	public void setCatetory(Catetory catetory) {
		this.catetory = catetory;
	}

	public String getBraName() {
		return this.braName;
	}

	public void setBraName(String braName) {
		this.braName = braName;
	}

	public Integer getBraFirstChar() {
		return this.braFirstChar;
	}

	public void setBraFirstChar(Integer braFirstChar) {
		this.braFirstChar = braFirstChar;
	}

	public String getBraLogoUrl() {
		return this.braLogoUrl;
	}

	public void setBraLogoUrl(String braLogoUrl) {
		this.braLogoUrl = braLogoUrl;
	}

	public String getBraUrl() {
		return this.braUrl;
	}

	public void setBraUrl(String braUrl) {
		this.braUrl = braUrl;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

}