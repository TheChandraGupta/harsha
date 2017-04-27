package com.harsha.app.bean;

public class SchemeBean {

	private String schemeName;
	private int schemeId;
	
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public SchemeBean(String schemeName, int schemeId) {
		super();
		this.schemeName = schemeName;
		this.schemeId = schemeId;
	}
	public SchemeBean() {
		super();
	}
	public int getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}
}
