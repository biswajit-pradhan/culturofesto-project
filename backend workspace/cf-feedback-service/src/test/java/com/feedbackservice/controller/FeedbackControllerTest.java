package com.feedbackservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedbackservice.service.FeedbackService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
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

    /**
     * Method under test: {@link FeedbackController#getFeedbackByUserIdAndEventId(Long, Long)}
     */
    @Test
    void testGetFeedbackByUserIdAndEventId() throws Exception {
        when(feedbackService.getFeedbackByUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/feedback/get-feedback/{userId}/{eventId}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link FeedbackController#getFeedbackByUserIdAndEventId(Long, Long)}
     */
    @Test
    void testGetFeedbackByUserIdAndEventId2() throws Exception {
        when(feedbackService.getFeedbackByUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn("");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/feedback/get-feedback/{userId}/{eventId}", 1L, 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Feedback not found"));
    }

    /**
     * Method under test: {@link FeedbackController#getFeedbackByUserIdAndEventId(Long, Long)}
     */
    @Test
    void testGetFeedbackByUserIdAndEventId3() throws Exception {
        when(feedbackService.getFeedbackByUserIdAndEventId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/feedback/get-feedback/{userId}/{eventId}", 1L, 1L);
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(feedbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link FeedbackController#postFeedback(Long, Long, String)}
     */
    @Test
    void testPostFeedback() throws Exception {
        doNothing().when(feedbackService).saveFeedback(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any());
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/api/user/feedback/post-feedback/{userId}/{eventId}", 1L, 1L)
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

