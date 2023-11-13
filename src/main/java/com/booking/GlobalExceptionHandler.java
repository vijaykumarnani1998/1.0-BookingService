package com.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<List<String>> handleValidations(MethodArgumentNotValidException exception)
	{
		List<String> errorList= new ArrayList<>();
		 exception.getBindingResult().getAllErrors().forEach(error->{
			 
			 
			 String message=error.getDefaultMessage();
			errorList.add(message);
			 
			 
		 });
         
	     return new  ResponseEntity<List<String>>(errorList,HttpStatus.BAD_GATEWAY);
		
	}

}
