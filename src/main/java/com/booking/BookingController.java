package com.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/create")
    public ResponseEntity<BookingDto>  createBooking(@Valid @RequestBody BookingDto bookingDto)
    {
    	BookingDto bookingDto1 = service.saveBooking(bookingDto);
        return  new ResponseEntity<BookingDto>(bookingDto1, HttpStatus.CREATED);
    }

}
