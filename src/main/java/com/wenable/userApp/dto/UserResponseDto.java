package com.wenable.userApp.dto;

public class UserResponseDto {

	  private String userName;
	    private String email;
	    private String pwd;
	    private String firstName;
	    private String lastName;
	    private String phoneNumber;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String uName) {
			this.userName = uName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
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
	
	

	
}
