package com.wenable.userApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {
	
	@Id
	private String uId;
	private String userName;
	private String email;
	private String psw;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public User() {
		super();
	}
	public void setUserName(String uName) {
		this.userName = uName;
	}
	public String getEmail() {
		return email;
	}
	public User(String uId, String uName, String email, String psw) {
		super();
		this.uId = uId;
		this.userName = uName;
		this.email = email;
		this.psw = psw;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", userName=" + userName + ", email=" + email + ", psw=" + psw + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
	

}
