package com.linestore.vo;

/**
 * Tag entity. @author MyEclipse Persistence Tools
 */

public class Tag implements java.io.Serializable {

	// Fields

	private Integer tagId;
	private String tagName;

	// Constructors

	/** default constructor */
	public Tag() {
	}

	/** full constructor */
	public Tag(String tagName) {
		this.tagName = tagName;
	}

	// Property accessors

	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}