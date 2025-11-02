import axios from "axios";
const API_BASE = "http://localhost:8080/api/applications";

export const applyForJob = async (data) =>
  axios.post(`${API_BASE}/apply`, data);

export const getApplicationsByJobSeeker = async (email) =>
  axios.get(`${API_BASE}/jobseeker?jobSeekerEmail=${email}`);
