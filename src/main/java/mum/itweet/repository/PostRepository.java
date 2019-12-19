package mum.itweet.repository;

import java.util.List;

import mum.itweet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mum.itweet.model.Post;
import mum.itweet.model.lookups.PostStatus;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

	@Query(value = "SELECT * FROM post where user_id=:userId and statusId = 0 order by publishDate desc", nativeQuery = true)
	public List<Post> findByUserId(@Param("userId") int userId);

	@Query(value = "select count(1) from post_likes where post_id= :postId", nativeQuery = true)
	public int getLikesCount(@Param("postId") long postId);

	@Query(value = "select count(1) from comment where post_id= :postId", nativeQuery = true)
	public int getCommentsCount(@Param("postId") long postId);

	@Query(value = "select count(1) from post where statusId = 2 and user_id=:userId", nativeQuery = true)
	public int getDisabledPostCountPerUser(@Param("userId") int userId);

	public List<Post> findByStatusOrderByIdDesc(PostStatus postStatus);

	@Query(value = "select p.* from post p \n" + "where p.statusId=0 and (p.user_id=:userId or p.user_id in\n"
			+ "(select f.following_id from following f where f.follower_id=:userId))\n"
			+ "order by p.publishDate desc", nativeQuery = true)
	public List<Post> listPostForUser(@Param("userId") int userId);


	@Query(value = "select count(1) from post where statusId = 2 and user_id=:userId", nativeQuery = true)
	public int isContainBadWord(@Param("userId") int userId);


	@Query(value = "SELECT * FROM Post where postText like %?1% ", nativeQuery = true)
	public List<Post> searchPost(String txt);







}
