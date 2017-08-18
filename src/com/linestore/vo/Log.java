package com.linestore.vo;

import java.sql.Timestamp;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */

public class Log implements java.io.Serializable {

	// Fields

	private Integer logId;
	private String logContent;
	private Integer logThuId;
	private String logThuName;
	private Integer logAreaId;
	private String logAreaName;
	private Timestamp logDate;
	private Integer logStatus;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	

	// Property accessors

	public Integer getLogId() {
		return this.logId;
	}

	public Log(Integer logId, String logContent, Integer logThuId, String logThuName, Integer logAreaId,
			String logAreaName, Timestamp logDate, Integer logStatus) {
		super();
		this.logId = logId;
		this.logContent = logContent;
		this.logThuId = logThuId;
		this.logThuName = logThuName;
		this.logAreaId = logAreaId;
		this.logAreaName = logAreaName;
		this.logDate = logDate;
		this.logStatus = logStatus;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getLogContent() {
		return this.logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public Integer getLogThuId() {
		return this.logThuId;
	}

	public void setLogThuId(Integer logThuId) {
		this.logThuId = logThuId;
	}

	public String getLogThuName() {
		return this.logThuName;
	}

	public void setLogThuName(String logThuName) {
		this.logThuName = logThuName;
	}

	public Integer getLogAreaId() {
		return this.logAreaId;
	}

	public void setLogAreaId(Integer logAreaId) {
		this.logAreaId = logAreaId;
	}

	public String getLogAreaName() {
		return this.logAreaName;
	}

	public void setLogAreaName(String logAreaName) {
		this.logAreaName = logAreaName;
	}

	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	public Integer getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}
	
	

}