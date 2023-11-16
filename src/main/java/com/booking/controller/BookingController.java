package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.BookingDto;
import com.booking.service.BookingService;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {

		@Autowired
		private BookingService bookingService;

		//@Autowired
		//private PaymentBroker payment;

		@PostMapping("/create")
		public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingDto bookingDto) throws MessagingException
		{
			BookingDto bookingDto1 = bookingService.saveBooking(bookingDto);
			
		

		bookingService.sendEmail(bookingDto.getEmail(), "BookingDetails", "Hi" + bookingDto1.getUserId() +
						 "Your ticket is booked with ID" + bookingDto1.getBookingId());
				
			
			
			  return new ResponseEntity<BookingDto>(bookingDto1,HttpStatus.OK);
		}

		

		/*@GetMapping("/test")
		public ResponseEntity<String> testFeign(){
			String test = payment.test();

			  return new ResponseEntity<>(test,HttpStatus.OK);
		}*/


	}

