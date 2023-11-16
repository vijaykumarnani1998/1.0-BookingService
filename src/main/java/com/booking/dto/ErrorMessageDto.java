package com.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDto {
	
	private String message;
	//Like 500/501/404
	private String statusValue;
	//Like BAadrequest,internal server error
	private String statusCode;
	//private LocalDateTime timeStamp;
	private String timeStamp;

}
