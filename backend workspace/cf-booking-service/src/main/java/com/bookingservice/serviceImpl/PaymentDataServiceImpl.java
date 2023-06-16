package com.bookingservice.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.PaymentData;
import com.bookingservice.repository.BookingDataRepository;
import com.bookingservice.repository.PaymentDataRepository;
import com.bookingservice.service.PaymentDataService;

@Service
public class PaymentDataServiceImpl implements PaymentDataService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDataServiceImpl.class);

    @Autowired
    private PaymentDataRepository paymentDataRepository;

    @Autowired
    private BookingDataRepository bookingDataRepository;

    public Object getPaymentDataByBookingId(Long bookingId) {
        logger.info("Fetching payment data for bookingId: {}", bookingId);
        return paymentDataRepository.findAll().stream()
                .filter(p -> p.getBookingId().equals(bookingId))
                .findAny()
                .orElse(null);
    }

    public String addPaymentDataByBookingId(PaymentData paymentData, Long bookingId) {
        Object status = getPaymentDataByBookingId(bookingId);

        Double totalPrice = bookingDataRepository.findById(bookingId).get().getTotalPrice();
        paymentData.setTotalPrice(totalPrice);

        if (!(status instanceof PaymentData)) {
            try {
                paymentData.setBookingId(bookingId);
                paymentDataRepository.save(paymentData);
                logger.info("Payment data added successfully for bookingId: {}", bookingId);
                return "Payment data added successfully";
            } catch (Exception e) {
                logger.error("Failed to add payment data for bookingId: {}", bookingId, e);
                return e.getMessage();
            }
        } else {
            logger.warn("Booking amount is already paid for bookingId: {}", bookingId);
            return "Booking amount is already paid";
        }
    }
}
