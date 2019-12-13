package mum.itweet.service;

import mum.itweet.model.Following;
import mum.itweet.model.User;
import mum.itweet.model.dto.FollowingDto;

import java.util.List;

public interface FollowingService {

    //Default
    public Following create(FollowingDto following);

    public Following get(long id);

    //public Following update(FollowingDto following);

    public void delete(long id);

    public List<Following> getAll();

    //Custom
    public List<User> listFollower(int userId);

    public List<User> listFollowing(int userId);

    public void unfollow(int followerId, int followingId);

    public Following addFollow(int followerId, int followingId);

}
