package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.userservice.entity.BookingManagement;
import java.util.List;


public interface BookingManagementRepository extends JpaRepository<BookingManagement,Long> {
	//find all event_id where user id is this query 
	
	@Query("SELECT e.event.id FROM BookingManagement e WHERE e.user.id = :userId AND e.cancelStatus = false")
	List<Long> getEventidByUserId (@Param("userId")Long userId);

	@Query("SELECT e FROM BookingManagement e WHERE e.user.id = :userId")
	List<BookingManagement> getAllBookingManagementDataByUserId(Long userId);

	@Query("SELECT e.bookingData.id FROM BookingManagement e WHERE e.user.id = :userId AND e.event.id = :eventId")
	Long getBookingDataIdsBuUserIdAndEventId(Long userId, Long eventId);
}
