package mum.itweet.model.dto;

import lombok.Data;

@Data
public class PostLikesDto {

    private long id;
    private int userId;
    private long postId;
    private boolean isLike;

    public PostLikesDto(long id, int userId, long postId, boolean isLike) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.isLike = isLike;
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

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
