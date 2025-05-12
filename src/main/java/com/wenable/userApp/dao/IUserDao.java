package com.wenable.userApp.dao;
import java.util.Optional;

import com.wenable.userApp.model.User;

public interface IUserDao {
	public User saveUser(User user);
	Optional<User> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsbyEmail(String email);
    // i am at my working branch
}
