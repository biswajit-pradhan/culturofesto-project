import React, { useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";

const eventData = [
  {
    eventName: "Event 1",
    registrationOpenDate: "2023-06-01",
    registrationCloseDate: "2023-06-10",
    eventStartTime: "10:00",
    eventCloseTime: "18:00",
    registrationFee: 50.0,
    eventCapacity: 100,
    breakfastPrice: 10.0,
    lunchPrice: 15.0,
    dinnerPrice: 20.0,
    eventImage: null,
  },
];

const AdminEventEditPage = () => {
  const [eventName, setEventName] = useState(eventData[0].eventName);
  const [registrationOpenDate, setRegistrationOpenDate] = useState(
    eventData[0].registrationOpenDate
  );
  const [registrationCloseDate, setRegistrationCloseDate] = useState(
    eventData[0].registrationCloseDate
  );
  const [eventStartTime, setEventStartTime] = useState(
    eventData[0].eventStartTime
  );
  const [eventCloseTime, setEventCloseTime] = useState(
    eventData[0].eventCloseTime
  );
  const [registrationFee, setRegistrationFee] = useState(
    eventData[0].registrationFee
  );
  const [eventCapacity, setEventCapacity] = useState(
    eventData[0].eventCapacity
  );
  const [breakfastPrice, setBreakfastPrice] = useState(
    eventData[0].breakfastPrice
  );
  const [lunchPrice, setLunchPrice] = useState(eventData[0].lunchPrice);
  const [dinnerPrice, setDinnerPrice] = useState(eventData[0].dinnerPrice);
  const [eventImage, setEventImage] = useState(eventData[0].eventImage);

  const handleEventNameChange = (e) => {
    setEventName(e.target.value);
  };

  const handleRegistrationOpenDateChange = (e) => {
    setRegistrationOpenDate(e.target.value);
  };

  const handleRegistrationCloseDateChange = (e) => {
    setRegistrationCloseDate(e.target.value);
  };

  const handleEventStartTimeChange = (e) => {
    setEventStartTime(e.target.value);
  };

  const handleEventCloseTimeChange = (e) => {
    setEventCloseTime(e.target.value);
  };

  const handleRegistrationFeeChange = (e) => {
    setRegistrationFee(parseFloat(e.target.value));
  };

  const handleEventCapacityChange = (e) => {
    setEventCapacity(parseInt(e.target.value));
  };

  const handleBreakfastPriceChange = (e) => {
    setBreakfastPrice(parseFloat(e.target.value));
  };

  const handleLunchPriceChange = (e) => {
    setLunchPrice(parseFloat(e.target.value));
  };

  const handleDinnerPriceChange = (e) => {
    setDinnerPrice(parseFloat(e.target.value));
  };

  const handleEventImageChange = (e) => {
    const file = e.target.files[0];
    const reader = new FileReader();
    reader.onload = () => {
      setEventImage(reader.result);
    };
    reader.readAsDataURL(file);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // TODO: Implement your form submission logic
  };
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };
  return (
    <>
      <NavLink to="#" onClick={handleBack} className="btn">
        🔙
      </NavLink>
      <div className="container admin_event_edit">
        <h1 className="mt-4 event_edit_title">Edit Event</h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Event Name:</label>
            <input
              type="text"
              className="form-control"
              value={eventName}
              onChange={handleEventNameChange}
            />
          </div>

          <div className="row">
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Registration Open Date:</label>
                <input
                  type="date"
                  className="form-control"
                  value={registrationOpenDate}
                  onChange={handleRegistrationOpenDateChange}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Registration Close Date:</label>
                <input
                  type="date"
                  className="form-control"
                  value={registrationCloseDate}
                  onChange={handleRegistrationCloseDateChange}
                />
              </div>
            </div>
          </div>

          <div className="row">
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Event Start Time:</label>
                <input
                  type="time"
                  className="form-control"
                  value={eventStartTime}
                  onChange={handleEventStartTimeChange}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Event Close Time:</label>
                <input
                  type="time"
                  className="form-control"
                  value={eventCloseTime}
                  onChange={handleEventCloseTimeChange}
                />
              </div>
            </div>
          </div>

          <div className="row">
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Registration Fee:</label>
                <input
                  type="number"
                  className="form-control"
                  value={registrationFee}
                  onChange={handleRegistrationFeeChange}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Event Capacity:</label>
                <input
                  type="number"
                  className="form-control"
                  value={eventCapacity}
                  onChange={handleEventCapacityChange}
                />
              </div>
            </div>
          </div>

          <div className="row">
            <div className="col-md-4">
              <div className="mb-3">
                <label className="form-label">Breakfast Price:</label>
                <input
                  type="number"
                  className="form-control"
                  value={breakfastPrice}
                  onChange={handleBreakfastPriceChange}
                />
              </div>
            </div>
            <div className="col-md-4">
              <div className="mb-3">
                <label className="form-label">Lunch Price:</label>
                <input
                  type="number"
                  className="form-control"
                  value={lunchPrice}
                  onChange={handleLunchPriceChange}
                />
              </div>
            </div>
            <div className="col-md-4">
              <div className="mb-3">
                <label className="form-label">Dinner Price:</label>
                <input
                  type="number"
                  className="form-control"
                  value={dinnerPrice}
                  onChange={handleDinnerPriceChange}
                />
              </div>
            </div>
          </div>

          <div className="mb-3">
            <label className="form-label">Event Image:</label>
            <input
              type="file"
              accept="image/*"
              className="form-control"
              onChange={handleEventImageChange}
            />
          </div>

          <button type="submit" className="btn btn-primary">
            Save
          </button>
        </form>
      </div>
    </>
  );
};

export default AdminEventEditPage;
