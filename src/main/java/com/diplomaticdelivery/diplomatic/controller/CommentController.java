package com.diplomaticdelivery.diplomatic.controller;

import com.diplomaticdelivery.diplomatic.request.CommentDTO;
import com.diplomaticdelivery.diplomatic.model.Comment;
import com.diplomaticdelivery.diplomatic.service.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post")
    @ApiOperation(value = "Register new client")
    public ResponseEntity<Object> registerUser(@RequestBody CommentDTO comment) {

        Comment response = commentService.postComment(comment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/list-all")
    public ResponseEntity <List<Comment>> getAllComment() {
        List<Comment> response = commentService.fetchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Object> deleteComment(@PathVariable("id") UUID id) {
        Comment response = commentService.deleteComment(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Object> updateComment(@PathVariable("id") UUID id, @RequestBody CommentDTO request) {
        Comment response = commentService.updateComment(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
