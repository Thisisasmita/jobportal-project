import { useState } from "react";
import { useParams } from "react-router-dom";
import api from "../api/api";

export default function ApplyJob() {
  const { id } = useParams();
  const [message, setMessage] = useState("");
  const email = localStorage.getItem("email");

  const handleApply = () => {
    api.post("/api/applications/apply", {
      jobId: id,
      jobSeekerEmail: email,
    })
    .then(() => setMessage("Applied successfully!"))
    .catch(() => setMessage("Application failed."));
  };

  return (
    <div className="page">
      <h2>Apply for Job ID: {id}</h2>
      <button onClick={handleApply}>Apply Now</button>
      <p>{message}</p>
    </div>
  );
}
