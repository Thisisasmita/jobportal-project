import axios from "axios";

const API_BASE = "http://localhost:8080/api/jobpost";

export const fetchJobsByTitle = async (title) =>
  axios.get(`${API_BASE}/title/${title}`);

export const fetchJobsByCompany = async (company) =>
  axios.get(`${API_BASE}/company/${company}`);

export const fetchJobsByRecruiter = async (email) =>
  axios.get(`${API_BASE}/recruiter/${email}`);
