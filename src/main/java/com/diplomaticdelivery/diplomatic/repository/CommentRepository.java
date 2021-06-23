package com.diplomaticdelivery.diplomatic.repository;

import com.diplomaticdelivery.diplomatic.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
