import { Carousel } from "react-bootstrap";
import { NavLink, useNavigate } from "react-router-dom";
import { useState } from "react";
import EventDetailsPage from "./EventDetailsPage";

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

const UserDashboardPage = () => {
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <>
      <NavLink to="#" onClick={handleBack} className="btn">
        🔙
      </NavLink>
      <h3 className="user_upcoming">Upcoming Registered Events</h3>
      <div>
        <Carousel
          style={{ display: "flex", justifyContent: "center" }}
          activeIndex={index}
          onSelect={handleSelect}
          interval={1400}
        >
          {eventData.map((event) => (
            <Carousel.Item key={event.eventId}>
              <div className="d-flex justify-content-center">
                <div className="card" style={{ width: "25rem" }}>
                  <div className="card-body">
                    <h5 className="card-title">{event.eventId}</h5>
                    <h6 className="card-subtitle mb-2 text-muted">
                      {event.eventName}
                    </h6>
                    <p className="card-text">{event.eventCapacity}</p>
                    <NavLink
                      to={<EventDetailsPage eventId={event.eventId} />}
                      className="card-link"
                    >
                      Details
                    </NavLink>
                  </div>
                </div>
              </div>
            </Carousel.Item>
          ))}
        </Carousel>
      </div>
    </>
  );
};

export default UserDashboardPage;
