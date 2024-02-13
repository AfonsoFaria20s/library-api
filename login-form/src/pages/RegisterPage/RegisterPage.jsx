import React from "react";
import Navbar from "../../components/Navbar/Navbar";
import "../../styles/register/RegisterStyle.scss";

const RegisterPage = () => {
    return (
        <div className="background">
            <Navbar />
            <div className="form">
                <p id="title">Register</p>
                <div className="name">
                    <input type="text" id="name" placeholder="NAME" />
                </div>
                <div className="email">
                    <input type="text" id="email" placeholder="EMAIL" />
                </div>
                <div className="password">
                    <input type="password" id="pass" placeholder="PASSWORD" />
                    <input
                        type="password"
                        id="confirm-pass"
                        placeholder="CONFIRM PASSWORD"
                    />
                </div>
                <button id="signup">Sign Up</button>
                <div className="register-account">
                    <span>
                        Already have an account?{" "}
                        <a href="/login">Login here.</a>
                    </span>
                </div>
            </div>
        </div>
    );
};

export default RegisterPage;
