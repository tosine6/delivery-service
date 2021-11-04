package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.request.CommentDTO;
import com.diplomaticdelivery.diplomatic.model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    Comment postComment(CommentDTO comment);
    List<Comment> fetchAll();
    Comment deleteComment(UUID id);
    Comment updateComment (UUID id, CommentDTO request);

}
