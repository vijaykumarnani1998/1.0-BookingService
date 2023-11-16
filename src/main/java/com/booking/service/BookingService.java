package com.booking.service;

import com.booking.dto.BookingDto;

import jakarta.mail.MessagingException;

public interface BookingService {

    public BookingDto saveBooking(BookingDto bookingDto);

	 public void sendEmail(String to, String subject, String body) throws MessagingException;
}
