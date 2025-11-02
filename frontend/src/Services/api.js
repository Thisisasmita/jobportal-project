import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080", // backend base URL
  headers: {
    "Content-Type": "application/json",
  },
});

// Attach token to each request (if logged in)
API.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

export default API;
