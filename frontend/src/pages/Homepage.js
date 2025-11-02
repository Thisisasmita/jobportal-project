
import { Link } from "react-router-dom";
import "./Homepage.css";

const HomePage = () => {
  return (
    <div className="homepage">
      {/* Hero Section */}
      <section className="hero">
        <div className="hero-content">
          <h1>Find Your Dream Job</h1>
          <p>Explore thousands of opportunities and take the next step in your career.</p>
          <Link to="/browse" className="btn-primary">
            Browse Jobs
          </Link>
        </div>
      </section>

      {/* Search Section */}
      <section className="search-section">
        <h2>Search Jobs</h2>
        <div className="search-box">
          <input type="text" placeholder="Job Title or Keyword" />
          <input type="text" placeholder="Location" />
          <button className="btn-search">Search</button>
        </div>
      </section>

      {/* Featured Jobs */}
      <section className="featured-jobs">
        <h2>Featured Jobs</h2>
        <div className="job-list">
          {[
            { title: "Frontend Developer", company: "TechNova", location: "Mumbai" },
            { title: "Java Backend Engineer", company: "Cognizant", location: "Pune" },
            { title: "React.js Developer", company: "Infosys", location: "Bangalore" },
          ].map((job, index) => (
            <div key={index} className="job-card">
              <h3>{job.title}</h3>
              <p>{job.company}</p>
              <span>{job.location}</span>
              <Link to="/login" className="btn-apply">Apply Now</Link>
            </div>
          ))}
        </div>
      </section>
    </div>
  );
};

export default HomePage;
