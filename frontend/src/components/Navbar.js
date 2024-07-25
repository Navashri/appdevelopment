import React from "react";
import { Link } from "react-router-dom";
import '../Assets/styles/Navbar.css';
function Navbar() {
    return (
        <nav>
            <ul>
                <li><Link to="/">HOME</Link></li>
                <li><Link to="/login">LOGIN</Link></li>
                <li><Link to="/register">REGISTER</Link></li>
            </ul>
        </nav>
    );
}

export default Navbar;