import { Carousel } from "react-bootstrap";
import { NavLink, useNavigate } from "react-router-dom";
import { useState } from "react";

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
      <div className="user_dashboard_background">
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
            indicators={false} // Set indicators prop to false
          >
            {eventData.map((event) => (
              <Carousel.Item key={event.eventId}>
                <div className="d-flex justify-content-center">
                  <div className="card" style={{ width: "50rem" }}>
                    <div className="card-body d-flex flex-column align-items-center">
                      <h5 className="card-title">{event.eventName}</h5>
                      <h6 className="card-subtitle mb-2 text-muted">
                        Event Id: {event.eventId}
                      </h6>
                      <p className="card-text">
                        Event Capacity: {event.eventCapacity}
                      </p>

                      <NavLink
                        to={`/event-details/${event.eventId}`} // Pass the event ID as part of the URL
                        className="btn btn-primary"
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
        <div>
          <h3 className="user_upcoming">Last 5 Month Events you attended</h3>
          <div>
            <Carousel
              style={{ display: "flex", justifyContent: "center" }}
              activeIndex={index}
              onSelect={handleSelect}
              interval={1500}
              indicators={false}
            >
              {eventData.map((event) => (
                <Carousel.Item key={event.eventId}>
                  <div className="d-flex justify-content-center">
                    <div className="card" style={{ width: "50rem" }}>
                      <div className="card-body d-flex flex-column align-items-center">
                        <h5 className="card-title">{event.eventName}</h5>
                        <h6 className="card-subtitle mb-2 text-muted">
                          Event Id: {event.eventId}
                        </h6>
                        <p className="card-text">
                          Event Capacity: {event.eventCapacity}
                        </p>

                        <NavLink
                          to={`/event-details/${event.eventId}`} // Pass the event ID as part of the URL
                          className="btn btn-primary"
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
        </div>
      </div>
    </>
  );
};

export default UserDashboardPage;
