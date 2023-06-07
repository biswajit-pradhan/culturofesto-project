import React from "react";

const events = [
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

const AdminDashboardPage = () => {
  return (
    <div className="admin_container">
      <div className="admin-header">
        <h1>Admin DashBoard</h1>
      </div>
      <div className="admin-create-event-button">
        <button className="btn btn-primary">Create Event</button>
      </div>
      <div className="event-container">
        <h2 className="admin-event-header">List of Events</h2>
        <div className="card-grid">
          {events.map((event) => (
            <div key={event.eventId} className="event-item card">
              <div className="card-body">
                <h1 className="card-title">{event.eventName}</h1>
                <p className="card-text">Event ID: {event.eventId}</p>
                <div className="btn-group">
                  <button className="btn btn-secondary">Modify</button>
                  <button className="btn btn-danger">Delete</button>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default AdminDashboardPage;
