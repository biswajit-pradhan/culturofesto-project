package com.feedbackservice.service;

import com.feedbackservice.entity.Feedback;

public interface FeedbackService {
	public void saveFeedback(Long userId, Long eventId, String feedbackText);

	public String getFeedbackByUserIdAndEventId(Long userId, Long eventId);
}
