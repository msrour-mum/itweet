package mum.itweet.repository;

import mum.itweet.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select * from Comment  where post_id = ?0",nativeQuery = true)
    public  List<Comment> findByPostId(long postIf);

}
