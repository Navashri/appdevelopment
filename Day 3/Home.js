import React from 'react';
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css'; // Requires a loader
import '../Assets/styles/Home.css';
import Footer from "./Footer";

function Home() {
    return (
        <div className="home">
            <div className="main-content">
                <div className="content">
                    <h1>Welcome to NexTax!</h1>
                    <h2>Simplify Your Taxes, Maximize Your Refund.</h2>
                    <h3>At NexTax, we understand that tax season can be overwhelming. Our mission is to make tax filing easy, accurate, and stress-free. Whether you're an individual, a freelancer, or a small business owner, we've got you covered with our user-friendly tools and expert support.</h3>
                    <h3><b>User-Friendly Interface:</b> Our intuitive platform guides you through each step of the tax filing process, ensuring you don't miss any important details.</h3>
                    <h3><b>Security You Can Trust:</b> Your data is safe with us. We use the latest encryption technology to protect your personal information.</h3>
                    <h3>Accurate Calculations: Benefit from our advanced algorithms that ensure precise calculations, maximizing your deductions and refunds.</h3>
                    <br></br>
                    <h2>Features</h2>
                    <h3>Simple Step-by-Step Process: Follow our easy-to-understand prompts to complete your tax return with confidence.</h3>
                    <h3>Smart Deductions: Automatically identify deductions and credits to help you get the most out of your tax return.</h3>
                </div>
                {/* <div className="carousel-container">
                <Carousel showThumbs={false} autoPlay={true} infiniteLoop={true} className="carousel-top">
                        <div>
                            <img src={require('../Assets/image/pic4.jpg')} alt="First slide" />
                            <p className="legend">First Slide</p>
                        </div>
                        <div>
                            <img src={require('../Assets/image/pic2.jpeg')} alt="Second slide" />
                            <p className="legend">Second Slide</p>
                        </div>
                        <div>
                            <img src={require('../Assets/image/pic3.jpeg')} alt="Third slide" />
                            <p className="legend">Third Slide</p>
                        </div>
                    </Carousel>
                </div> */}
            </div>
            <Footer />
        </div>
    );
}

export default Home;
