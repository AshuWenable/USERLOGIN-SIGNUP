package com.wenable.userApp.globalExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.wenable.userApp.userException.UserException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserException ex,WebRequest req) {
        
    	ErrorResponse er=new ErrorResponse(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));
    	return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
    		
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex,WebRequest req)
    {
    	ErrorResponse er=new ErrorResponse(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));
    	return new ResponseEntity<ErrorResponse>(er,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
