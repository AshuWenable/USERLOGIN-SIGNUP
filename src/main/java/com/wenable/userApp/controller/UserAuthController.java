package com.wenable.userApp.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wenable.userApp.dto.UserResponseDto;
import com.wenable.userApp.genericResponse.GenericResponse;
import com.wenable.userApp.service.UserService;
import com.wenable.userApp.userException.UserException;

@RestController
@RequestMapping("/user")
public class UserAuthController {
	
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<GenericResponse>  registerUser(@RequestBody UserResponseDto dto) {
        return new ResponseEntity<GenericResponse>(userService.registerUser(dto),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<GenericResponse> login(@RequestParam String userName, @RequestParam String pwd){
        return  new ResponseEntity<GenericResponse>(userService.authenticateUser(userName, pwd),HttpStatus.OK);
    }
	
	

}
