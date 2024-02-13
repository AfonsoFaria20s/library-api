import React from "react";
import { COLOR } from "../../utils/Colors";
import "../../styles/Calculator.scss";

const Calculator = () => {
    const bgStyle = {
        backgroundColor: COLOR.black,
        width: "75vh",
        height: "80vh",
    };

    return (
        <div className="calc_bg" style={bgStyle}>
            <div className="logic_text">a</div>
            <div className="buttons"></div>
        </div>
    );
};

export default Calculator;
