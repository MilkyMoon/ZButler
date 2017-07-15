package com.linestore.vo;

import java.sql.Timestamp;

public class MessageModel {
	private int mesId;
    private int mesCusId;
    private String mesTitle;
    private String mesType;
    private String mesContent;
    private Timestamp mesTime;
	public int getMesId() {
		return mesId;
	}
	public void setMesId(int mesId) {
		this.mesId = mesId;
	}
	public int getMesCusId() {
		return mesCusId;
	}
	public void setMesCusId(int mesCusId) {
		this.mesCusId = mesCusId;
	}
	public String getMesTitle() {
		return mesTitle;
	}
	public void setMesTitle(String mesTitle) {
		this.mesTitle = mesTitle;
	}
	public String getMesType() {
		return mesType;
	}
	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
	public String getMesContent() {
		return mesContent;
	}
	public void setMesContent(String mesContent) {
		this.mesContent = mesContent;
	}
	public Timestamp getMesTime() {
		return mesTime;
	}
	public void setMesTime(Timestamp mesTime) {
		this.mesTime = mesTime;
	}


	
 
}
