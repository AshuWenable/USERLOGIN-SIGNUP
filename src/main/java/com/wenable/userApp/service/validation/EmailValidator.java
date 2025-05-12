package com.wenable.userApp.service.validation;
import org.springframework.stereotype.Component;



@Component
public class EmailValidator {
	
	public boolean validateEmail(String email)
	{
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		
		return email!=null && email.matches(regex);
	}
	
	

}
