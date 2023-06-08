import React, { useState, useEffect } from "react";
import { NavLink } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";

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

const EventDetailsPage = () => {
  const { eventId } = useParams();
  const [event, setEvent] = useState(null);
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  useEffect(() => {
    const fetchEventDetails = async () => {
      try {
        // Simulating setting event details from eventData
        const eventDetails = eventData.find(
          (event) => event.eventId === parseInt(eventId)
        );
        setEvent(eventDetails);
      } catch (error) {
        console.error("Error fetching event details:", error);
      }
    };

    fetchEventDetails();
  }, [eventId]);

  const handleBookTicket = () => {
    console.log("Book ticket clicked!");
  };

  if (!event) {
    return <div>Loading event details...</div>;
  }

  return (
    <>
      <NavLink to="#" onClick={handleBack} className="btn">
        🔙
      </NavLink>
      <div>
        <h1>{event.eventName}</h1>
        <p>Event ID: {event.eventId}</p>
        <p>Event Capacity: {event.eventCapacity}</p>
      </div>

      <button className="btn btn-primary" onClick={handleBookTicket}>
        Book Ticket
      </button>
    </>
  );
};

export default EventDetailsPage;
