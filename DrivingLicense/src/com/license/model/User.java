package com.license.model;

public class User {
	
	private String name = null;
	private String username = null;
	private String emailId = null;
	private String password = null;
	private String DOB = null;
	private String mobileNum = null;
	private String address = null;
	private String testDate = null;
	private String gender = null;
	private String cardNum = null;
	private String cardName = null;
	private String expiryName = null;
	
	public User() {
		this.name = "";
		this.username = "";
		this.emailId = "";
		this.password = "";
		DOB = "";
		this.mobileNum = "";
		this.address = "";
		this.testDate = "";
		this.gender = "";
		this.cardNum = "";
		this.cardName = "";
		this.expiryName = "";
	}

	public User(String name, String username, String emailId, String password, String dOB, String mobileNum,
			String address, String testDate, String gender, String cardNum, String cardName, String expiryName) {
		
		super();
		this.name = name;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		DOB = dOB;
		this.mobileNum = mobileNum;
		this.address = address;
		this.testDate = testDate;
		this.gender = gender;
		this.cardNum = cardNum;
		this.cardName = cardName;
		this.expiryName = expiryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getExpiryName() {
		return expiryName;
	}

	public void setExpiryName(String expiryName) {
		this.expiryName = expiryName;
	}
	
}
