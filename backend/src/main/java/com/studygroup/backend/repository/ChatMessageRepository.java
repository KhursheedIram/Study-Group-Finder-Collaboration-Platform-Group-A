package com.studygroup.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b

import com.studygroup.backend.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByGroupIdOrderBySentAtAsc(Long groupId);
<<<<<<< HEAD
    @Modifying
    @Transactional
    @Query("DELETE FROM ChatMessage m WHERE m.group.id = :groupId")
    void deleteByGroupId(Long groupId);
    List<ChatMessage> findBySenderIdAndReceiverIdOrderBySentAtAsc(Long senderId, Long receiverId);
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
}
