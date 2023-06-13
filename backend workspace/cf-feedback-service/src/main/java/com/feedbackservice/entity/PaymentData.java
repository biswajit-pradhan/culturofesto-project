package com.feedbackservice.entity;

import java.sql.Date;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private int ticketPrice;

    @NotNull
    private String paymentMethod;

    @NotNull
    private Long cardNumber;

    @NotNull
    @Future
    private Date expDate;

    @NotNull
    private int cvvNumber;

    @NotNull
    private int OTP;

    @OneToOne
    private BookingData bookingData;



}