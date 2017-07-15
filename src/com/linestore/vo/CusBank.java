package com.linestore.vo;

/**
 * CusBank entity. @author MyEclipse Persistence Tools
 */

public class CusBank implements java.io.Serializable {

	// Fields

	private Integer cbId;
	private Customer customer;
	private String cbBankCard;
	private String cbBank;
	private String cbBankPerson;

	// Constructors

	/** default constructor */
	public CusBank() {
	}

	/** full constructor */
	public CusBank(Customer customer, String cbBankCard, String cbBank, String cbBankPerson) {
		this.customer = customer;
		this.cbBankCard = cbBankCard;
		this.cbBank = cbBank;
		this.cbBankPerson = cbBankPerson;
	}

	// Property accessors

	public Integer getCbId() {
		return this.cbId;
	}

	public void setCbId(Integer cbId) {
		this.cbId = cbId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCbBankCard() {
		return this.cbBankCard;
	}

	public void setCbBankCard(String cbBankCard) {
		this.cbBankCard = cbBankCard;
	}

	public String getCbBank() {
		return this.cbBank;
	}

	public void setCbBank(String cbBank) {
		this.cbBank = cbBank;
	}

	public String getCbBankPerson() {
		return this.cbBankPerson;
	}

	public void setCbBankPerson(String cbBankPerson) {
		this.cbBankPerson = cbBankPerson;
	}

}