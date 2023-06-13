package com.feedbackservice.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackservice.entity.Event;
import com.feedbackservice.entity.Feedback;
import com.feedbackservice.entity.User;
import com.feedbackservice.repository.FeedbackRepository;
import com.feedbackservice.service.EventService;
import com.feedbackservice.service.FeedbackService;
import com.feedbackservice.service.UserService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public void saveFeedback(Long userId, Long eventId, String feedbackText) {
        User user = userService.getUserById(userId);
        Event event = eventService.getEventById(eventId);

        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setEvent(event);
        feedback.setFeedbackText(feedbackText);

        feedbackRepository.save(feedback);
        logger.info("Feedback saved. UserId: {}, EventId: {}", userId, eventId);
    }

    public String getFeedbackByUserIdAndEventId(Long userId, Long eventId) {
        logger.info("Fetching feedback. UserId: {}, EventId: {}", userId, eventId);
        return feedbackRepository.findByUser_IdAndEvent_Id(userId, eventId);
    }
}
