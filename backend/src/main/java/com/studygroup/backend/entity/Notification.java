package com.studygroup.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
<<<<<<< HEAD
    @Column(nullable = false, length = 20)  // Increased length to 20
=======
    @Column(nullable = false)
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
    private NotificationType type;

    @Column(nullable = false, length = 500)
    private String message;

    @Enumerated(EnumType.STRING)
<<<<<<< HEAD
    @Column(nullable = false, length = 10)  // Added length for status too
=======
    @Column(nullable = false)
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
    private NotificationStatus status = NotificationStatus.UNREAD;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public enum NotificationType {
<<<<<<< HEAD
        REMINDER, 
        INVITATION, 
        JOIN_REQUEST, 
        JOIN_ACCEPTED, 
        JOIN_REJECTED, 
        MESSAGE
=======
        REMINDER, INVITATION, JOIN_REQUEST, JOIN_ACCEPTED, JOIN_REJECTED
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
    }

    public enum NotificationStatus {
        READ, UNREAD
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
