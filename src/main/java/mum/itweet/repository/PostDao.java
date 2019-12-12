package mum.itweet.repository;

import mum.itweet.model.Course;
import mum.itweet.model.Post;
import mum.itweet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostDao extends JpaRepository<Post, Long> {

    public List<Post> findByUserContains(User user);
    //public int getLikesCount(long id);
   // public  int countPostsByPostLikes(long );


}


