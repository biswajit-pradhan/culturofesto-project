import React, { useState } from "react";
import axios from "axios";
import { NavLink, useNavigate } from "react-router-dom";
// import "./style.css";

function Login() {
  const [user, setUser] = useState({
    userName: "",
    password: "",
  });
  const [errors, setErrors] = useState({});
  const [msg, setMsg] = useState("");
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const changeHandler = (event) => {
    setUser({
      ...user,
      [event.target.name]: event.target.value,
    });
  };

  const handleValidation = () => {
    const userNamePattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    let tempErrors = {};
    let formValid = true;

    if (!user.userName) {
      formValid = false;
      tempErrors["userName"] = "userName cannot be empty";
    } else if (!userNamePattern.test(user.userName)) {
      formValid = false;
      tempErrors["userName"] = "UserName not valid";
    }

    if (!user.password) {
      formValid = false;
      tempErrors["password"] = "Password cannot be empty";
    }

    setErrors(tempErrors);
    return formValid;
  };

  const loginUser = async () => {
    // let authCode = "Basic " + btoa(user.userName + ":" + user.password);
    // try {
    //   const response = await axios.get("http://localhost:8080/api/user/login", {
    //     headers: { Authorization: authCode },
    //   });
    //   const data = response.data;
    //   console.log("login success " + data);
    //   localStorage.setItem("userName", data.userName);
    //   setIsLoggedIn(true);
    // } catch (error) {
    //   console.error(error);
    //   setMsg("Invalid Credentials");
    // }
  };

  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  return isLoggedIn ? (
    <div>Home Component</div>
  ) : (
    <>
      <NavLink to="#" className="btn" onClick={handleBack}>
        🔙
      </NavLink>
      <div id="login">
        <h3 className="text-center text-white pt-5">Login Form</h3>
        <div className="container">
          <div
            id="login-row"
            className="row justify-content-center align-items-center"
          >
            <div id="login-column" className="col-md-6">
              <div id="login-box" className="col-md-12">
                <h3 className="text-center text-info">Login</h3>
                <span style={{ color: "red" }}>{msg}</span> <br />
                <div className="form-group">
                  <label htmlFor="userNSame" className="text-info">
                    Email:
                  </label>
                  <br />
                  <input
                    className="form-control"
                    placeholder="userName"
                    name="userName"
                    value={user.userName}
                    onChange={changeHandler}
                  />
                  <span style={{ color: "red" }}>{errors["userName"]}</span>
                </div>
                <div className="form-group">
                  <label htmlFor="password" className="text-info">
                    Password:
                  </label>
                  <br />
                  <input
                    type="password"
                    className="form-control"
                    placeholder="Password"
                    name="password"
                    value={user.password}
                    onChange={changeHandler}
                  />
                  <span style={{ color: "red" }}>{errors["password"]}</span>
                </div>
                <div className="form-group">
                  <br />
                  <button className="btn btn-info btn-md" onClick={loginUser}>
                    Login
                  </button>
                  <span>
                    &nbsp;&nbsp;
                    <NavLink to="/signup" className="text-info">
                      Register Here
                    </NavLink>
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Login;
