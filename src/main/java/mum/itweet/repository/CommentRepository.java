package mum.itweet.repository;

import mum.itweet.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where post.id = ?0")
    public  List<Comment> findByPostId(long postIf);

}
