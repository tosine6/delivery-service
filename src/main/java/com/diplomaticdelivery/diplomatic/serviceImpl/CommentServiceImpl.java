package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.request.CommentDTO;
import com.diplomaticdelivery.diplomatic.model.Comment;
import com.diplomaticdelivery.diplomatic.model.User;
import com.diplomaticdelivery.diplomatic.repository.CommentRepository;
import com.diplomaticdelivery.diplomatic.repository.UserRepository;
import com.diplomaticdelivery.diplomatic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment postComment(CommentDTO request) {

//        User user = userRepository.findById(request.getAuthor())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id!!!s"));
        Comment newComment = new Comment();
//        newComment.setAuthor(user);
        newComment.setDescription(request.getDescription());
        newComment.setName(request.getName());

        return commentRepository.save(newComment);
    }

    @Override
    public List<Comment> fetchAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment deleteComment(UUID id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment does not exist"));
        commentRepository.delete(comment);
        return comment;
    }

    @Override
    public Comment updateComment(UUID id, CommentDTO request) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment does not exist"));
        User existingUser = userRepository.getById(id);

        if(null != request.getDescription())
            comment.setDescription(request.getDescription());
        if(null != request.getName())
            if(null != existingUser){
                comment.setName(existingUser.getName());
            }else {
                comment.setName("Anonymous");
            }
        if(null != existingUser){
            comment.setAuthor(existingUser);
        }
        return comment;
    }

}
