package com.booking.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String email;

}
