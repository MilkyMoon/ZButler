package com.linestore.vo;

/**
 * CusAddress entity. @author MyEclipse Persistence Tools
 */

public class CusAddress implements java.io.Serializable {

	private int caId;
//  private int caCusId;
  private String caCountry;
  private String caProvince;
  private String caCity;
  private String caAddress;
  private String caName;
  private String caPhone;
  private Customer customer;
  
  
	public int getCaId() {
		return caId;
	}
	public void setCaId(int caId) {
		this.caId = caId;
	}
	
	public String getCaCountry() {
		return caCountry;
	}
	public void setCaCountry(String caCountry) {
		this.caCountry = caCountry;
	}
	public String getCaProvince() {
		return caProvince;
	}
	public void setCaProvince(String caProvince) {
		this.caProvince = caProvince;
	}
	public String getCaCity() {
		return caCity;
	}
	public void setCaCity(String caCity) {
		this.caCity = caCity;
	}
	public String getCaAddress() {
		return caAddress;
	}
	public void setCaAddress(String caAddress) {
		this.caAddress = caAddress;
	}
	public String getCaName() {
		return caName;
	}
	public void setCaName(String caName) {
		this.caName = caName;
	}
	public String getCaPhone() {
		return caPhone;
	}
	public void setCaPhone(String caPhone) {
		this.caPhone = caPhone;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
  
  

}