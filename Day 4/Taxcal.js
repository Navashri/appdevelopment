import React, { useState } from 'react';
import '../Assets/styles/Taxcal.css';
import { Link } from 'react-router-dom';

const Taxcal = () => {
  const [formData, setFormData] = useState({
    grossIncome: '',
    allowances: '',
    bonuses: '',
    commissions: '',
    otherIncome: '',
    salaryFrequency: 'monthly',
  });
   
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission logic
  };

  return (
    <div className="form-wrapper">
     
      <form onSubmit={handleSubmit}>
        <div>
          <label>Gross Income:</label>
          <input
            type="number"
            name="grossIncome"
            value={formData.grossIncome}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Allowances:</label>
          <input
            type="number"
            name="allowances"
            value={formData.allowances}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Bonuses:</label>
          <input
            type="number"
            name="bonuses"
            value={formData.bonuses}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Commissions:</label>
          <input
            type="number"
            name="commissions"
            value={formData.commissions}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Other Income:</label>
          <input
            type="number"
            name="otherIncome"
            value={formData.otherIncome}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Salary Frequency:</label>
          <select
            name="salaryFrequency"
            value={formData.salaryFrequency}
            onChange={handleChange}
          >
            <option value="monthly">Monthly</option>
            <option value="bi-weekly">Bi-Weekly</option>
            <option value="weekly">Weekly</option>
            <option value="daily">Daily</option>
          </select>
        </div>
        <Link to='/taxcal2'>
          <button type="submit">Next</button>
        </Link>
      </form>
    </div>
    
  );
};

export default Taxcal;