import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios'; // Import Axios
import './Update.css'; // Import the CSS file for styling

const UpdateUser = () => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    username: '',
    email: '',
    mobileNumber: '',
    password: '',
    confirmPassword: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const updateUserDetails = async (e) => {
    
    try{
        const apiUrl = 'http://localhost:8080/updateuser';
        const response = await axios.post(apiUrl, formData);

      if (response.status === 200) {
            window.alert(response.data);
            navigate('/Home');
      }
    } 
    catch (error) {
      console.error('Error:', error);
    }
  };

  const handleNavigation = (route) => {
   navigate(route);
  };

  return (
    <div className="update-container">
      <h2>Update User Details</h2>
      <form>
        

        

        <div className="form-group">
          <label htmlFor="username">Username:</label>
          <input
            type="text"
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
            required
          />
        </div>
      <div className="form-group">
          <label htmlFor="mobileNumber">MobileNumber:</label>
          <input
            type="text"
                    name="mobileNumber"
                    value={formData.mobileNumber}
                    onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="Password">Password:</label>
          <input
            type="password"
                    name="password"
                    value={formData.password}
                    onChange={handleChange}
            required
          />
        </div>

        <button type="button" onClick={updateUserDetails}>
          Update User Details
        </button>

        <button type="button" onClick={() => handleNavigation('/Home')} className="back-button">
          Back to Home
        </button>
      </form>
    </div>
  );
};

export default UpdateUser;