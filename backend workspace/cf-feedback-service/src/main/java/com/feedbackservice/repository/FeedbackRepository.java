package com.feedbackservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feedbackservice.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	
	@Query("select f.feedbackText from Feedback f where f.user.id = :userId AND f.event.id = :eventId")
	String findByUser_IdAndEvent_Id(Long userId, Long eventId);
	
}
