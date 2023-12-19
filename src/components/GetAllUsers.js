import React, { useEffect, useState } from 'react';
import axios from 'axios';


const GetAllUsers = () => {
  const [users, setUsers] = useState([]);
  const [isLoading, setLoading] = useState(true);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        // Add your backend API endpoint for fetching all users
        const apiUrl = 'http://localhost:8080/getAllUsers';

        // Make a GET request to the backend API
        const response = await axios.get(apiUrl);

        // Handle the response (you can add more logic here)
        console.log('Get All Users API Response:', response.data);

        if (response.status === 200) {
          setUsers(response.data);
        }
      } catch (error) {
        console.error('Error:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchUsers();
  }, []); // Empty dependency array ensures that this effect runs only once on component mount

  return (
    <div>
      <h1>User List</h1>

      {isLoading ? (
        <p>Loading...</p>
      ) : (
        <ul>
          {users.map((user) => (
            <li key={user.id}>
              {user.username} - {user.email}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default GetAllUsers;
