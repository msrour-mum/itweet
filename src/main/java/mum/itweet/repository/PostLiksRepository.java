package mum.itweet.repository;

import mum.itweet.model.Comment;
import mum.itweet.model.Course;
import mum.itweet.model.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostLiksRepository extends JpaRepository<PostLikes, Long> {
    public List<PostLikes> findByPostId(long postId);
}
