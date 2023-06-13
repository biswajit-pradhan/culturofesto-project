package com.bookingservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookingservice.Model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
