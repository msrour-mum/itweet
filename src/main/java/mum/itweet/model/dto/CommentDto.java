package mum.itweet.model.dto;

import lombok.Data;

@Data
public class CommentDto {
   private int userId ;
   private int postId ;
   private String commentText ;

    public CommentDto(int userId, int postId, String commentText) {
        this.userId = userId;
        this.postId = postId;
        this.commentText = commentText;
    }
}
