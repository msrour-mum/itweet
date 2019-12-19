package mum.itweet.model.view;

import mum.itweet.model.User;

import java.util.Date;

public class CommentDetail {

    private long id;
    private String commentText ;
    private Date creationDate;
    private User user ;
    private long postId ;


    public CommentDetail(long id, String commentText, Date creationDate, User user, long postId) {
        this.id = id;
        this.commentText = commentText;
        this.creationDate = creationDate;
        this.user = user;
        this.postId = postId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}
