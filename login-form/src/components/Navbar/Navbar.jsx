import React from "react";
import "../../styles/components/Navbar.scss";

const Navbar = () => {
    return (
        <div className="navbar">
            <div className="icon">
                <img
                    src="https://cdn-icons-png.flaticon.com/512/295/295128.png"
                    alt="logo"
                    id="logo"
                />
            </div>
            <div className="navigation">
                <div className="login">login</div>
                <div className="register">register</div>
            </div>
        </div>
    );
};

export default Navbar;
