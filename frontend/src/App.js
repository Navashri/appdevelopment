import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import Login from "./components/Login";
import Register from './components/Registration';
import Navbar from "./components/Navbar";

function App() {
    return (
        <div>

        <Router>
            <Navbar />
            <Routes>
                <Route exact path='/' element={<Home/>}/>
                <Route exact path='/login' element={<Login/>}/>
                <Route exact path='/register' element={<Register/>}/>
            </Routes>
        </Router>
        </div>
    );
}

export default App;