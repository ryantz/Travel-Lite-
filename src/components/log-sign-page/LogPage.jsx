import React from "react";
import { assets } from "../../assets/assets";
import "./logPage.css";

const LogPage = () => {
  return (
    <>
      <div className="logpage-wrap">
        <div className="logpage-toprow">
          <button type="button">
            <img src={assets.closeWindowIcon} alt="closeWindow"></img>
          </button>
        </div>
        <div className="logpage-greeting">Welcome Back!</div>
        <div className="logpage-input-area">
          <div className="logpage-userpass">
            <input
              type="text"
              className="logpage-input"
              placeholder="Enter username/email"
            ></input>
            <input
              type="text"
              className="logpage-input"
              placeholder="Enter password"
            ></input>
          </div>
          <button className="logpage-submit">Login</button>
        </div>
      </div>
    </>
  );
};

export default LogPage;
