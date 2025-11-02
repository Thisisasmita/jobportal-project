import API from "./api";

const JobService = {
  getAllByTitle: (title) => API.get(`/api/jobpost/title/${title}`),
  getAllByCompany: (companyName) => API.get(`/api/jobpost/company/${companyName}`),
  getAllByRecruiter: (email) => API.get(`/api/jobpost/recruiter/${email}`),
  createJob: (jobData) => API.post("/api/jobpost/create", jobData),
};

export default JobService;
