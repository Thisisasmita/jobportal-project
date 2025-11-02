import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";
import ProtectedRoute from "./components/ProtectedRoute";
import { AuthProvider } from "./context/AuthContext";
import ApplyJob from "./pages/ApplyJob";
import BrowseJobs from "./pages/BrowseJobs";
import HomePage from "./pages/Homepage";
import JobSeekerProfile from "./pages/JobSeekerProfile";
import Login from "./pages/Login";
import Register from "./pages/Register";
import ResumeUpload from "./pages/ResumeUpload";
import ViewApplications from "./pages/ViewApplications";

function App() {
  return (
    <Router>
      <AuthProvider>
        <Navbar />
        <Routes>
          <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/jobseeker/profile" element={<JobSeekerProfile />} />
        <Route path="/browse" element={<BrowseJobs />} />
        <Route path="/apply/:id" element={<ApplyJob />} />
        <Route path="/applications" element={<ViewApplications />} />
        <Route path="/resume" element={<ResumeUpload />} />
          <Route
            path="/dashboard"
            element={
              <ProtectedRoute>
                <h2 style={{ textAlign: "center" }}>Welcome to Dashboard</h2>
              </ProtectedRoute>
            }
          />
        </Routes>
      </AuthProvider>
    </Router>
  );
}

export default App;
