package com.wenable.userApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wenable.userApp.dao.UserDaoImpl;
import com.wenable.userApp.dto.LoginResponseDto;
import com.wenable.userApp.dto.UserResponseDto;
import com.wenable.userApp.genericResponse.GenericResponse;
import com.wenable.userApp.model.User;
import com.wenable.userApp.repo.IUserRepoInterface;
import com.wenable.userApp.service.validation.EmailValidator;
import com.wenable.userApp.service.validation.PasswordValidator;
import com.wenable.userApp.service.validation.UsernameValidator;
import com.wenable.userApp.userException.UserException;

@Component
public class UserService {
	
	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private UsernameValidator userNameValidator;
	@Autowired
	private EmailValidator emailValidator;
	@Autowired
	private PasswordValidator pwdValidator;
	
	public GenericResponse registerUser(UserResponseDto userDTO) throws UserException {
		
		
		 User user = new User();
    	
	   	    userNameValidator.isValidUserName(userDTO.getUserName()); 
	        emailValidator.validateEmail(userDTO.getEmail());
	        userDao.existsbyEmail(userDTO.getEmail());
	        pwdValidator.isValidPwd(userDTO.getPwd()); 
	       
	   	   
	        user.setUserName(userDTO.getUserName());
	        user.setEmail(userDTO.getEmail());
	        user.setPsw(userDTO.getPwd());
	        user.setFirstName(userDTO.getFirstName());
	        user.setLastName(userDTO.getLastName());
	        user.setPhoneNumber(userDTO.getPhoneNumber());
	        userDao.saveUser(user);
	      
	        return new GenericResponse(true, "User registered successfully", userDTO); 

	   }
		
	 public GenericResponse authenticateUser(String userName, String pwd) throws UserException {
	        Optional<User> userFound = userDao.findByUserName(userName);

	        if(userFound.isEmpty() || !userFound.get().getPsw().equals(pwd) )
	        {
	        	throw new UserException("Invalid username or password");
	        }

	        User user = userFound.get();
	        LoginResponseDto loginDto = new LoginResponseDto();
	        loginDto.setUserId(user.getuId());
	        loginDto.setUserName(user.getUserName());
	        loginDto.setEmail(user.getEmail());

	        return new GenericResponse(true, "Successfully logged in", loginDto);
	    }
	
	 
	  
}
