package com.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl  implements  BookingService{

    @Autowired
     private BookingRepository repository;
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
                .bookingStatus(bookingEntity.getBookingStatus())
                .build();
        return dto;
    }
}
