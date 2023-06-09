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
    console.log(event.eventId);
    navigate("/event-booking");
  };

  if (!event) {
    return <div>Loading event details...</div>;
  }

  return (
    <>
      <div>
        <NavLink to="#" onClick={handleBack} className="btn back-link">
          <span className="back-link-icon">🔙</span>
        </NavLink>
        <h1 className="homepage_upcoming_title">Event Details</h1>
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            minHeight: "100%",
            paddingBottom: "200px",
          }}
        >
          <div className="navlink_event_details">
            <div className="event_details_data">
              <h1>{event.eventName}</h1>
              <p>Event ID: {event.eventId}</p>
              <p>Hurry only {event.eventCapacity} tickets remaining...</p>
            </div>

            <NavLink
              className="btn btn-primary nav_link"
              onClick={handleBookTicket}
            >
              Book Ticket
            </NavLink>
          </div>
        </div>
      </div>
    </>
  );
};

export default EventDetailsPage;
