package com.wenable.userApp.service.validation;

import org.springframework.stereotype.Component;

import com.wenable.userApp.userException.UserException;

@Component
public class PasswordValidator {
	
	@SuppressWarnings("null")
	public boolean isValidPwd(String pwd) throws UserException
	{
		if(pwd==null ||pwd.length()<8)
		{
			throw new UserException("Password must not be less than 8 character's");
		}
		boolean containsUpperCase=pwd.matches(".*[A-Z].*");
		boolean containsLowerCase=pwd.matches(".*[a-z].*");
		boolean containsDigit=pwd.matches(".*\\d.*");
		boolean containsSpecialChar=pwd.matches(".*[@$!%*?&].*");
		
		return containsDigit && containsUpperCase && containsLowerCase && containsSpecialChar;
	}
	
	

}
