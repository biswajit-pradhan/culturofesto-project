package com.eventservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventservice.entity.Event;

public interface EventServiceRepository extends JpaRepository<Event, Long> {

	Event findById(long id);
	 List<Event> findByRegistrationCloseDateBefore(Date currentDate);
	 List<Event> findByRegistrationCloseDateAfter(Date currentDate);
}
