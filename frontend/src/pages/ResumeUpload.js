import { useState } from "react";
import api from "../api/api";

export default function ResumeUpload() {
  const [file, setFile] = useState(null);
  const [message, setMessage] = useState("");
  const email = localStorage.getItem("email");

  const handleUpload = async () => {
    const formData = new FormData();
    formData.append("file", file);
    formData.append("email", email);

    try {
      await api.post("/api/upload/resume", formData, {
        headers: { "Content-Type": "multipart/form-data" },
      });
      setMessage("Resume uploaded successfully!");
    } catch (err) {
      setMessage("Upload failed.");
    }
  };

  return (
    <div className="page">
      <h2>Upload Resume</h2>
      <input type="file" onChange={(e) => setFile(e.target.files[0])} />
      <button onClick={handleUpload}>Upload</button>
      <p>{message}</p>
    </div>
  );
}
