package com.booking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="Bookings")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookingId;
    private String userId;
    private  Integer movieId;
    private LocalDate showDate;
    private LocalTime showTime;
    private  Double bookingAmount;
    @ElementCollection
    private List<String> seatsBooked;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;



}
