package com.linestore.vo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class CustomerModel {
	private int cusId;
    private String cusNickname;
    private String cusImgUrl;
    private int cusSex;
    private Date cusBirth;
    private String cusHobby;
    private String cusTagId;
    private String cusPhone;
    private String cusPassword;
    private int cusStatus;
    private String cusOpenId;
    private Set<CusAddressModel> cusAddressSet=new HashSet<CusAddressModel>();
    
    
    public CustomerModel(){
    	
    }
    
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusNickname() {
		return cusNickname;
	}
	public void setCusNickname(String cusNickname) {
		this.cusNickname = cusNickname;
	}
	public String getCusImgUrl() {
		return cusImgUrl;
	}
	public void setCusImgUrl(String cusImgUrl) {
		this.cusImgUrl = cusImgUrl;
	}
	public int getCusSex() {
		return cusSex;
	}
	public void setCusSex(int cusSex) {
		this.cusSex = cusSex;
	}
	public Date getCusBirth() {
		return cusBirth;
	}
	public void setCusBirth(Date cusBirth) {
		this.cusBirth = cusBirth;
	}
	public String getCusHobby() {
		return cusHobby;
	}
	public void setCusHobby(String cusHobby) {
		this.cusHobby = cusHobby;
	}
	public String getCusTagId() {
		return cusTagId;
	}
	public void setCusTagId(String cusTagId) {
		this.cusTagId = cusTagId;
	}
	public String getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getCusPassword() {
		return cusPassword;
	}
	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}
	
	
	

	public int getCusStatus() {
		return cusStatus;
	}

	public void setCusStatus(int cusStatus) {
		this.cusStatus = cusStatus;
	}

	public String getCusOpenId() {
		return cusOpenId;
	}
	public void setCusOpenId(String cusOpenId) {
		this.cusOpenId = cusOpenId;
	}
	public Set<CusAddressModel> getCusAddressSet() {
		return cusAddressSet;
	}
	public void setCusAddressSet(Set<CusAddressModel> cusAddressSet) {
		this.cusAddressSet = cusAddressSet;
	}
    
	
 
}
