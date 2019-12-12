package mum.itweet.service;

import mum.itweet.model.Post;
import mum.itweet.model.User;

import java.util.List;

public interface PostService {

    public Post create(Post post);

    public Post get(long id);

    public Post update(Post post);

    public void delete(long id);

    public List<Post> getAll();

    public List<Post> findByUserContains(User user);

   // public int getLikesCount(long id);
}
