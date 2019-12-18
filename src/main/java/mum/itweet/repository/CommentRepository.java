package mum.itweet.repository;

import mum.itweet.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select * from Comment  where post_id =:postId",nativeQuery = true)
    public  List<Comment> findByPostId(@Param("postId") long postId);

    @Transactional
    @Query(value = "delete from comment where post_id=:postId ",nativeQuery = true)
    public void deleteByPostId(@Param("postId") long postId);

}
