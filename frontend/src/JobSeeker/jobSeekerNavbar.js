import { Link } from "react-router-dom";
import "./JobSeeker.css";

export default function JobSeekerNavbar() {
  return (
    <nav className="navbar">
      <h2 className="logo">JobPortal</h2>
      <div className="nav-links">
        <Link to="/jobseeker/dashboard">Dashboard</Link>
        <Link to="/jobseeker/jobs">Browse Jobs</Link>
        <Link to="/jobseeker/applications">My Applications</Link>
        <Link to="/jobseeker/profile">Profile</Link>
        <Link to="/">Logout</Link>
      </div>
    </nav>
  );
}
