const eventData = [
  {
    eventName: "Dasara",
    registrationOpenDate: "2023-06-01",
    registrationCloseDate: "2023-06-10",
    eventStartTime: "10:00",
    eventCloseTime: "18:00",
    registrationFee: 500.0,
    entryCapacity: 100.0,
  },
];

const getCurrentDate = () => {
  const today = new Date();
  const year = today.getFullYear();
  const month = String(today.getMonth() + 1).padStart(2, "0");
  const day = String(today.getDate()).padStart(2, "0");
  return `${day}-${month}-${year}`;
};

const EventBookingPage = () => {
  return (
    <>
      <h1 className="container_eventbooking_h1">Event Booking</h1>

      <div className="page_container">
        <div className="container_eventbooking">
          <div className="row">
            {eventData.map((event, index) => (
              <div className="col-md-4" key={index}>
                <div className="card mb-4">
                  <div className="card-body">
                    <h5 className="card-title">
                      Event Name: {event.eventName}
                    </h5>
                    <p className="card-text">
                      Registration Date: {getCurrentDate()}
                    </p>
                    <p className="card-text">
                      Event Time: {event.eventStartTime} -{" "}
                      {event.eventCloseTime}
                    </p>
                    <p className="card-text">
                      Registration Fee: {event.registrationFee}
                    </p>
                    <p className="card-text">
                      Entry Capacity: {event.entryCapacity}
                    </p>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </>
  );
};

export default EventBookingPage;
