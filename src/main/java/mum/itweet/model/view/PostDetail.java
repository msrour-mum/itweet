package mum.itweet.model.view;

import lombok.Data;
import mum.itweet.model.Comment;
import mum.itweet.model.User;
import mum.itweet.model.dto.CommentDto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class PostDetail {

    private long id;
    private User user;
    private String postText;
    private int statusId;
    private String imageUrl;
    private String videoUrl;
    private Date creationDate;
    private Date publishDate;
    private int likeCount;
    private int commentCount;
    private CommentDetail lastComment;


    public PostDetail(long id, User user, String postText, int statusId, String imageUrl, String videoUrl, Date creationDate, Date publishDate, int likeCount, int commentCount, CommentDetail lastComment) {
        this.id=id;
        this.user = user;
        this.postText = postText;
        this.statusId = statusId;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.creationDate = creationDate;
        this.publishDate = publishDate;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.lastComment = lastComment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public CommentDetail getLastComment() {
        return lastComment;
    }

    public void setLastComment(CommentDetail lastComment) {
        this.lastComment = lastComment;
    }
}
