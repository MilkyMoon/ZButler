package com.linestore.vo;

/**
 * BusBank entity. @author MyEclipse Persistence Tools
 */

public class BusBank implements java.io.Serializable {

	// Fields

	private Integer bbId;
	private Business business;
	private String bbBankCard;
	private String bbBank;
	private String bbBankPerson;

	// Constructors

	/** default constructor */
	public BusBank() {
	}

	/** full constructor */
	public BusBank(Business business, String bbBankCard, String bbBank, String bbBankPerson) {
		this.business = business;
		this.bbBankCard = bbBankCard;
		this.bbBank = bbBank;
		this.bbBankPerson = bbBankPerson;
	}

	// Property accessors

	public Integer getBbId() {
		return this.bbId;
	}

	public void setBbId(Integer bbId) {
		this.bbId = bbId;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
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

}