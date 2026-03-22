package com.studygroup.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b

import com.studygroup.backend.entity.JoinRequest;
import com.studygroup.backend.entity.JoinRequest.RequestStatus;

public interface JoinRequestRepository extends JpaRepository<JoinRequest, Long> {
    List<JoinRequest> findByGroupIdAndStatus(Long groupId, RequestStatus status);
<<<<<<< HEAD
    @Modifying
    @Transactional
    @Query("DELETE FROM JoinRequest j WHERE j.group.id = :groupId")
    void deleteByGroupId(Long groupId);
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
    Optional<JoinRequest> findByGroupIdAndUserId(Long groupId, Long userId);
    List<JoinRequest> findByUserIdOrderByCreatedAtDesc(Long userId);
    boolean existsByGroupIdAndUserIdAndStatus(Long groupId, Long userId, RequestStatus status);
}
