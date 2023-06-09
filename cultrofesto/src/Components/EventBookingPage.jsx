import React, { useEffect, useState } from "react";
import { Navigate, NavLink, useNavigate } from "react-router-dom";

const event = {
  eventId: 1,
  eventName: "Dasara",
  registrationOpenDate: "2023-06-01",
  registrationCloseDate: "2023-06-10",
  eventStartTime: "10:00",
  eventCloseTime: "18:00",
  registrationFee: 500.0,
  entryCapacity: 100.0,
};

const getCurrentDate = () => {
  const today = new Date();
  const year = today.getFullYear();
  const month = String(today.getMonth() + 1).padStart(2, "0");
  const day = String(today.getDate()).padStart(2, "0");
  return `${day}-${month}-${year}`;
};

const EventBookingPage = () => {
  const [adults, setAdults] = useState(0);
  const [children, setChildren] = useState(0);
  const [foodChoices, setFoodChoices] = useState([]);

  const handleAdultChange = (event) => {
    setAdults(parseInt(event.target.value));
  };

  const handleChildChange = (event) => {
    setChildren(parseInt(event.target.value));
  };

  const handleFoodChoiceChange = (personIndex, foodIndex, isChecked) => {
    const updatedFoodChoices = [...foodChoices];
    updatedFoodChoices[personIndex][foodIndex] = isChecked;
    setFoodChoices(updatedFoodChoices);
  };

  const calculateTotalPrice = () => {
    const childPrice = 10; // Price for each child
    const adultPrice = childPrice * 1.05; // 5% higher price for adults

    let totalPrice = 0;

    for (let i = 0; i < foodChoices.length; i++) {
      const personFoodChoices = foodChoices[i];
      if (i < adults) {
        totalPrice += adultPrice * personFoodChoices.filter(Boolean).length;
      } else {
        totalPrice += childPrice * personFoodChoices.filter(Boolean).length;
      }
    }

    return totalPrice.toFixed(2);
  };

  const renderFoodChoiceInputs = () => {
    const inputs = [];

    for (let i = 0; i < adults + children; i++) {
      const personType = i < adults ? "Adult" : "Child";
      const personNumber = i < adults ? i + 1 : i - adults + 1;

      const personFoodChoices = foodChoices[i] || []; // Ensure foodChoices[i] is an array

      for (let j = 0; j < 3; j++) {
        personFoodChoices[j] = personFoodChoices[j] || false; // Ensure personFoodChoices[j] is initialized to false if undefined
      }

      inputs.push(
        <div key={i}>
          <p>
            {personType} {personNumber} Food Choices:
          </p>
          {personFoodChoices.map((isChecked, foodIndex) => (
            <div className="form-check form-check-inline" key={foodIndex}>
              <input
                className="form-check-input"
                type="checkbox"
                checked={isChecked}
                onChange={(event) =>
                  handleFoodChoiceChange(i, foodIndex, event.target.checked)
                }
              />
              <label className="form-check-label">
                {foodIndex === 0
                  ? "Breakfast"
                  : foodIndex === 1
                  ? "Lunch"
                  : "Dinner"}
              </label>
            </div>
          ))}
        </div>
      );
    }

    return inputs;
  };

  useEffect(() => {
    const newFoodChoices = [];

    for (let i = 0; i < adults + children; i++) {
      newFoodChoices.push(foodChoices[i] || []);
    }

    setFoodChoices(newFoodChoices);
  }, [adults, children]);
  const bookingDate = getCurrentDate();

  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };
  const handleBookTicket = () => {
    console.log(event.eventId);
  };

  return (
    <>
      <NavLink to="#" className="btn" onClick={handleBack}>
        🔙
      </NavLink>
      <h1 className="container_eventbooking_h1">Event Booking</h1>
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div className="card text-center">
              <div className="card-body">
                <h1 className="card-title">Booking Details</h1>
                <p>Event Name: {event.eventName}</p>
                <p>Registration Open Date: {event.registrationOpenDate}</p>
                <p>Registration Close Date: {event.registrationCloseDate}</p>
                <p>Event Start Time: {event.eventStartTime}</p>
                <p>Event Close Time: {event.eventCloseTime}</p>
                <p>Registration Fee: {event.registrationFee}</p>
                <p>Booking Date: {bookingDate}</p>
              </div>
            </div>
          </div>
          <div className="col-md-6">
            <div className="card">
              <h2 className="card-header">Choose Fooding</h2>
              <div className="card-body">
                <div className="mb-3">
                  <label className="form-label">
                    Number of Adults:
                    <input
                      className="form-control"
                      type="number"
                      value={adults}
                      onChange={handleAdultChange}
                    />
                  </label>
                </div>
                <div className="mb-3">
                  <label className="form-label">
                    Number of Children:
                    <input
                      className="form-control"
                      type="number"
                      value={children}
                      onChange={handleChildChange}
                    />
                  </label>
                </div>
                {renderFoodChoiceInputs()}
                <div>
                  <h3>Total Price</h3>
                  <p>${calculateTotalPrice()}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br />
      <div style={{ alignItems: "center", textAlign: "center" }}>
        <NavLink
          className="btn btn-primary"
          onClick={handleBookTicket}
          to="/payment-page"
        >
          Submit
        </NavLink>
      </div>
      <br />
      <br />
    </>
  );
};

export default EventBookingPage;
