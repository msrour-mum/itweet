package mum.itweet.repository;

import mum.itweet.model.Following;
import mum.itweet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowingRepository extends JpaRepository<Following,Long> {

    @Query(value = "Select u.* from following f inner join user u on u.id=f.follower_id where f.following_id=?0", nativeQuery = true)
    public List<User> ListFollower(int userId);

    @Query(value = "Select u.* from following f inner join user u on u.id=f.following_id where f.follower_id=?0", nativeQuery = true)
    public List<User> ListFollowing(int userId);


    public void deleteByFollowerIdAndFollowingId(int followerId, int followingId);
}
