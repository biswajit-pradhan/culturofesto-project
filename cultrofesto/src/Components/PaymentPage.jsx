import React, { useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";

function PaymentPage() {
  const [bookingDataId, setBookingDataId] = useState("");
  const [paymentMethod, setPaymentMethod] = useState("");
  const [cardNumber, setCardNumber] = useState("");
  const [expiryDate, setExpiryDate] = useState("");
  const [cvvNumber, setCVVNumber] = useState("");
  const [otpNumber, setOTPNumber] = useState("");
  const [totalTicketPrice, setTotalTicketPrice] = useState("");
  const [errors, setErrors] = useState({});

  const handleBookingDataIdChange = (e) => {
    setBookingDataId(e.target.value);
  };

  const handlePaymentMethodChange = (e) => {
    setPaymentMethod(e.target.value);
  };

  const handleCardNumberChange = (e) => {
    setCardNumber(e.target.value);
  };

  const handleExpiryDateChange = (e) => {
    setExpiryDate(e.target.value);
  };

  const handleCVVNumberChange = (e) => {
    setCVVNumber(e.target.value);
  };

  const handleOTPNumberChange = (e) => {
    setOTPNumber(e.target.value);
  };

  const handleTotalTicketPriceChange = (e) => {
    setTotalTicketPrice(e.target.value);
  };

  const validateForm = () => {
    const errors = {};

    if (!bookingDataId.trim()) {
      errors.bookingDataId = "Booking Data ID is required";
    }

    if (!paymentMethod) {
      errors.paymentMethod = "Payment Method is required";
    }

    if (!cardNumber.trim()) {
      errors.cardNumber = "Card Number is required";
    }

    if (!expiryDate) {
      errors.expiryDate = "Expiry Date is required";
    }

    if (!cvvNumber.trim()) {
      errors.cvvNumber = "CVV Number is required";
    }

    if (!otpNumber.trim()) {
      errors.otpNumber = "OTP Number is required";
    }

    if (!totalTicketPrice.trim()) {
      errors.totalTicketPrice = "Total Ticket Price is required";
    }

    setErrors(errors);

    return Object.keys(errors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const isValid = validateForm();

    if (isValid) {
      // Perform form submission logic here
    }
  };
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  const handlePayment = () => {
    alert("Congratulations.. you booked the ticket");
  };

  return (
    <>
      <NavLink to="#" onClick={handleBack} className="btn back-link">
        <span className="back-link-icon">🔙</span>
      </NavLink>
      <div className="page_container" style={{ paddingTop: "20px" }}>
        <div className="event-booking-container">
          <div className="container">
            <h1 className="container_h1">Payment page</h1>
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label>Booking Data ID:</label>
                <input
                  type="text"
                  className={`form-control ${
                    errors.bookingDataId && "is-invalid"
                  }`}
                  value={bookingDataId}
                  onChange={handleBookingDataIdChange}
                />
                {errors.bookingDataId && (
                  <div className="invalid-feedback">{errors.bookingDataId}</div>
                )}
              </div>
              <div className="form-group">
                <label>Payment Method:</label>
                <select
                  className={`form-control ${
                    errors.paymentMethod && "is-invalid"
                  }`}
                  value={paymentMethod}
                  onChange={handlePaymentMethodChange}
                >
                  <option value="">Select a payment method</option>
                  <option value="creditCard">Credit Card</option>
                  <option value="debitCard">Debit Card</option>
                </select>
                {errors.paymentMethod && (
                  <div className="invalid-feedback">{errors.paymentMethod}</div>
                )}
              </div>
              <div className="form-group">
                <label>Card Number:</label>
                <input
                  type="text"
                  className={`form-control ${
                    errors.cardNumber && "is-invalid"
                  }`}
                  value={cardNumber}
                  onChange={handleCardNumberChange}
                />
                {errors.cardNumber && (
                  <div className="invalid-feedback">{errors.cardNumber}</div>
                )}
              </div>
              <div className="form-group">
                <label>Expiry Date:</label>
                <input
                  type="month"
                  className={`form-control ${
                    errors.expiryDate && "is-invalid"
                  }`}
                  value={expiryDate}
                  onChange={handleExpiryDateChange}
                />
                {errors.expiryDate && (
                  <div className="invalid-feedback">{errors.expiryDate}</div>
                )}
              </div>
              <div className="form-group">
                <label>CVV Number:</label>
                <input
                  type="password"
                  className={`form-control ${errors.cvvNumber && "is-invalid"}`}
                  value={cvvNumber}
                  onChange={handleCVVNumberChange}
                />
                {errors.cvvNumber && (
                  <div className="invalid-feedback">{errors.cvvNumber}</div>
                )}
              </div>
              <div className="form-group">
                <label>OTP Number:</label>
                <input
                  type="text"
                  className={`form-control ${errors.otpNumber && "is-invalid"}`}
                  value={otpNumber}
                  onChange={handleOTPNumberChange}
                />
                {errors.otpNumber && (
                  <div className="invalid-feedback">{errors.otpNumber}</div>
                )}
              </div>
              <div className="form-group">
                <label>Total Ticket Price:</label>
                <input
                  type="number"
                  className={`form-control ${
                    errors.totalTicketPrice && "is-invalid"
                  }`}
                  value={totalTicketPrice}
                  onChange={handleTotalTicketPriceChange}
                />
                {errors.totalTicketPrice && (
                  <div className="invalid-feedback">
                    {errors.totalTicketPrice}
                  </div>
                )}
              </div>
              <div
                style={{
                  alignItems: "center",
                  textAlign: "center",
                  paddingTop: "10px",
                }}
              >
                <NavLink
                  to="/"
                  onClick={handlePayment}
                  type="submit"
                  className="btn btn-primary"
                >
                  Make Payment
                </NavLink>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}

export default PaymentPage;
