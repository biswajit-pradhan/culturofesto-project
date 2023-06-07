import React, { useState, useEffect } from "react";

const event = [
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

const EventDetailsPage = ({ eventId, isLoggedIn }) => {
  // const [event, setEvent] = useState(eventData);
  // useEffect(() => {
  //   // Fetch event details from the backend API
  //   const fetchEventDetails = async () => {
  //     try {
  //       // const response = await fetch(`/api/events/${eventId}`);
  //       // const data = await response.json();
  //     } catch (error) {
  //       console.error("Error fetching event details:", error);
  //     }
  //   };

  //   fetchEventDetails();
  // }, [eventId]);

  const handleBookTicket = () => {
    // Handle book ticket action
    // You can implement the logic for booking a ticket here
    console.log("Book ticket clicked!");
  };

  if (!event) {
    return <div>Loading event details...</div>;
  }

  return (
    <div>
      <div className="card mb-3">
        <img
          src={`data:image/png;base64,${event[0].eventImage}`}
          alt="Event"
          className="card-img-top"
        />
        <div className="card-body">
          <h2 className="card-title">{event[0].eventName}</h2>
          <p className="card-text">
            Registration Open Date: {event[0].registrationOpenDate}
          </p>
          <p className="card-text">
            Registration Close Date: {event[0].registrationCloseDate}
          </p>
          <p className="card-text">
            Event Start Time: {event[0].eventStartTime}
          </p>
          <p className="card-text">
            Event Close Time: {event[0].eventCloseTime}
          </p>
          <p className="card-text">
            Registration Fee: {event[0].registrationFee}
          </p>
          <p className="card-text">Event Capacity: {event[0].eventCapacity}</p>
          <p className="card-text">
            Breakfast Price: {event[0].breakfastPrice}
          </p>
          <p className="card-text">Lunch Price: {event[0].lunchPrice}</p>
          <p className="card-text">Dinner Price: {event[0].dinnerPrice}</p>
        </div>
      </div>

      {isLoggedIn && (
        <button className="btn btn-primary" onClick={handleBookTicket}>
          Book Ticket
        </button>
      )}
    </div>
  );
};

export default EventDetailsPage;
