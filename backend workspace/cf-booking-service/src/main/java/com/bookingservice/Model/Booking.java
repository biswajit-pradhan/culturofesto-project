package com.bookingservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="BOOKING")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOOKING_ID")
	private long bookingId;
	
	@Column(name="EVENT_ID")
	private long eventId;
	
	@Enumerated(EnumType.STRING)
	private CustomerType customerType;
	
	@Column(name = "NUMBER_OF_BOOKING")
	private long numberOfBooking;
	
	@Column(name = "FOOD_OPTED")
	private boolean isFoodOpted;
	
	@Column(name = "BREAKFAST_OPTED")
	private boolean isBreakFastOpted;
	
	@Column(name = "LUNCH_OPTED")
	private boolean isLunchOpted;
	
	@Column(name = "DINNER_OPTED")
	private boolean isDinnerOpted;
}
