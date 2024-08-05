import React from "react";
import { Link } from "react-router-dom";
import '../Assets/styles/Navbar.css';

function Navbar() {
    return (
        <nav className="navbar">
            <ul className="navbar__links">
                <li className="navbar__item"><Link to="/">HOME</Link></li>
                <li className="navbar__item"><Link to="/login">LOGIN</Link></li>
                {/* <li className="navbar__item"><Link to="/register">REGISTER</Link></li>
                <li className="navbar__item"><Link to="/taxcal">TAX CALCULATOR</Link></li> */}
            </ul>
        </nav>
    );
}

export default Navbar;
