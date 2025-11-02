import axios from "axios";
const API_BASE = "http://localhost:8080/api/jobSeekers";

export const getJobSeekerByEmail = async (email) =>
  axios.get(`${API_BASE}/${email}`);

export const saveJobSeeker = async (data) =>
  axios.post(API_BASE, data);
