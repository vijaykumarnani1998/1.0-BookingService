package com.booking;

import java.util.HashMap;
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
	public  ResponseEntity<Map<String, String>> handleValidations(MethodArgumentNotValidException exception)
	{
		Map<String,String> map= new HashMap<>();
		 exception.getBindingResult().getAllErrors().forEach(error->{
			 
			 String fieldName=((FieldError)error).getField();
			 String message=error.getDefaultMessage();
			 map.put(fieldName,message);
			 
			 
		 });
         
	     return new  ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_GATEWAY);
		
	}

}
