package mum.itweet.model.dto;

import lombok.Data;

@Data
public class FollowingDto {
    private long id;
    private int followerId;
    private int followingId;

    public FollowingDto(long id, int followerId, int followingId) {
        this.id = id;
        this.followerId = followerId;
        this.followingId = followingId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public int getFollowingId() {
        return followingId;
    }

    public void setFollowingId(int followingId) {
        this.followingId = followingId;
    }
}
