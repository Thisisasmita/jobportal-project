// src/components/Navbar.js
import { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../context/AuthContext";
import "./Navbar.css";

const Navbar = () => {
  const { user, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <nav className="navbar">
      <div className="navbar-logo">
        <Link to="/">JobPortal</Link>
      </div>

      <ul className="navbar-links">
        {!user && (
          <>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/browse">Browse Jobs</Link></li>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/register">Register</Link></li>
          </>
        )}

        {user && (
          <>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/jobseeker/profile">Profile</Link></li>
            <li><Link to="/browse">Browse Jobs</Link></li>
            <li><Link to="/applications">My Applications</Link></li>
            <li><Link to="/resume">Resume Upload</Link></li>
            <li>
              <button onClick={handleLogout} className="logout-btn">Logout</button>
            </li>
          </>
        )}
      </ul>
    </nav>
  );
};

export default Navbar;
