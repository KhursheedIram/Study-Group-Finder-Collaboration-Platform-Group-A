package com.studygroup.backend.service;

<<<<<<< HEAD
import java.util.Comparator;
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
<<<<<<< HEAD
import java.util.stream.Stream;
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b

import org.springframework.stereotype.Service;

import com.studygroup.backend.entity.ChatMessage;
import com.studygroup.backend.entity.StudyGroup;
import com.studygroup.backend.entity.User;
import com.studygroup.backend.repository.ChatMessageRepository;
import com.studygroup.backend.repository.StudyGroupRepository;
import com.studygroup.backend.repository.UserRepository;

@Service
<<<<<<< HEAD
@org.springframework.transaction.annotation.Transactional
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final StudyGroupRepository studyGroupRepository;
    private final UserRepository userRepository;

    public ChatService(ChatMessageRepository chatMessageRepository,
                       StudyGroupRepository studyGroupRepository,
                       UserRepository userRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.studyGroupRepository = studyGroupRepository;
        this.userRepository = userRepository;
    }

<<<<<<< HEAD
    @org.springframework.transaction.annotation.Transactional
    public Map<String, Object> saveMessage(Long groupId, String receiverEmail, String senderEmail, String content, String fileUrl, String fileName) {
        User sender = userRepository.findByEmail(senderEmail)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        ChatMessage msg = new ChatMessage();
        msg.setSender(sender);
        msg.setContent(content);
        msg.setFileUrl(fileUrl);
        msg.setFileName(fileName);

        if (groupId != null) {
            StudyGroup group = studyGroupRepository.findById(groupId)
                    .orElseThrow(() -> new RuntimeException("Group not found"));
            msg.setGroup(group);
        }

        if (receiverEmail != null && !receiverEmail.isEmpty() && groupId == null) {
            // Standalone Direct Message
            User receiver = userRepository.findByEmail(receiverEmail)
                    .orElseThrow(() -> new RuntimeException("Receiver not found"));
            msg.setReceiver(receiver);
            msg.setIsPrivate(true);
        } else if (groupId == null) {
            throw new RuntimeException("Direct message must have a receiver.");
        }
        // Group messages (groupId != null) are ALWAYS public now.
        // Even if receiverEmail was passed, we ignore it for group context as per user request.

        if (msg.getGroup() == null && msg.getReceiver() == null) {
            throw new RuntimeException("Message must have either a group or a receiver.");
        }

        System.out.println("Saving message: id=" + msg.getId() + ", isPrivate=" + msg.getIsPrivate() + ", receiver=" + (msg.getReceiver() != null ? msg.getReceiver().getEmail() : "null"));
        chatMessageRepository.save(msg);
        return toMessageMap(msg);
    }

    public List<Map<String, Object>> getGroupMessages(Long groupId, String principalEmail) {
        return chatMessageRepository.findByGroupIdOrderBySentAtAsc(groupId)
                .stream()
                // All group messages are now public to all group members
                .map(this::toMessageMap)
                .collect(Collectors.toList());
    }
    
    public List<Map<String, Object>> getDirectMessages(String currentUserEmail, String otherUserEmail) {
        User user1 = userRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        User user2 = userRepository.findByEmail(otherUserEmail)
                .orElseThrow(() -> new RuntimeException("Other user not found"));
        
        List<ChatMessage> messages = chatMessageRepository.findBySenderIdAndReceiverIdOrderBySentAtAsc(user1.getId(), user2.getId());
        messages.addAll(chatMessageRepository.findBySenderIdAndReceiverIdOrderBySentAtAsc(user2.getId(), user1.getId()));
        
        return messages.stream()
                .sorted((a, b) -> a.getSentAt().compareTo(b.getSentAt()))
                .map(this::toMessageMap)
                .collect(Collectors.toList());
    }
    
    public Map<String, Object> addReaction(Long messageId, String reaction, String userEmail) {
        ChatMessage msg = chatMessageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        // Simple implementation: "Emoji (Name)"
        msg.setReaction(reaction + " (" + user.getName() + ")");
        chatMessageRepository.save(msg);
        return toMessageMap(msg);
=======
    public Map<String, Object> saveMessage(Long groupId, String senderEmail, String content) {
        StudyGroup group = studyGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        User sender = userRepository.findByEmail(senderEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Only members OR the creator can chat
        boolean isCreator = group.getCreator() != null && group.getCreator().getId().equals(sender.getId());
        boolean isMember = group.getMembers().stream()
                .anyMatch(m -> m.getId().equals(sender.getId()));
        if (!isCreator && !isMember) throw new RuntimeException("You are not a member of this group.");

        ChatMessage msg = new ChatMessage();
        msg.setGroup(group);
        msg.setSender(sender);
        msg.setContent(content);
        chatMessageRepository.save(msg);

        return toMessageMap(msg);
    }

    public List<Map<String, Object>> getMessages(Long groupId) {
        return chatMessageRepository.findByGroupIdOrderBySentAtAsc(groupId)
                .stream().map(this::toMessageMap).collect(Collectors.toList());
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
    }

    private Map<String, Object> toMessageMap(ChatMessage msg) {
        Map<String, Object> m = new HashMap<>();
        m.put("id", msg.getId());
        m.put("content", msg.getContent());
<<<<<<< HEAD
        m.put("fileUrl", msg.getFileUrl());
        m.put("fileName", msg.getFileName());
        m.put("reaction", msg.getReaction());
=======
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
        m.put("sentAt", msg.getSentAt());
        m.put("senderId", msg.getSender().getId());
        m.put("senderName", msg.getSender().getName());
        m.put("senderEmail", msg.getSender().getEmail());
<<<<<<< HEAD
        
        if (msg.getGroup() != null) {
            m.put("groupId", msg.getGroup().getId());
        }
        
        boolean isPrivate = Boolean.TRUE.equals(msg.getIsPrivate());
        m.put("isPrivate", isPrivate);
        
        if (msg.getReceiver() != null) {
            m.put("receiverId", msg.getReceiver().getId());
            m.put("receiverName", msg.getReceiver().getName());
            m.put("receiverEmail", msg.getReceiver().getEmail());
        }
        
=======
        m.put("groupId", msg.getGroup().getId());
>>>>>>> f24badb73c4eef9d78621ade0d58b2757aeb202b
        return m;
    }
}
