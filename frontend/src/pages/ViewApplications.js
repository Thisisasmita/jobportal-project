import { useEffect, useState } from "react";
import api from "../api/api";

export default function ViewApplications() {
  const [apps, setApps] = useState([]);
  const email = localStorage.getItem("email");

  useEffect(() => {
    api.get(`/api/applications/jobseeker?jobSeekerEmail=${email}`)
      .then((res) => setApps(res.data))
      .catch((err) => console.error(err));
  }, [email]);

  return (
    <div className="page">
      <h2>My Applications</h2>
      {apps.map((a) => (
        <div key={a.id} className="app-card">
          <p><b>Job Title:</b> {a.jobTitle}</p>
          <p><b>Status:</b> {a.status}</p>
        </div>
      ))}
    </div>
  );
}
