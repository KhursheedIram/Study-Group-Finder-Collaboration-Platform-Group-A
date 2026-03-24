import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import ProfileEdit from "./pages/ProfileEdit";
import Courses from "./pages/Courses";
import CreateGroup from "./pages/CreateGroup";
import GroupList from "./pages/GroupList";
import GroupDetail from "./pages/GroupDetail";
import PrivateRoute from "./components/PrivateRoute";
<<<<<<< HEAD
import ChatPage from "./pages/ChatPage";
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* Public routes */}
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />

        {/* Protected routes */}
        <Route path="/dashboard" element={<PrivateRoute><Dashboard /></PrivateRoute>} />
        <Route path="/profile-edit" element={<PrivateRoute><ProfileEdit /></PrivateRoute>} />
        <Route path="/courses" element={<PrivateRoute><Courses /></PrivateRoute>} />
        <Route path="/create-group" element={<PrivateRoute><CreateGroup /></PrivateRoute>} />
        <Route path="/groups" element={<PrivateRoute><GroupList /></PrivateRoute>} />
        <Route path="/groups/:id" element={<PrivateRoute><GroupDetail /></PrivateRoute>} />
<<<<<<< HEAD
        <Route path="/chat" element={<PrivateRoute><ChatPage /></PrivateRoute>} />
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
      </Routes>
    </BrowserRouter>
  );
}
