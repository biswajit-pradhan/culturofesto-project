/* eslint-disable jsx-a11y/img-redundant-alt */
import React from "react";
import { NavLink } from "react-router-dom";

const HomePage = () => {
  const isLoggedIn = true; // Placeholder variable, replace with actual login status
  const username = "John Doe"; // Placeholder variable, replace with actual username

  const handleSearchClick = () => {
    // Handle search click and redirect to search page
  };

  const events = [
    {
      eventName: "Event 1",
      registrationOpenDate: "2023-06-01",
      registrationCloseDate: "2023-06-10",
      eventStartTime: "09:00:00",
      eventCloseTime: "17:00:00",
      registrationFee: 20.0,
      eventCapacity: 100,
      breakfastPrice: 5.0,
      launchPrice: 10.0,
      dinnerPrice: 8.0,
      eventImage: null,
      deleteStatus: false,
    },
    {
      eventName: "Event 2",
      registrationOpenDate: "2023-06-01",
      registrationCloseDate: "2023-06-10",
      eventStartTime: "09:00:00",
      eventCloseTime: "17:00:00",
      registrationFee: 20.0,
      eventCapacity: 100,
      breakfastPrice: 5.0,
      launchPrice: 10.0,
      dinnerPrice: 8.0,
      eventImage: null,
      deleteStatus: false,
    },
    {
      eventName: "Event 3",
      registrationOpenDate: "2023-06-01",
      registrationCloseDate: "2023-06-10",
      eventStartTime: "09:00:00",
      eventCloseTime: "17:00:00",
      registrationFee: 20.0,
      eventCapacity: 100,
      breakfastPrice: 5.0,
      launchPrice: 10.0,
      dinnerPrice: 8.0,
      eventImage: null,
      deleteStatus: false,
    },
    // Add more dummy events as needed
  ];

  // Dummy event details
  const images = [
    {
      src: "https://i.ytimg.com/vi/We_i5gv6MUs/maxresdefault.jpg",
      alt: "Image 1",
      details: "Image 1 Details",
    },
    {
      src: "https://th.bing.com/th/id/OIP.o4u4n0bg4QLmeHTiqPXrJwHaE7?pid=ImgDet&rs=1",
      alt: "Image 2",
      details: "Image 2 Details",
    },
    {
      src: "https://th.bing.com/th/id/OIP.xe1mLmLCe3n8qkbWE1cPWAHaE8?pid=ImgDet&rs=1",
      alt: "Image 3",
      details: "Image 3 Details",
    },
    // Add more images and details as needed
  ];

  const intervalTime = 2000; // Time interval between image scrolls (in milliseconds)
  const [currentIndex, setCurrentIndex] = React.useState(0);

  React.useEffect(() => {
    const timer = setInterval(() => {
      setCurrentIndex((prevIndex) => (prevIndex + 1) % images.length);
    }, intervalTime);

    return () => {
      clearInterval(timer);
    };
  }, [images.length]);

  return (
    <div className="d-flex flex-column min-vh-100">
      <div className="search-section">
        <div className="flex-grow-1 d-flex align-items-center justify-content-center min-vh-100">
          <form className="form-inline">
            <div className="input-group">
              <input
                className="form-control mr-sm-4"
                type="text"
                placeholder="Search"
              />
              <NavLink to="/search" className="search_button">
                <button
                  className="btn btn-primary"
                  type="button"
                  onClick={handleSearchClick}
                >
                  Search
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
            {events.map((event) => (
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

      <section className="scroll-section flex-grow-1">
        <h2 className="homepage_upcoming_title">Past Events</h2>
        <div className="carousel-container">
          <div className="carousel slide" data-ride="carousel">
            <div className="carousel-inner">
              {images.map((image, index) => (
                <div
                  key={index}
                  className={`carousel-item ${
                    index === currentIndex ? "active" : ""
                  }`}
                >
                  <div
                    className="card"
                    style={{
                      margin: "10px",
                      boxShadow: "0 0 6px rgba(0, 0, 0, 0.1)",
                    }}
                  >
                    <img
                      src={image.src}
                      className={`card-img-top ${
                        index === currentIndex ? "current" : "next"
                      }`}
                      alt={image.alt}
                      style={{
                        width: "100%",
                        height: "500px",
                        objectFit: "cover",
                      }}
                    />
                    <div className="card-body" style={{ padding: "10px" }}>
                      <p style={{ textAlign: "center" }} className="card-text">
                        {image.details}
                      </p>
                    </div>
                  </div>
                </div>
              ))}
            </div>
            <a
              className="carousel-control-prev"
              href="#carouselExampleControls"
              role="button"
              data-slide="prev"
            >
              <span
                className="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span className="sr-only">Previous</span>
            </a>
            <a
              className="carousel-control-next"
              href="#carouselExampleControls"
              role="button"
              data-slide="next"
            >
              <span
                className="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span className="sr-only">Next</span>
            </a>
          </div>
        </div>
      </section>
    </div>
  );
};

export default HomePage;
