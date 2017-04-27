package com.harsha.app.bean;

public class SocialCategoryBean {

	private String socialCategoryCode;
	private String socialCategoryName;
	private int socialcategoryId;
	
	public String getSocialCategoryCode() {
		return socialCategoryCode;
	}
	public void setSocialCategoryCode(String socialCategoryCode) {
		this.socialCategoryCode = socialCategoryCode;
	}
	public String getSocialCategoryName() {
		return socialCategoryName;
	}
	public void setSocialCategoryName(String socialCategoryName) {
		this.socialCategoryName = socialCategoryName;
	}
	public SocialCategoryBean(String socialCategoryCode, String socialCategoryName, int socialCategoryId) {
		super();
		this.socialCategoryCode = socialCategoryCode;
		this.socialCategoryName = socialCategoryName;
		this.socialcategoryId = socialCategoryId;
	}
	public SocialCategoryBean() {
		super();
	}
	public int getSocialcategoryId() {
		return socialcategoryId;
	}
	public void setSocialcategoryId(int socialcategoryId) {
		this.socialcategoryId = socialcategoryId;
	}
	
}
