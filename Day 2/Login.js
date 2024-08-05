import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import '../Assets/styles/Login.css';

function Login() {
    const [formData, setFormData] = useState({
        email: '',
        password: ''
    });
    const [errors, setErrors] = useState({});
    const [message, setMessage] = useState('');
    const navigate = useNavigate(); // Updated hook for navigation

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevFormData) => ({
            ...prevFormData,
            [name]: value
        }));
    };

    const validate = () => {
        let validationErrors = {};
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

        if (!formData.email) {
            validationErrors.email = "Email is required";
        } else if (!emailPattern.test(formData.email)) {
            validationErrors.email = "Invalid email format";
        }

        if (!formData.password) {
            validationErrors.password = "Password is required";
        }

        setErrors(validationErrors);

        return Object.keys(validationErrors).length === 0;
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validate()) {
            const storedUser = JSON.parse(localStorage.getItem('user'));
            if (storedUser && storedUser.email === formData.email && storedUser.password === formData.password) {
                if (storedUser.role === 'admin') {
                    setMessage("Admin login successful!");
                    navigate('/admin-dashboard'); // Navigate to admin dashboard
                } else {
                    setMessage("User login successful!");
                    navigate('/taxcal'); // Navigate to user page
                }
                console.log("Login successful:", formData);
            } else {
                setMessage("Invalid email or password.");
                console.log("Invalid email or password:", formData);
            }
        }
    };

    return (
        <div className="container">
            <div className="login">
                <h1>LOGIN</h1>
                <form onSubmit={handleSubmit}>
                    <label>Email</label>
                    <input
                        type="email"
                        placeholder="Enter your Email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                    />
                    {errors.email && <span style={{ color: 'red' }}>{errors.email}</span>}
                    
                    <label>Password</label>
                    <input
                        type="password"
                        placeholder="Enter password"
                        value={formData.password}
                        onChange={handleChange}
                        name="password"
                    />
                    {errors.password && <span style={{ color: 'red' }}>{errors.password}</span>}
                    
                    <button type="submit"> <Link to="/taxcal">Login</Link></button>
                    
                    <p>
                        Don't have an account? <Link to="/register">Register</Link>
                    </p>
                </form>
                {message && <p>{message}</p>}
            </div>
        </div>
    );
}

export default Login;
