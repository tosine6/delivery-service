package com.diplomaticdelivery.diplomatic.request;

import com.diplomaticdelivery.diplomatic.model.Comment;
import com.diplomaticdelivery.diplomatic.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private String description;
    private String name;

    public static Comment map(CommentDTO request, User user){

        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setName("Anonymous");
        if(null != user){
            comment.setName(user.getName());
        }
        comment.setDescription(request.getDescription());
        return comment;
    }

    public static CommentDTO mapResponse(Comment comment){

        return CommentDTO.builder()
                .description(comment.getDescription())
                .name(comment.getName())
                .build();
    }
}
