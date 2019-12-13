package mum.itweet.model.dto;

import lombok.Data;

@Data
public class CommentDto {

   private long id;
   private int userId ;
   private long postId ;
   private String commentText ;

    public CommentDto(long id, int userId, long postId, String commentText) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.commentText = commentText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
