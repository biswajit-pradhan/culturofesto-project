package com.bookingservice.Controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.bookingservice.Model.Booking;
import com.bookingservice.Service.BookingService;
import com.bookingservice.enums.CustomerType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {BookingController.class})
@ExtendWith(SpringExtension.class)
class BookingControllerTest {
    @Autowired
    private BookingController bookingController;

    @MockBean
    private BookingService bookingService;

    /**
     * Method under test: {@link BookingController#getAllBookingData()}
     */
    @Test
    void testGetAllBookingData() throws Exception {
        when(bookingService.getAllBookings()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/event/booking/allBookingdata");
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookingController#getBookingById(long)}
     */
    @Test
    void testGetBookingById() throws Exception {
        Booking booking = new Booking();
        booking.setBookingId(1L);
        booking.setBreakFastOpted(true);
        booking.setCustomerType(CustomerType.ADULT);
        booking.setDinnerOpted(true);
        booking.setEventId(1L);
        booking.setFoodOpted(true);
        booking.setLunchOpted(true);
        booking.setNumberOfBooking(1L);
        when(bookingService.getBookingById(anyLong())).thenReturn(booking);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/event/booking/bookingdata/{bookingId}", 1L);
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"bookingId\":1,\"eventId\":1,\"customerType\":\"ADULT\",\"numberOfBooking\":1,\"foodOpted\":true,\"breakFastOpted"
                                        + "\":true,\"dinnerOpted\":true,\"lunchOpted\":true}"));
    }

    /**
     * Method under test: {@link BookingController#getAllBookingData()}
     */
    @Test
    void testGetAllBookingData2() throws Exception {
        when(bookingService.getAllBookings()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/user/event/booking/allBookingdata");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookingController#saveBooking(Booking)}
     */
    @Test
    void testSaveBooking() throws Exception {
        Booking booking = new Booking();
        booking.setBookingId(1L);
        booking.setBreakFastOpted(true);
        booking.setCustomerType(CustomerType.ADULT);
        booking.setDinnerOpted(true);
        booking.setEventId(1L);
        booking.setFoodOpted(true);
        booking.setLunchOpted(true);
        booking.setNumberOfBooking(1L);
        when(bookingService.createBooking(Mockito.<Booking>any())).thenReturn(booking);

        Booking booking2 = new Booking();
        booking2.setBookingId(1L);
        booking2.setBreakFastOpted(true);
        booking2.setCustomerType(CustomerType.ADULT);
        booking2.setDinnerOpted(true);
        booking2.setEventId(1L);
        booking2.setFoodOpted(true);
        booking2.setLunchOpted(true);
        booking2.setNumberOfBooking(1L);
        String content = (new ObjectMapper()).writeValueAsString(booking2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/event/booking/bookingdata")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"bookingId\":1,\"eventId\":1,\"customerType\":\"ADULT\",\"numberOfBooking\":1,\"foodOpted\":true,\"breakFastOpted"
                                        + "\":true,\"dinnerOpted\":true,\"lunchOpted\":true}"));
    }
}

