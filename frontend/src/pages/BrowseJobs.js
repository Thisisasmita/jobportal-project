import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../api/api";

export default function BrowseJobs() {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    api.get("/api/jobpost/title/developer")
      .then((res) => setJobs(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="page">
      <h2>Browse Jobs</h2>
      <div className="job-list">
        {jobs.map((job) => (
          <div key={job.id} className="job-card">
            <h3>{job.jobTitle}</h3>
            <p><b>Company:</b> {job.companyName}</p>
            <p><b>Location:</b> {job.location}</p>
            <Link to={`/apply/${job.id}`} className="apply-btn">Apply</Link>
          </div>
        ))}
      </div>
    </div>
  );
}
