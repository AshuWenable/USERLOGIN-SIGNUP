package com.wenable.userApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wenable.userApp.model.User;
import com.wenable.userApp.repo.IUserRepoInterface;
import com.wenable.userApp.userException.UserException;

@Component
public class UserDaoImpl implements IUserDao  {
	@Autowired
	private IUserRepoInterface userRepo;
	
	public User saveUser(User user)
	{
		return userRepo.save(user);
	}
	public Optional<User> findByUserName(String username)
	{
		return userRepo.findByUserName(username);
		
	}
    public Boolean existsByUserName(String username)
    {
    	return userRepo.existsByUserName(username);
    }
	@Override
	public Boolean existsbyEmail(String email) {
		
		if(userRepo.existsByEmail(email))
		{
			throw new UserException("Try another email id");
		}
		return userRepo.existsByEmail(email);
	}
	
    
}



