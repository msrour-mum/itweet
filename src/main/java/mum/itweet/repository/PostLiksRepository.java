package mum.itweet.repository;

import mum.itweet.model.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostLiksRepository extends JpaRepository<PostLikes, Long> {

    @Query(value = "select * from post_likes where post_id=?0",nativeQuery = true)
    public  List<PostLikes> findByPostId(long postId);

    @Query(value = "delete from post_likes where post_id=?1 ",nativeQuery = true)
    public void deleteByPostId(long postId);


}
