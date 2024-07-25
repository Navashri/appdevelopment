import { useState } from "react";
import { Link } from "react-router-dom";
import '../Assets/styles/Registration.css';

function Register() {
    const [formData, setFormData] = useState({
        name: '',
        dateOfBirth: '',
        gender: '',
        email: '',
        password: '',
        confirmPassword: ''
    });
    const [errors, setErrors] = useState({});
    const [message, setMessage] = useState('');

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
        const passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

        if (!formData.name) {
            validationErrors.name = "Name is required";
        }

        if (!formData.dateOfBirth) {
            validationErrors.dateOfBirth = "Date of birth is required";
        }

        if (!formData.gender) {
            validationErrors.gender = "Gender is required";
        }

        if (!formData.email) {
            validationErrors.email = "Email is required";
        } else if (!emailPattern.test(formData.email)) {
            validationErrors.email = "Invalid email format";
        }

        if (!formData.password) {
            validationErrors.password = "Password is required";
        } else if (!passwordPattern.test(formData.password)) {
            validationErrors.password = "Password must be at least 8 characters long, contain one capital letter, one digit, and one special character";
        }

        if (!formData.confirmPassword) {
            validationErrors.confirmPassword = "Confirm password is required";
        } else if (formData.password !== formData.confirmPassword) {
            validationErrors.confirmPassword = "Passwords do not match";
        }

        setErrors(validationErrors);

        return Object.keys(validationErrors).length === 0;
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validate()) {
            localStorage.setItem('user', JSON.stringify(formData));
            setMessage("Registration successful. You can now log in.");
            console.log("Registration successful:", formData);
        }
    };

    return (
        <div>
            <h1>Register</h1>
            <form onSubmit={handleSubmit}>
                <label>Name</label>
                <input
                    type="text"
                    placeholder="Enter your name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                />
                {errors.name && <span style={{ color: 'red' }}>{errors.name}</span>}
                
                <label>Date of Birth</label>
                <input
                    type="date"
                    placeholder="Enter your date of birth"
                    name="dateOfBirth"
                    value={formData.dateOfBirth}
                    onChange={handleChange}
                />
                {errors.dateOfBirth && <span style={{ color: 'red' }}>{errors.dateOfBirth}</span>}
                
                <label>Gender</label>
                <select
                    name="gender"
                    value={formData.gender}
                    onChange={handleChange}
                >
                    <option value="">Select gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                </select>
                {errors.gender && <span style={{ color: 'red' }}>{errors.gender}</span>}
                
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

                <label>Confirm Password</label>
                <input
                    type="password"
                    placeholder="Confirm password"
                    value={formData.confirmPassword}
                    onChange={handleChange}
                    name="confirmPassword"
                />
                {errors.confirmPassword && <span style={{ color: 'red' }}>{errors.confirmPassword}</span>}
                
                <button type="submit">Register</button>
            </form>
            {message && <p>{message}</p>}
            <p>
                Already have an account? <Link to="/">Login</Link>
            </p>
        </div>
    );
}

export default Register;



