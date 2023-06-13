package com.userservice.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String eventName;

    @NotNull
    @Future
    private Date registrationOpenDate;

    @NotNull
    @Future
    private Date registrationCloseDate;
    
    @NotNull
    @Future
    private Date eventDate;

    @NotNull
    private Time eventStartTime;

    @NotNull
    private Time eventCloseTime;

    @NotNull
    @PositiveOrZero
    private Double registrationFee;

    @NotNull
    @Positive
    private Long eventCapacity;

    @NotNull
    @PositiveOrZero
    private Double breakfastPrice;

    @NotNull
    @PositiveOrZero
    private Double lunchPrice;

    @NotNull
    @PositiveOrZero
    private Double dinnerPrice;

    private boolean deleteStatus;

    @Lob
    @Column(length = 1000)
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] eventImage;

	public Object setCancelStatus(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

}
