import { useEffect, useState } from "react";
import { getApplicationsByJobSeeker } from "../../services/applicationService";
import "./JobSeeker.css";

export default function MyApplications() {
  const [applications, setApplications] = useState([]);
  const email = localStorage.getItem("userEmail");

  useEffect(() => {
    const fetchApps = async () => {
      const res = await getApplicationsByJobSeeker(email);
      setApplications(res.data);
    };
    fetchApps();
  }, [email]);

  return (
    <div className="my-applications">
      <h2>My Applications</h2>
      <table>
        <thead>
          <tr>
            <th>Job Title</th>
            <th>Status</th>
            <th>Company</th>
          </tr>
        </thead>
        <tbody>
          {applications.map((app, i) => (
            <tr key={i}>
              <td>{app.jobTitle}</td>
              <td>{app.status}</td>
              <td>{app.companyName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
