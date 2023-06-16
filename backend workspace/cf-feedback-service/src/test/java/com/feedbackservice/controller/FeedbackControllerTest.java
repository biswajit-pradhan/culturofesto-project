package com.feedbackservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedbackservice.entity.Event;
import com.feedbackservice.entity.Feedback;
import com.feedbackservice.entity.User;
import com.feedbackservice.role.Role;
import com.feedbackservice.service.FeedbackService;

import java.sql.Date;
import java.sql.Time;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FeedbackController.class})
@ExtendWith(SpringExtension.class)
class FeedbackControllerTest {
    @Autowired
    private FeedbackController feedbackController;

    @MockBean
    private FeedbackService feedbackService;

    
    @Test
    void testGetFeedbackByUserIdAndEventId() throws Exception {
        Time eventCloseTime = mock(Time.class);
        when(eventCloseTime.getTime()).thenReturn(10L);
        Date eventDate = mock(Date.class);
        when(eventDate.getTime()).thenReturn(10L);
        Time eventStartTime = mock(Time.class);
        when(eventStartTime.getTime()).thenReturn(10L);
        Date registrationCloseDate = mock(Date.class);
        when(registrationCloseDate.getTime()).thenReturn(10L);
        Date registrationOpenDate = mock(Date.class);
        when(registrationOpenDate.getTime()).thenReturn(10L);

        Event event = new Event();
        event.setBreakfastPrice(10.0d);
        event.setDeleteStatus(true);
        event.setDinnerPrice(10.0d);
        event.setEventCapacity(1L);
        event.setEventCloseTime(eventCloseTime);
        event.setEventDate(eventDate);
        event.setEventImage("AXAXAXAX".getBytes("UTF-8"));
        event.setEventName("Event Name");
        event.setEventStartTime(eventStartTime);
        event.setId(1L);
        event.setLunchPrice(10.0d);
        event.setRegistrationCloseDate(registrationCloseDate);
        event.setRegistrationFee(10.0d);
        event.setRegistrationOpenDate(registrationOpenDate);

        User user = new User();
        user.setId(1L);
        user.setRole(Role.USER);
        user.setUserEmail("jane.doe@example.org");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Feedback feedback = new Feedback();
        feedback.setEvent(event);
        feedback.setFeedbackText("Feedback Text");
        feedback.setId(1L);
        feedback.setUser(user);
        when(feedbackService.getFeedbackByUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(feedback);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/feedback/get-feedback/{userId}/{eventId}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"user\":{\"id\":1,\"userName\":\"janedoe\",\"userPassword\":\"iloveyou\",\"userEmail\":\"jane.doe@example"
                                        + ".org\",\"role\":\"USER\"},\"event\":{\"id\":1,\"eventName\":\"Event Name\",\"registrationOpenDate\":10,\"registratio"
                                        + "nCloseDate\":10,\"eventDate\":10,\"eventStartTime\":10,\"eventCloseTime\":10,\"registrationFee\":10.0,\"eventCapacity"
                                        + "\":1,\"breakfastPrice\":10.0,\"lunchPrice\":10.0,\"dinnerPrice\":10.0,\"deleteStatus\":true,\"eventImage\":"
                                        + "\"QVhBWEFYQVg=\"},\"feedbackText\":\"Feedback Text\"}"));
    }

    
    @Test
    void testPostFeedback() throws Exception {
        doNothing().when(feedbackService).saveFeedback(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any());
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/api/feedback/post-feedback/{userId}/{eventId}", 1L, 1L)
                .contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString("foo"));
        MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Feedback posted successfully"));
    }
}

