import { useState, useEffect, useRef } from "react";
import api from "../api";
import "./NotificationBell.css";

export default function NotificationBell() {
  const [count, setCount] = useState(0);
  const [notifications, setNotifications] = useState([]);
  const [open, setOpen] = useState(false);
  const ref = useRef(null);

  const fetchCount = async () => {
    try {
<<<<<<< HEAD
      console.log("🔔 Fetching notification count...");
      const res = await api.get("/api/notifications/unread-count");
      console.log("📊 Unread count:", res.data.count);
      setCount(res.data.count || 0);
    } catch (error) {
      console.error("❌ Error fetching notification count:", error);
    }
=======
      const res = await api.get("/api/notifications/unread-count");
      setCount(res.data.count || 0);
    } catch {}
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
  };

  const fetchNotifications = async () => {
    try {
<<<<<<< HEAD
      console.log("🔔 Fetching notifications...");
      const res = await api.get("/api/notifications");
      console.log("📋 Notifications:", res.data);
      setNotifications(res.data);
    } catch (error) {
      console.error("❌ Error fetching notifications:", error);
    }
  };

  // Poll for new notifications every 5 seconds
  useEffect(() => {
    fetchCount();
    const interval = setInterval(fetchCount, 5000); // poll every 5 seconds
=======
      const res = await api.get("/api/notifications");
      setNotifications(res.data);
    } catch {}
  };

  useEffect(() => {
    fetchCount();
    const interval = setInterval(fetchCount, 30000); // poll every 30s
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
    return () => clearInterval(interval);
  }, []);

  useEffect(() => {
    const handleClickOutside = (e) => {
      if (ref.current && !ref.current.contains(e.target)) setOpen(false);
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  const handleOpen = async () => {
    if (!open) {
      await fetchNotifications();
    }
    setOpen(!open);
  };

  const handleMarkAllRead = async () => {
    try {
      await api.post("/api/notifications/read-all");
      setCount(0);
      setNotifications(prev => prev.map(n => ({ ...n, status: "READ" })));
<<<<<<< HEAD
    } catch (error) {
      console.error("❌ Error marking all as read:", error);
    }
=======
    } catch {}
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
  };

  const typeIcon = (type) => {
    switch (type) {
      case "REMINDER":     return <i className="bi bi-alarm-fill" />;
      case "INVITATION":   return <i className="bi bi-envelope-fill" />;
      case "JOIN_REQUEST": return <i className="bi bi-person-plus-fill" />;
      case "JOIN_ACCEPTED":return <i className="bi bi-check-circle-fill" />;
      case "JOIN_REJECTED":return <i className="bi bi-x-circle-fill" />;
<<<<<<< HEAD
      case "MESSAGE":      return <i className="bi bi-chat-fill" />;
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
      default:             return <i className="bi bi-megaphone-fill" />;
    }
  };

  return (
    <div className="nb-wrapper" ref={ref}>
      <button className="nb-bell-btn" onClick={handleOpen} title="Notifications">
        <i className="bi bi-bell-fill" />
        {count > 0 && <span className="nb-badge">{count > 99 ? "99+" : count}</span>}
      </button>

      {open && (
        <div className="nb-dropdown">
          <div className="nb-header">
            <strong>Notifications</strong>
            {count > 0 && (
              <button className="nb-mark-all" onClick={handleMarkAllRead}>
                Mark all read
              </button>
            )}
          </div>
          <div className="nb-list">
<<<<<<< HEAD
            {notifications.length === 0 ? (
              <p className="nb-empty">No notifications yet.</p>
            ) : (
              notifications.map((n) => (
                <div key={n.id} className={`nb-item ${n.status === "UNREAD" ? "nb-unread" : ""}`}>
                  <div className="nb-icon-wrap">
                    <span className="nb-icon">{typeIcon(n.type)}</span>
                  </div>
                  <div className="nb-body">
                    <p>{n.message}</p>
                    <span className="nb-time">
                      {n.createdAt ? new Date(n.createdAt).toLocaleString([], { 
                        month: 'short', 
                        day: 'numeric', 
                        hour: '2-digit', 
                        minute: '2-digit' 
                      }) : ""}
                    </span>
                  </div>
                  {n.status === "UNREAD" && <span className="nb-dot" />}
                </div>
              ))
            )}
=======
            {notifications.length === 0 && (
              <p className="nb-empty">No notifications yet.</p>
            )}
            {notifications.map((n) => (
              <div key={n.id} className={`nb-item ${n.status === "UNREAD" ? "nb-unread" : ""}`}>
                <div className="nb-icon-wrap">
                  <span className="nb-icon">{typeIcon(n.type)}</span>
                </div>
                <div className="nb-body">
                  <p>{n.message}</p>
                  <span className="nb-time">
                    {n.createdAt ? new Date(n.createdAt).toLocaleString([], { dateStyle: "short", timeStyle: "short" }) : ""}
                  </span>
                </div>
                {n.status === "UNREAD" && <span className="nb-dot" />}
              </div>
            ))}
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
          </div>
        </div>
      )}
    </div>
  );
<<<<<<< HEAD
}
=======
}
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
