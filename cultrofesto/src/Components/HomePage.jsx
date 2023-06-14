/* eslint-disable jsx-a11y/img-redundant-alt */
import axios from "axios";
import React, { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";

const HomePage = () => {
  const isLoggedIn = true; // Placeholder variable, replace with actual login status
  const username = "John Doe"; // Placeholder variable, replace with actual username

  const handleSearchClick = () => {
    // Handle search click and redirect to search page
  };

  const intervalTime = 2000; // Time interval between image scrolls (in milliseconds)
  const [currentIndex, setCurrentIndex] = React.useState(0);

  const [pastEvents, setPastEvents] = useState([]);
  const [upcomingEvents, setUpcomingEvents] = useState([]);

  const imageArrayBuffer = pastEvents.eventImage; // Assuming the byte array is returned as `data`
  const blob = new Blob([imageArrayBuffer], { type: "image/png" });
  const imageUrl = URL.createObjectURL(blob);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [pastEventsResponse, upcomingEventsResponse] = await Promise.all([
          axios.get("/api/event/past"),
          axios.get("/api/event/future"),
        ]);

        setPastEvents(pastEventsResponse.data);
        setUpcomingEvents(upcomingEventsResponse.data);
      } catch (error) {
        console.error("Error fetching events:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="d-flex flex-column min-vh-100">
      <div className="search-section">
        <div className="flex-grow-1 d-flex align-items-center justify-content-center min-vh-100">
          <form className="form-inline">
            <div className="input-group">
              <NavLink to="/search">
                <button className="search_button" onClick={handleSearchClick}>
                  Search events
                </button>
              </NavLink>
            </div>
          </form>
        </div>
      </div>

      <h2 className="homepage_upcoming_title">UpComming Events</h2>
      <section className="flex-grow-1  min-vh-100">
        <div className="container event-item">
          <div className="row">
            {upcomingEvents.map((event) => (
              <div
                key={event.eventName}
                className="col-sm-12 col-md-6 col-lg-4 mb-4"
              >
                <div className="card">
                  {/* Add event image here */}
                  <div className="card-body">
                    <h5 className="card-title">{event.eventName}</h5>
                    <p className="card-text">
                      Registration Open: {event.registrationOpenDate}
                      <br />
                      Registration Close: {event.registrationCloseDate}
                      <br />
                      Start Time: {event.eventStartTime}
                      <br />
                      End Time: {event.eventCloseTime}
                      <br />
                      Registration Fee: {event.registrationFee}
                      <br />
                      Capacity: {event.eventCapacity}
                      <br />
                      {/* Add other event details */}
                    </p>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </section>

      <h2 className="homepage_upcoming_title">Past Events</h2>
      <section className="flex-grow-1  min-vh-100">
        <div className="container event-item">
          <div className="row">
            {pastEvents.map((event) => (
              <div
                key={event.eventName}
                className="col-sm-12 col-md-6 col-lg-4 mb-4"
              >
                <div className="card">
                  {/* Add event image here */}
                  <div className="card-body">
                    <h5 className="card-title">{event.eventName}</h5>
                    <p className="card-text">
                      Registration Open: {event.registrationOpenDate}
                      <br />
                      Registration Close: {event.registrationCloseDate}
                      <br />
                      Start Time: {event.eventStartTime}
                      <br />
                      End Time: {event.eventCloseTime}
                      <br />
                      Registration Fee: {event.registrationFee}
                      <br />
                      Capacity: {event.eventCapacity}
                      <br />
                      {/* Add other event details */}
                    </p>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </section>
    </div>
  );
};

export default HomePage;
