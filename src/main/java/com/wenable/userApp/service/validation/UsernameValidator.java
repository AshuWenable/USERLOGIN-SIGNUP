package com.wenable.userApp.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wenable.userApp.repo.IUserRepoInterface;
import com.wenable.userApp.userException.UserException;

@Component
public class UsernameValidator {
	@Autowired
	private IUserRepoInterface userRepo;

    public boolean isValidUserName(String uName) throws UserException {
        if (uName == null || uName.isBlank()) {
            throw new UserException("Username cannot be blank");
        }

        boolean validFormat = uName.matches("^[a-zA-Z0-9._-]{4,}$");
        if (!validFormat) {
            throw new UserException("Invalid username format");
        }

        if (userRepo.existsByUserName(uName)) {
            throw new UserException("Username already exists");
        }

        return true;

}
}
