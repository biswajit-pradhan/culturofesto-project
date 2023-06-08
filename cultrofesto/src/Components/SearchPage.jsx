import React, { useEffect, useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";
// import GetBook from "../getBook";

const SearchPage = () => {
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };
  const [bid, setBid] = useState(0);
  const [msg, setMsg] = useState("");
  const [isLoggedIn, setIsLoggedIn] = useState(false);

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

  const handleSearchByBookName = (e) => {
    // Handle search logic for book name
  };

  const handleGetBook = (event) => {
    setBid(event);
  };

  return (
    <div>
      <div>
        <NavLink to="#" onClick={handleBack} className="btn">
          🔙
        </NavLink>
        <h1>Search a Event</h1>
        <form className="form-inline my-2 my-lg-0">
          <input
            className="form-control mr-sm-2"
            type="search"
            placeholder="By Event Name"
            aria-label="Search"
            onChange={handleSearchByBookName}
          />
          <span style={{ color: "red" }}>{msg}</span>
          <button className="btn btn-primary btn-sm" type="submit">
            Search
          </button>
        </form>
        <br />
        <br />
        <div className="col-lg-12">
          <table className="table table-dark table-hover">
            <thead>
              <tr>
                <th scope="col">SlNo</th>
                <th scope="col">ID</th>
                <th scope="col">View</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Regd Opening</th>
                <th scope="col">Regd Closing</th>
                <th scope="col">Event Time</th>
                <th scope="col">Capacity</th>
                <th scope="col">Details</th>
              </tr>
            </thead>
            <tbody>
              {events.map((event, index) => (
                <tr key={event.id}>
                  <th scope="row">{index + 1}</th>
                  <td>{event.id}</td>
                  <td>
                    <img
                      //   src={require("../../coverimages/" + event.coverimg)}
                      width={180}
                      height={200}
                      alt="info"
                    />
                  </td>
                  <td>{event.name}</td>
                  <td>{event.price}</td>
                  <td>{event.authorName}</td>
                  <td>{event.publishingYear}</td>
                  <td>{event.bookLanguage}</td>
                  <td>{event.bookCategory}</td>
                  <td>
                    <button
                      type="button"
                      className="btn btn-outline-success my-2 my-sm-0"
                      data-toggle="modal"
                      data-target="#exampleModal"
                      onClick={() => handleGetBook(event)}
                    >
                      Details
                    </button>
                  </td>
                  {/* <td>
                    <GetBook bid={bid} />
                  </td> */}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default SearchPage;
