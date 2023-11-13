package com.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private UUID bookingId;
    private String userId;
    private  Integer movieId;
    private LocalDate showDate;
    private LocalTime showTime;
    private  Double bookingAmount;
    private List<String> seatsBooked;
    private BookingStatus bookingStatus;
}
