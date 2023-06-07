import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar navbar-light bg-light ">
      <Link to="/">
        <span className="navbar-brand">CuturoFesto</span>
      </Link>

      <div className="ml-auto">
        <a href="/admin" className="text-info">
          AdminPage
        </a>
        <Link to="/login">
          <button className="btn btn-primary mr-2">Login</button>
        </Link>
      </div>
    </nav>
  );
};
export default Navbar;
