package mum.itweet.model.view;

import lombok.Data;
import mum.itweet.model.Comment;
import mum.itweet.model.dto.CommentDto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class PostDetail {

    private long id;
    private int userId;
    private String postText;
    private int statusId;
    private String imageUrl;
    private String videoUrl;
    private Date creationDate;
    private Date publishDate;
    private int likeCount;
    private int commentCount;
    private CommentDto lastComment;


    public PostDetail(long id, int userId, String postText, int statusId, String imageUrl, String videoUrl, Date creationDate, Date publishDate, int likeCount, int commentCount, CommentDto lastComment) {
        this.id=id;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public CommentDto getLastComment() {
        return lastComment;
    }

    public void setLastComment(CommentDto lastComment) {
        this.lastComment = lastComment;
    }
}
