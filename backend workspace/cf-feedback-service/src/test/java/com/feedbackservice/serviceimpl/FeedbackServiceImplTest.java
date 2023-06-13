package com.feedbackservice.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.feedbackservice.entity.Event;
import com.feedbackservice.entity.Feedback;
import com.feedbackservice.entity.User;
import com.feedbackservice.repository.FeedbackRepository;
import com.feedbackservice.role.Role;
import com.feedbackservice.service.EventService;
import com.feedbackservice.service.UserService;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FeedbackServiceImpl.class})
@ExtendWith(SpringExtension.class)
class FeedbackServiceImplTest {
    @MockBean
    private EventService eventService;

    @MockBean
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackServiceImpl feedbackServiceImpl;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link FeedbackServiceImpl#saveFeedback(Long, Long, String)}
     */
    @Test
    void testSaveFeedback() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(mock(Time.class));
        event.setEventDate(mock(Date.class));
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(mock(Time.class));
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(mock(Date.class));
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(mock(Date.class));
        when(eventService.getEventById(Mockito.<Long>any())).thenReturn(event);

        Event event2 = new Event();
        event2.setBreakfastPrice(10.0d);
        event2.setDeleteStatus(true);
        event2.setDinnerPrice(10.0d);
        event2.setEventCapacity(1L);
        event2.setEventCloseTime(mock(Time.class));
        event2.setEventDate(mock(Date.class));
        event2.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event2.setEventName("Event Name");
        event2.setEventStartTime(mock(Time.class));
        event2.setId(1L);
        event2.setLunchPrice(10.0d);
        event2.setRegistrationCloseDate(mock(Date.class));
        event2.setRegistrationFee(10.0d);
        event2.setRegistrationOpenDate(mock(Date.class));

        User user = new User();
        user.setId(1L);
        user.setRole(Role.User);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event2);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUser(user);
        when(feedbackRepository.save(Mockito.<Feedback>any())).thenReturn(feedback);

        User user2 = new User();
        user2.setId(1L);
        user2.setRole(Role.User);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        when(userService.getUserById(Mockito.<Long>any())).thenReturn(user2);
        feedbackServiceImpl.saveFeedback(1L, 1L, "Feedback Text");
        verify(eventService).getEventById(Mockito.<Long>any());
        verify(feedbackRepository).save(Mockito.<Feedback>any());
        verify(userService).getUserById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#getFeedbackByUserIdAndEventId(Long, Long)}
     */
    @Test
    void testGetFeedbackByUserIdAndEventId() {
        when(feedbackRepository.findByUser_IdAndEvent_Id(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn("42");
        assertEquals("42", feedbackServiceImpl.getFeedbackByUserIdAndEventId(1L, 1L));
        verify(feedbackRepository).findByUser_IdAndEvent_Id(Mockito.<Long>any(), Mockito.<Long>any());
    }
}

