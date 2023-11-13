package com.booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	
	public ResponseEntity<ErrorMessageDto> handleValidations(MethodArgumentNotValidException exception) {
		
		
		  List<String> list = new ArrayList<>();
		  exception.getBindingResult().getAllErrors() 
		  .forEach(error -> { 
		                     String message = error.getDefaultMessage(); 
		                     list.add(message);
		                    });
		 
/*   Alternative for above List ie line no 21 to 27
		
		Map<String,String> map=new HashMap<>();
		exception.getBindingResult().getAllErrors() 
		                            .forEach(error->{
	                                                  String fieldName=((FieldError)error).getField();
		                                              String message=error.getDefaultMessage();
		                                              map.put(fieldName, message);
	                                                 });
*/
		
		
		ErrorMessageDto errorMessage=new ErrorMessageDto();
		errorMessage.setMessage(list.toString());
		errorMessage.setTimeStamp(LocalDateTime.now().toString());
		errorMessage.setStatusCode(Integer.toString(HttpStatus.BAD_GATEWAY.value()));
		errorMessage.setStatusValue(HttpStatus.BAD_GATEWAY.name());
		return new ResponseEntity<ErrorMessageDto>(errorMessage,HttpStatus.BAD_GATEWAY);
	}
}	
		
// MAP FORMAT OUTPUT

//    { 
//     "message": "{movieId=Movie Id should be not be empty , userId=User Id should not be Empty and atleast contain one non-whitespace character, bookingAmount=bookingAmount Id is Mandatory}",
//     "statusValue": "BAD_GATEWAY",
//     "statusCode": "502",
//     "timeStamp": "2023-11-13T21:22:02.969144800"
	
		
//LIST FORMAT OUTPUT

//{ 
//"message": "[Movie Id should be not be empty , User Id should not be Empty and atleast contain one non-whitespace character, bookingAmount Id is Mandatory]",
//"statusValue": "BAD_GATEWAY",
//"statusCode": "502",
//"timeStamp": "2023-11-13T21:22:02.969144800"	
		
		
		
		
		
	/*
	 public ResponseEntity<List<String>> handleValidations(MethodArgumentNotValidException exception) {
		List<String> errorList = new ArrayList<>();
		exception.getBindingResult().getAllErrors()
		                            .forEach(error -> {
                                                    String message = error.getDefaultMessage();
			                                        errorList.add(message);
		                                              });

		return new ResponseEntity<List<String>>(errorList, HttpStatus.BAD_GATEWAY);

	}*/
	
	


