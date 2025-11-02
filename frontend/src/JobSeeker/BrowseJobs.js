import { useState } from "react";
import { fetchJobsByTitle } from "../../services/jobPostService";
import "./JobSeeker.css";

export default function BrowseJobs() {
  const [title, setTitle] = useState("");
  const [jobs, setJobs] = useState([]);

  const handleSearch = async () => {
    try {
      const res = await fetchJobsByTitle(title);
      setJobs(res.data);
    } catch {
      alert("No jobs found!");
    }
  };

  return (
    <div className="browse-jobs">
      <h2>Browse Jobs</h2>
      <div className="search-bar">
        <input
          type="text"
          placeholder="Search by Job Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <button onClick={handleSearch}>Search</button>
      </div>
      <div className="job-list">
        {jobs.map((job, i) => (
          <div key={i} className="job-card">
            <h3>{job.jobTitle}</h3>
            <p>{job.companyName}</p>
            <p>{job.jobDescription}</p>
            <button>View Details</button>
          </div>
        ))}
      </div>
    </div>
  );
}
