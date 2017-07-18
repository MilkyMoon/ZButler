package com.linestore.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private Integer cusId;
	private String cusNickname;
	private String cusImgUrl;
	private Integer cusSex;
	private Date cusBirth;
	private String cusHobby;
	private String cusTagId;
	private String cusPhone;
	private String cusPassword;
	private Integer cusStatus;
	private String cusOpenId;
	private String cusTdCode;
	private String cusShareUrl;
	
	private Set<CusAddress> cusAddresses = new HashSet<CusAddress>();
	private Set<Message> messages = new HashSet<Message>();
	private Set<CusBank> cusBanks = new HashSet<CusBank>();
	private Set<History> histories = new HashSet<History>();
	private Set<Evaluate> evaluates = new HashSet<Evaluate>();
	private Set<Friends> friendses = new HashSet<Friends>();
	private Set<CusAccount> cusAccounts = new HashSet<CusAccount>();
	private Set<Order> orders = new HashSet<Order>();
	 private Set<CtaTrading> ctaTradings=new HashSet<CtaTrading>();
	private Set<CusCoupon> cusCoupons = new HashSet<CusCoupon>();

	// private Set cusBanks = new HashSet(0);
	// private Set histories = new HashSet(0);
	//// private Set cusAddresses = new HashSet(0);
	// private Set evaluates = new HashSet(0);
	// private Set friendses = new HashSet(0);
	// private Set cusAccounts = new HashSet(0);
	// private Set orders = new HashSet(0);
//	private Set ctaTradings = new HashSet(0);
	//// private Set messages = new HashSet(0);
	// private Set cusCoupons = new HashSet(0);

	// Constructors

//	/** default constructor */
//	public Customer() {
//	}
//
//	/** full constructor */
//	public Customer(String cusNickname, String cusImgUrl, Integer cusSex, Date cusBirth, String cusHobby,
//			String cusTagId, String cusPhone, String cusPassword, Integer cusStatus, String cusOpenId, Set cusBanks,
//			Set histories, Set cusAddresses, Set evaluates, Set friendses, Set cusAccounts, Set orders, Set ctaTradings,
//			Set messages, Set cusCoupons) {
//		this.cusNickname = cusNickname;
//		this.cusImgUrl = cusImgUrl;
//		this.cusSex = cusSex;
//		this.cusBirth = cusBirth;
//		this.cusHobby = cusHobby;
//		this.cusTagId = cusTagId;
//		this.cusPhone = cusPhone;
//		this.cusPassword = cusPassword;
//		this.cusStatus = cusStatus;
//		this.cusOpenId = cusOpenId;
//		this.cusBanks = cusBanks;
//		this.histories = histories;
//		this.cusAddresses = cusAddresses;
//		this.evaluates = evaluates;
//		this.friendses = friendses;
//		this.cusAccounts = cusAccounts;
//		this.orders = orders;
//		this.ctaTradings = ctaTradings;
//		this.messages = messages;
//		this.cusCoupons = cusCoupons;
//	}

	// Property accessors

	public Integer getCusId() {
		return this.cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getCusNickname() {
		return this.cusNickname;
	}

	public void setCusNickname(String cusNickname) {
		this.cusNickname = cusNickname;
	}

	public String getCusImgUrl() {
		return this.cusImgUrl;
	}

	public void setCusImgUrl(String cusImgUrl) {
		this.cusImgUrl = cusImgUrl;
	}

	public Integer getCusSex() {
		return cusSex;
	}

	public void setCusSex(Integer cusSex) {
		this.cusSex = cusSex;
	}

	public Date getCusBirth() {
		return this.cusBirth;
	}

	public void setCusBirth(Date cusBirth) {
		this.cusBirth = cusBirth;
	}

	public String getCusHobby() {
		return this.cusHobby;
	}

	public void setCusHobby(String cusHobby) {
		this.cusHobby = cusHobby;
	}

	public String getCusTagId() {
		return this.cusTagId;
	}

	public void setCusTagId(String cusTagId) {
		this.cusTagId = cusTagId;
	}

	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusPassword() {
		return this.cusPassword;
	}

	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}


	public Integer getCusStatus() {
		return cusStatus;
	}

	public void setCusStatus(Integer cusStatus) {
		this.cusStatus = cusStatus;
	}

	public String getCusOpenId() {
		return this.cusOpenId;
	}

	public void setCusOpenId(String cusOpenId) {
		this.cusOpenId = cusOpenId;
	}

	public Set<CusAddress> getCusAddresses() {
		return cusAddresses;
	}

	public void setCusAddresses(Set<CusAddress> cusAddresses) {
		this.cusAddresses = cusAddresses;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<CusBank> getCusBanks() {
		return cusBanks;
	}

	public void setCusBanks(Set<CusBank> cusBanks) {
		this.cusBanks = cusBanks;
	}

	public Set<History> getHistories() {
		return histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}

	public Set<Evaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(Set<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	public Set<Friends> getFriendses() {
		return friendses;
	}

	public void setFriendses(Set<Friends> friendses) {
		this.friendses = friendses;
	}

	public Set<CusAccount> getCusAccounts() {
		return cusAccounts;
	}

	public void setCusAccounts(Set<CusAccount> cusAccounts) {
		this.cusAccounts = cusAccounts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	 public Set<CtaTrading> getCtaTradings() {
	 return ctaTradings;
	 }
	
	 public void setCtaTradings(Set<CtaTrading> ctaTradings) {
	 this.ctaTradings = ctaTradings;
	 }

	public Set<CusCoupon> getCusCoupons() {
		return cusCoupons;
	}

	public void setCusCoupons(Set<CusCoupon> cusCoupons) {
		this.cusCoupons = cusCoupons;
	}

	public String getCusTdCode() {
		return cusTdCode;
	}

	public void setCusTdCode(String cusTdCode) {
		this.cusTdCode = cusTdCode;
	}

	public String getCusShareUrl() {
		return cusShareUrl;
	}

	public void setCusShareUrl(String cusShareUrl) {
		this.cusShareUrl = cusShareUrl;
	}

	// public Set getCusBanks() {
	// return this.cusBanks;
	// }
	//
	// public void setCusBanks(Set cusBanks) {
	// this.cusBanks = cusBanks;
	// }
	//
	// public Set getHistories() {
	// return this.histories;
	// }
	//
	// public void setHistories(Set histories) {
	// this.histories = histories;
	// }
	//
	// public Set getCusAddresses() {
	// return this.cusAddresses;
	// }
	//
	// public void setCusAddresses(Set cusAddresses) {
	// this.cusAddresses = cusAddresses;
	// }
	//
	// public Set getEvaluates() {
	// return this.evaluates;
	// }
	//
	// public void setEvaluates(Set evaluates) {
	// this.evaluates = evaluates;
	// }
	//
	// public Set getFriendses() {
	// return this.friendses;
	// }
	//
	// public void setFriendses(Set friendses) {
	// this.friendses = friendses;
	// }
	//
	// public Set getCusAccounts() {
	// return this.cusAccounts;
	// }
	//
	// public void setCusAccounts(Set cusAccounts) {
	// this.cusAccounts = cusAccounts;
	// }
	//
	// public Set getOrders() {
	// return this.orders;
	// }
	//
	// public void setOrders(Set orders) {
	// this.orders = orders;
	// }
	//
//	public Set getCtaTradings() {
//		return this.ctaTradings;
//	}
//
//	public void setCtaTradings(Set ctaTradings) {
//		this.ctaTradings = ctaTradings;
//	}
	//
	// public Set getMessages() {
	// return this.messages;
	// }
	//
	// public void setMessages(Set messages) {
	// this.messages = messages;
	// }
	//
	// public Set getCusCoupons() {
	// return this.cusCoupons;
	// }
	//
	// public void setCusCoupons(Set cusCoupons) {
	// this.cusCoupons = cusCoupons;
	// }

}