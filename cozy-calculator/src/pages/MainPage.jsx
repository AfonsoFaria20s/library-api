import React from "react";
import "../utils/Colors";
import Calculator from "../components/Calculator/Calculator";
import "../styles/MainPage.scss";
import { COLOR } from "../utils/Colors";

const MainPage = () => {
    const bgStyle = {
        backgroundColor: COLOR.white,
        position: "fixed",
        height: "100%",
        width: "100%",
    };

    return (
        <div id="background" style={bgStyle}>
            <Calculator />
        </div>
    );
};

export default MainPage;
