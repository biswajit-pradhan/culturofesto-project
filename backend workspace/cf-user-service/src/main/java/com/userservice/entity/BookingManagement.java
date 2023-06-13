package com.userservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingManagement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NotNull
	private boolean cancelStatus = false;
	
	@NotNull
	private String ticketNo;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Event event;
	
	@OneToOne
	private BookingData bookingData;
	
	@OneToOne
	private PaymentData paymentData;
}
