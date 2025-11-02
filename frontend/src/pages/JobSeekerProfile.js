import { useEffect, useState } from "react";
import api from "../api/api";

export default function JobSeekerProfile() {
  const [profile, setProfile] = useState(null);
  const email = localStorage.getItem("email");

  useEffect(() => {
    api.get(`/api/jobSeekers/${email}`)
      .then((res) => setProfile(res.data))
      .catch((err) => console.error(err));
  }, [email]);

  return (
    <div className="page">
      <h2>My Profile</h2>
      {profile ? (
        <div className="profile-card">
          <p><b>Name:</b> {profile.name}</p>
          <p><b>Email:</b> {profile.email}</p>
          <p><b>Skills:</b> {profile.skills}</p>
          <p><b>Experience:</b> {profile.experience} years</p>
        </div>
      ) : (
        <p>Loading profile...</p>
      )}
    </div>
  );
}
