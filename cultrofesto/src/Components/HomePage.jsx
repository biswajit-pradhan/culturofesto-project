/* eslint-disable jsx-a11y/img-redundant-alt */
import React from "react";
import { Link, NavLink } from "react-router-dom";

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

  const socialMediaLinks = [
    { name: "Facebook", url: "https://www.facebook.com/example" },
    { name: "Twitter", url: "https://www.twitter.com/example" },
    { name: "Instagram", url: "https://www.instagram.com/example" },
    // Add more social media links as needed
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
        <h2>Past Events</h2>
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
                  <img
                    src={image.src}
                    className={`d-block w-100 ${
                      index === currentIndex ? "current" : "next"
                    }`}
                    alt={image.alt}
                  />
                  <div className="carousel-caption">
                    <p>{image.details}</p>
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
      <br />
      <br />
      <footer className="footer">
        <div className="container">
          <div className="row">
            <div className="col-md-6">
              <h4>About Us</h4>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut eu
                felis non tortor fermentum fringilla.
              </p>
            </div>
            <div className="col-md-3">
              <h4>Quick Links</h4>
              <ul className="list-unstyled">
                <li>
                  <a href="#">Home</a>
                </li>
                <li>
                  <a href="#">About</a>
                </li>
                <li>
                  <a href="#">Services</a>
                </li>
                <li>
                  <a href="#">Contact</a>
                </li>
              </ul>
            </div>
            <div className="col-md-3">
              <h4>Follow Us</h4>
              <ul className="list-unstyled social-media-links">
                {socialMediaLinks.map((link, index) => (
                  <li key={index}>
                    <a
                      href={link.url}
                      target="_blank"
                      rel="noopener noreferrer"
                    >
                      {link.name}
                    </a>
                  </li>
                ))}
              </ul>
            </div>
          </div>
          <hr />
          <div className="text-center">
            <p>&copy; 2023 Your Website. All rights reserved.</p>
          </div>
        </div>
      </footer>
    </div>
  );
};

export default HomePage;
