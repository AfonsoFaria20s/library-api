import React from "react";
import Navbar from "../../components/Navbar/Navbar";
import "../../styles/LoginPage/LoginStyle.scss";

const LoginPage = () => {
    return (
        <div className="background">
            <Navbar />
            <div className="form">
                <p id="title">Login</p>
                <div className="email">
                    <input type="text" id="email" placeholder="EMAIL" />
                </div>
                <div className="password">
                    <input type="password" id="pass" placeholder="PASSWORD" />
                </div>
                <button id="signin">Sign In</button>
                <div className="register-account">
                    <span>
                        Dont have an account?{" "}
                        <a href="/register">Create one here.</a>
                    </span>
                </div>
            </div>
        </div>
    );
};

export default LoginPage;
