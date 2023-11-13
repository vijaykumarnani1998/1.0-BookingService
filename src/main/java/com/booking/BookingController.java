package com.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/create")
    public ResponseEntity<BookingDto>  createBooking(@RequestBody BookingDto bookingDto)
    {

        return  new ResponseEntity<BookingDto>(service.saveBooking(bookingDto), HttpStatus.CREATED);
    }

}
