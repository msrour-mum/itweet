package mum.itweet.repository;

import mum.itweet.model.Course;
import mum.itweet.model.Post;
import mum.itweet.model.PostLikes;
import mum.itweet.model.User;
import mum.itweet.model.lookups.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.user.id = ?0")
    public  List<Post> findByUserId(int userId);

    @Query(value ="select count(*) from post_likes where post_id= ?0", nativeQuery = true)
    public  int getLikesCount(long postId);

    @Query(value ="select count(*) from comment where post_id= ?0", nativeQuery = true)
    public  int getCommentsCount(long postId);


    public List<Post> findByStatusOrderByIdDesc(PostStatus postStatus);

    @Query(value ="select * from post p \n" +
            "where p.statusId=0 and (p.user_id=5 or p.user_id in\n" +
            "(select f.following_id from following f where f.follower_id=5))\n" +
            "order by p.publish_Date desc", nativeQuery = true)
    public  List<Post> listPostForUser(int userId) ;





}


