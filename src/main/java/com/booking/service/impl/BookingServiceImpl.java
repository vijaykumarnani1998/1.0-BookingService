package com.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.booking.dto.BookingDto;
import com.booking.entity.BookingEntity;
import com.booking.entity.BookingStatus;
import com.booking.repository.BookingRepository;
import com.booking.service.BookingService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class BookingServiceImpl  implements  BookingService{

    @Autowired
     private BookingRepository repository;
    
    @Autowired
    private JavaMailSender mailSender;
     
    
    
    @Override
    public void sendEmail(String to, String subject, String body) throws MessagingException
    {
    	MimeMessage message= mailSender.createMimeMessage();
    	MimeMessageHelper helper=new MimeMessageHelper(message);
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(body);
    mailSender.send(message);
    
    }
    
    
    
    
    @Override
    public BookingDto saveBooking(BookingDto bookingDto) {
        BookingEntity bookingEntity=BookingEntity.builder()
                .bookingAmount(bookingDto.getBookingAmount())
                .seatsBooked(bookingDto.getSeatsBooked())
                .movieId(bookingDto.getMovieId())
                .userId(bookingDto.getUserId())
                .showDate(bookingDto.getShowDate())
                .showTime(bookingDto.getShowTime())
                .bookingStatus(BookingStatus.PENDING)
                .email(bookingDto.getEmail())
                .build();
        repository.save(bookingEntity);
        BookingDto dto = BookingDto.builder()
                .bookingAmount(bookingEntity.getBookingAmount())
                .bookingId(bookingEntity.getBookingId())
                .seatsBooked(bookingEntity.getSeatsBooked())
                .movieId(bookingEntity.getMovieId())
                .userId(bookingEntity.getUserId())
                .showDate(bookingEntity.getShowDate())
                .showTime(bookingEntity.getShowTime())
               //.bookingStatus(bookingEntity.getBookingStatus)
                .bookingStatus(BookingStatus.APPROVED)
                .email(bookingEntity.getEmail())
                .build();
        return dto;
    }
}
