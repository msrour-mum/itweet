package mum.itweet.model.dto;

import lombok.Data;
import mum.itweet.model.lookups.PostStatus;

import java.util.Date;

@Data
public class PostDto {

    private int id;
    private String postText;
    //private PostStatus status;
    private int userId;
    private String imageUrl;
    private String videoUrl;

    public PostDto(int id, String postText, int userId, String imageUrl, String videoUrl) {
        this.id = id;
        this.postText = postText;
        //this.status = status;
        this.userId = userId;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
