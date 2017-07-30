package com.linestore.vo;

import java.util.Map;

public class Template {
	private String openId;
	private String first;
	private String remark;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public StringBuffer getUrl() {
		return url;
	}

	public void setUrl(StringBuffer stringBuffer) {
		this.url = stringBuffer;
	}

	public Map<String, String> getKeyword() {
		return keyword;
	}

	public void setKeyword(Map<String, String> keyword) {
		this.keyword = keyword;
	}

	private StringBuffer url;
	private Map<String, String> keyword;
}
