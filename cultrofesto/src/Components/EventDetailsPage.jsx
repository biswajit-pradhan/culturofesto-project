import React, { useState, useEffect } from "react";

const eventData = [
  {
    eventId: 1,
    eventName: "Dasahara",
    eventCapacity: 5,
    deleteStatus: false,
  },
  {
    eventId: 2,
    eventName: "Ratha Yatra",
    eventCapacity: 5,
    deleteStatus: false,
  },
  {
    eventId: 3,
    eventName: "Danda Nrutya",
    eventCapacity: 5,
    deleteStatus: false,
  },
  {
    eventId: 4,
    eventName: "Jatra",
    eventCapacity: 5,
    deleteStatus: false,
  },
  {
    eventId: 5,
    eventName: "Dasahara",
    eventCapacity: 5,
    deleteStatus: false,
  },
  {
    eventId: 6,
    eventName: "Ratha Yatra",
    eventCapacity: 5,
    deleteStatus: false,
  },
];

const EventDetailsPage = (props) => {
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

  // if (!event) {
  //   return <div>Loading event details...</div>;
  // }

  const filteredData = () => {
    return eventData.filter((card) => card.id === props.eventId);
  };

  const event = filteredData(props.eventId);
  return (
    <>
      <div>
        <h1>{event.eventName}</h1>
      </div>

      {/* {isLoggedIn && (
          <button className="btn btn-primary" onClick={handleBookTicket}>
            Book Ticket
          </button>
        )} */}
    </>
  );
};

export default EventDetailsPage;
