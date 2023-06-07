import React, { useState } from 'react';


const eventData = [
    {
        eventName : "Dasara",
        registrationOpenDate: "2023-06-01",
        registrationCloseDate:"2023-06-10",
        eventStartTime: "10:00",
        eventCloseTime: "18:00",
        registrationFee: 500.0,
        entryCapacity:100.0

    }
]

function EventBookingPage() {
  const [eventName, setEventName] = useState(eventData[0].eventName);
  const [registrationOpenDate, setregistrationOpenDate] = useState(eventData[0].registrationOpenDate);
  const [registrationCloseDate,setregistrationCloseDate ] = useState(eventData[0].registrationCloseDate);
  const [eventStartTime, setEventStartTime] = useState(eventData[0].eventStartTime);
  const [eventCloseTime, setEventCloseTime] = useState(eventData[0].eventCloseTime);
  const [registrationFee, setRegistrationFees] = useState(eventData[0].registrationFee);
  const [entryCapacity, setEntryCapacity] = useState(eventData[0].entryCapacity);

  const handleEventNameChange = (e) => {
    setEventName(e.target.value);
  };

  const handleRegistrationOpenChange = (e) => {
    setregistrationOpenDate(e.target.value);
  };

  const handleRegistrationCloseChange = (e) => {
    setregistrationCloseDate(e.target.value);
  };

  const handleRegistrationFeesChange = (e) => {
    setRegistrationFees(e.target.value);
  };

  const handleEventStartTimeChange = (e) => {
    setEventStartTime(e.target.value);
  };

  const handleEventCloseTimeChange = (e) => {
    setEventCloseTime(e.target.value);
  };

  const handleEntryCapacityChange = (e) => {
    setEntryCapacity(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Perform form submission logic here
  };

  return (
    <div>
      <h1>Event Booking</h1>
      <form onSubmit={handleSubmit}>
      <label style={{
          fontSize:"25px"
        }}>
          Event: {eventName}
        </label>
        <br />
        <label style={{
          fontSize:"25px"
        }}>
          Registration Start Date:{registrationOpenDate}
        </label>
        <br />
        <label style={{
          fontSize:"25px"
        }}>
          Registration Close Date:{registrationCloseDate}
        </label>
        <br />

        <label style={{
          fontSize:"25px"
        }}>
          Registration Start Time:{eventStartTime}
        </label>
        <br />
        <label style={{
          fontSize:"25px"
        }}>
          Registration Close Time:{eventCloseTime}
        </label>
        <br />

        <label style={{
          fontSize:"25px"
        }}>
          Registration Fees:{registrationFee}
        </label>
        <br />

        <label style={{
          fontSize:"25px"
        }}>
           Entry Capacity:{entryCapacity}
        </label>
        <br />
        <button type="submit">Book Event</button>
      </form>
    </div>
  );
}

export default EventBookingPage;
