package com.wenable.userApp.repo;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.wenable.userApp.model.User;

public interface IUserRepoInterface extends MongoRepository<User, Long> {
	
	Optional<User> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
}
