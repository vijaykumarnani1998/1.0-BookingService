package com.booking.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.validation.annotation.Validated;

import com.booking.entity.BookingStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated     //optional
public class BookingDto {

    private UUID bookingId;
    @NotBlank(message="User Id should not be Empty and atleast contain one non-whitespace character")
    private String userId;
    @NotNull(message="Movie Id should be not be empty ")		  
    private  Integer movieId;
    @NotNull(message="ShowDate is Mandatory")
    private LocalDate showDate;
    @NotNull(message="ShowTime is Mandatory")
    private LocalTime showTime;
    @NotNull(message="bookingAmount Id is Mandatory")		  
    @Positive(message="Amount should be positive ")
    private  Double bookingAmount;
    @NotNull(message="You have to select atleast one seat")
    private List<String> seatsBooked;
    private BookingStatus bookingStatus;
    @NotNull(message="Email Should not be EMpty")
    @Email(message="Email Format is Invalid")
    private String email;
}
